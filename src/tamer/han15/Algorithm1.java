package tamer.han15;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.stat.StatUtils;

/**
 * class to implement algorithm 1 in pages 8-9
 *
 * @author Tamer Kulaksizoglu
 */
public class Algorithm1 {

    // <editor-fold defaultstate="collapsed" desc="fields">
    private int B;
    private final ConcentratedLeastSquares cls;
    private double criticalvalue;
    private double FStat;
    private int n;
    private final OrdinaryLeastSquares ols;
    private double percentile;
    private double pvalue;
    private final MersenneTwister rng;
    private long seed;
    private double[] Tn;
    private RealVector x;
    private RealVector y;
    private RealVector ys;
    private RealMatrix Z;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="constructor">
    public Algorithm1() {
        B = 1000;
        cls = new ConcentratedLeastSquares();
        criticalvalue = Double.NaN;
        FStat = Double.NaN;
        n = 0;
        ols = new OrdinaryLeastSquares();
        percentile = 90;
        pvalue = Double.NaN;
        rng = new MersenneTwister();
        seed = 1;
        Tn = null;
        x = null;
        y = null;
        ys = null;
        Z = null;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="get methods">
    public double getCriticalValue() {
        return criticalvalue;
    }

    public double getFStat() {
        return FStat;
    }

    public double getPValue() {
        return pvalue;
    }

    public int getSampleSize() {
        return n;
    }

    public long getSeed() {
        return seed;
    }

    public RealVector getX() {
        return x;
    }

    public RealVector getY() {
        return y;
    }

    public RealMatrix getZ() {
        return Z;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="set methods">
    public void setPercentile(double percentile) {
        this.percentile = percentile;
    }

    public void setReplicationCount(int B) {
        this.B = B;
        Tn = new double[B];
    }

    public void setSeed(long seed) {
        this.seed = seed;
        rng.setSeed(seed);
    }

    public void setX(RealVector x) {
        this.x = x;
        cls.setX(x);
        ols.setX(x);
    }

    public void setY(RealVector y) {
        this.y = y;
        cls.setY(y);
        ols.setY(y);
        n = y.getDimension();
        ys = new ArrayRealVector(n);
    }

    public void setZ(RealMatrix Z) {
        this.Z = Z;
        cls.setZ(Z);
        ols.setZ(Z);
    }
    // </editor-fold>

    public void simulate() {
        // estimate ordinary least squares
        ols.estimateCoef();
        ols.estimateYhat();
        ols.estimateResid();
        ols.estimateRSS();
        ols.estimateSigmaSq();
        double sigmaSqTilde = ols.getSigmaSq();
        // estimate concentrated least squares
        cls.gridSearch();
        cls.estimateCoef();
        cls.estimateYhat();
        cls.estimateResid();
        cls.estimateRSS();
        cls.estimateSigmaSq();
        double sigmaSqHat = cls.getSigmaSq();
        // calculate test statistic
        FStat = n * (sigmaSqTilde - sigmaSqHat) / sigmaSqHat;
        // estimate ols residuals
        ols.estimateCoef();
        ols.estimateYhat();
        ols.estimateResid();
        RealVector e = ols.getResid();
        int counter = 0;
        for (int b = 0; b < B; b++) {
            // steps 1 and 2
            for (int i = 0; i < n; i++) {
                ys.setEntry(i, e.getEntry(i) * rng.nextGaussian());
            }
            // step 3
            ols.setY(ys);
            ols.estimateCoef();
            ols.estimateYhat();
            ols.estimateResid();
            ols.estimateRSS();
            ols.estimateSigmaSq();
            sigmaSqTilde = ols.getSigmaSq();
            cls.setY(ys);
            cls.gridSearch();
            cls.estimateCoef();
            cls.estimateYhat();
            cls.estimateResid();
            cls.estimateRSS();
            cls.estimateSigmaSq();
            sigmaSqHat = cls.getSigmaSq();
            Tn[b] = n * (sigmaSqTilde - sigmaSqHat) / sigmaSqHat;
            // p-value calculation
            if (Tn[b] >= FStat) {
                counter++;
            }
        }
        criticalvalue = StatUtils.percentile(Tn, percentile);
        pvalue = (double) counter / B;
    }
}

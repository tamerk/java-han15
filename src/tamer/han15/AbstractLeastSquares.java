package tamer.han15;

import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/**
 * abstract class for least squares
 *
 * @author Tamer Kulaksizoglu
 */
public abstract class AbstractLeastSquares {

    // <editor-fold defaultstate="collapsed" desc="fields">
    protected RealVector coef;
    protected RealVector coefSE;
    protected RealVector coefT;
    protected RealVector coefV;
    protected RealMatrix coefVC;
    protected int df;
    protected RealVector grid;
    protected int k;
    protected int n;
    protected String name;
    protected QRDecomposition qr;
    protected RealVector resid;
    protected double rss;
    protected double sigmaSq;
    protected double t;
    protected double tSE;
    protected RealVector x;
    protected RealMatrix xZ;
    protected RealMatrix xZtxZ;
    protected RealMatrix xZtxZi;
    protected RealVector xZty;
    protected RealVector y;
    protected RealVector yhat;
    protected RealMatrix Z;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="constructor">
    public AbstractLeastSquares() {
        coef = null;
        coefSE = null;
        coefT = null;
        coefV = null;
        coefVC = null;
        df = 0;
        grid = null;
        k = 0;
        n = 0;
        name = "";
        qr = null;
        resid = null;
        rss = Double.NaN;
        sigmaSq = Double.NaN;
        t = Double.NaN;
        tSE = Double.NaN;
        x = null;
        xZ = null;
        xZtxZ = null;
        xZtxZi = null;
        xZty = null;
        y = null;
        yhat = null;
        Z = null;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="get methods">
    public RealVector getCoef() {
        return coef;
    }

    public RealVector getCoefSE() {
        return coefSE;
    }

    public RealVector getCoefT() {
        return coefT;
    }

    public RealVector getCoefV() {
        return coefV;
    }

    public RealMatrix getCoefVC() {
        return coefVC;
    }

    public int getDF() {
        return df;
    }

    public RealVector getGrid() {
        return grid;
    }

    public int getK() {
        return k;
    }

    public int getN() {
        return n;
    }

    public String getName() {
        return name;
    }

    public RealVector getResid() {
        return resid;
    }

    public double getRSS() {
        return rss;
    }

    public double getSigmaSq() {
        return sigmaSq;
    }

    public double getT() {
        return t;
    }

    public double getTSE() {
        return tSE;
    }

    public RealVector getX() {
        return x;
    }

    public RealMatrix getXZ() {
        return xZ;
    }

    public RealMatrix getXZtXZi() {
        return xZtxZi;
    }

    public RealVector getY() {
        return y;
    }

    public RealVector getYhat() {
        return yhat;
    }

    public RealMatrix getZ() {
        return Z;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="set methods">
    public void setGrid(RealVector grid) {
        this.grid = grid;
    }

    public void setX(RealVector x) {
        this.x = x;
    }

    public void setY(RealVector y) {
        this.y = y;
        n = y.getDimension();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="abstract methods">
    public abstract void estimateCoef();

    public abstract void estimateCoefVC();

    public abstract void setZ(RealMatrix Z);
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="concrete methods">
    public void estimate() {
        this.estimateCoef();
        this.estimateYhat();
        this.estimateResid();
        this.estimateRSS();
        this.estimateSigmaSq();
        this.estimateCoefVC();
        this.estimateCoefV();
        this.estimateCoefSE();
        this.estimateCoefT();
    }

    public void estimateCoefV() {
        Misc.getDiagonal(coefVC, coefV);
    }

    public void estimateCoefSE() {
        Misc.sqrt(coefV, coefSE);
    }

    public void estimateCoefT() {
        coefT = coef.ebeDivide(coefSE);
    }

    public void estimateResid() {
        resid = y.subtract(yhat);
    }

    public void estimateRSS() {
        rss = resid.dotProduct(resid);
    }

    public void estimateSigmaSq() {
        sigmaSq = rss / n;
    }

    public void estimateYhat() {
        yhat = xZ.operate(coef);
    }
    // </editor-fold>

}

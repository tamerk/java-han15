package tamer.han15;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.stat.StatUtils;

public class MainAlgorithm1 {

    public static void main(String[] args) {

        ModelData modelData = new ModelData();
        RealVector x = modelData.getX();
        RealVector y = modelData.getY();
        RealMatrix Z = modelData.getZ();

        OrdinaryLeastSquares ols = new OrdinaryLeastSquares();
        ols.setX(x);
        ols.setY(y);
        ols.setZ(Z);
        ols.estimateCoef();
        ols.estimateYhat();
        ols.estimateResid();
        RealVector e = ols.getResid();

        ConcentratedLeastSquares cls = new ConcentratedLeastSquares();
        cls.setX(x);
        cls.setY(y);
        cls.setZ(Z);
        cls.gridSearch();

        final int seed = 12;
        MersenneTwister mt = new MersenneTwister(seed);
        final int n = 218;
        RealVector ys = new ArrayRealVector(n);
        final int B = 10000;
        double[] Tn = new double[B];
        int counter = 0;

        for (int b = 0; b < B; b++) {
            for (int i = 0; i < n; i++) {
                ys.setEntry(i, e.getEntry(i) * mt.nextGaussian());
                //ys.setEntry(i, y.getEntry(i));
            }

            ols.setY(ys);
            ols.estimateCoef();
            ols.estimateYhat();
            ols.estimateResid();
            ols.estimateRSS();
            ols.estimateSigmaSq();
            double sigmaSqTilde = ols.getSigmaSq();

            cls.setY(ys);
            cls.gridSearch();
            cls.estimateCoef();
            cls.estimateYhat();
            cls.estimateResid();
            cls.estimateRSS();
            cls.estimateSigmaSq();
            double sigmaSqHat = cls.getSigmaSq();

            Tn[b] = n * (sigmaSqTilde - sigmaSqHat) / sigmaSqHat;

            if (Tn[b] >= 5.66) {
                counter++;
            }
        }
        System.out.println(StatUtils.percentile(Tn, 90));
        System.out.println((double) counter / B);
    }

}

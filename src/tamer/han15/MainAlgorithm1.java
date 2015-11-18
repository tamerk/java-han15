package tamer.han15;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class MainAlgorithm1 {

    public static void main(String[] args) {

        ModelData modelData = new ModelData();
        RealVector x = modelData.getX();
        RealVector y = modelData.getY();
        RealMatrix Z = modelData.getZ();

        Algorithm1 alg1 = new Algorithm1();
        alg1.setReplicationCount(10000);
        alg1.setSeed(1);
        alg1.setX(x);
        alg1.setY(y);
        alg1.setZ(Z);
        alg1.simulate();
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println("F-Statistic:\t" + formatter.format(alg1.getFStat()));
        System.out.println("Critical Value:\t" + formatter.format(alg1.getCriticalValue()));
        System.out.println("P-value:\t" + formatter.format(alg1.getPValue()));

    }
}

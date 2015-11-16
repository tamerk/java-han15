package tamer.han15;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.FastMath;

public class Misc {

    public static void concatenate(RealVector x, RealMatrix Z, RealMatrix xZ) {
        int numCols = Z.getColumnDimension();
        int numRows = x.getDimension();
        for (int row = 0; row < numRows; row++) {
            xZ.setEntry(row, 0, x.getEntry(row));
            for (int col = 0; col < numCols; col++) {
                xZ.setEntry(row, col + 1, Z.getEntry(row, col));
            }
        }
    }

    public static void dotMultiply(RealMatrix M, RealVector v, RealMatrix Mv) {
        for (int row = 0; row < M.getRowDimension(); row++) {
            for (int col = 0; col < M.getColumnDimension(); col++) {
                Mv.setEntry(row, col, M.getEntry(row, col) * v.getEntry(row));
            }
        }
    }

    public static void getDiagonal(RealMatrix sqMat, RealVector diag) {
        for (int i = 0; i < sqMat.getRowDimension(); i++) {
            diag.setEntry(i, sqMat.getEntry(i, i));
        }
    }

    public static void print(RealMatrix mat) {
        for (int row = 0; row < mat.getRowDimension(); row++) {
            for (int col = 0; col < mat.getColumnDimension(); col++) {
                System.out.print(mat.getEntry(row, col) + ", ");
            }
            System.out.println("");
        }
    }

    public static void sqrt(RealVector vec, RealVector sqrt) {
        for (int i = 0; i < vec.getDimension(); i++) {
            sqrt.setEntry(i, FastMath.sqrt(vec.getEntry(i)));
        }
    }
}

package tamer.han15;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.util.FastMath;

/**
 * class for concentrated least squares
 *
 * @author Tamer Kulaksizoglu
 */
public class ConcentratedLeastSquares extends AbstractLeastSquares {

    public ConcentratedLeastSquares() {
        super();
        name = "Concentrated Least Squares";
    }

    @Override
    public void estimateCoef() {
        t = 43.8;
        double diff, negValue, posValue;
        for (int i = 0; i < n; i++) {
            diff = x.getEntry(i) - t;
            negValue = FastMath.min(0, diff);
            posValue = FastMath.max(0, diff);
            xZ.setEntry(i, 0, negValue);
            xZ.setEntry(i, 1, posValue);
        }
        xZtxZ = xZ.transpose().multiply(xZ);
        xZty = xZ.transpose().operate(y);
        qr = new QRDecomposition(xZtxZ);
        coef = qr.getSolver().solve(xZty);
    }

    @Override
    public void estimateCoefVC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setZ(RealMatrix Z) {
        this.Z = Z;
        k = Z.getColumnDimension() + 2; // + 2: for x- and x+
        xZ = new Array2DRowRealMatrix(Z.getRowDimension(), k);
        for (int row = 0; row < Z.getRowDimension(); row++) {
            for (int col = 0; col < Z.getColumnDimension(); col++) {
                xZ.setEntry(row, col + 2, Z.getEntry(row, col));
            }
        }
    }

}

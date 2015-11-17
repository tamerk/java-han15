package tamer.han15;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * class for ordinary least squares
 *
 * @author Tamer Kulaksizoglu
 */
public class OrdinaryLeastSquares extends AbstractLeastSquares {

    // <editor-fold defaultstate="collapsed" desc="field">
    private RealMatrix xZe;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="constructor">
    public OrdinaryLeastSquares() {
        super();
        name = "Ordinary Least Squares";
        xZe = null;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="overridden methods">
    @Override
    public void estimateCoef() {
        xZ.setColumnVector(0, x);
        xZtxZ = xZ.transpose().multiply(xZ);
        xZty = xZ.transpose().operate(y);
        qr = new QRDecomposition(xZtxZ);
        coef = qr.getSolver().solve(xZty);
    }

    @Override
    public void estimateCoefVC() {
        xZtxZi = qr.getSolver().getInverse();
        Misc.dotMultiply(xZ, resid, xZe);
        RealMatrix xZetxZe = xZe.transpose().multiply(xZe);
        df = n - k;
        coefVC = xZtxZi.multiply(xZetxZe).multiply(xZtxZi).scalarMultiply((double) n / df);
    }

    @Override
    public void setZ(RealMatrix Z) {
        this.Z = Z;
        k = Z.getColumnDimension() + 1; // + 1: for x
        xZ = new Array2DRowRealMatrix(Z.getRowDimension(), k);
        // populate xZ with Z
        for (int row = 0; row < Z.getRowDimension(); row++) {
            for (int col = 0; col < Z.getColumnDimension(); col++) {
                xZ.setEntry(row, col + 1, Z.getEntry(row, col));
            }
        }
        xZe = new Array2DRowRealMatrix(xZ.getRowDimension(), xZ.getColumnDimension());
        coefV = new ArrayRealVector(k);
        coefSE = new ArrayRealVector(k);
    }
    // </editor-fold>

}

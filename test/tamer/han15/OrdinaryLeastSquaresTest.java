package tamer.han15;

import org.junit.Assert;
import org.junit.Test;

/**
 * unit test for ordinary least squares
 *
 * @author Tamer Kulaksizoglu
 */
public class OrdinaryLeastSquaresTest {

    private final OrdinaryLeastSquares ols;
    private final ModelData modelData;

    public OrdinaryLeastSquaresTest() {

        ols = new OrdinaryLeastSquares();
        modelData = new ModelData();
        ols.setX(modelData.getX());
        ols.setY(modelData.getY());
        ols.setZ(modelData.getZ());
    }

    @Test
    public void test_estimateCoef() {
        ols.estimateCoef();
        double[] actual = ols.getCoef().toArray();
        double[] expected = new double[]{-0.00801902107284386, 0.30030685856318828, 2.89784787743453798};
        Assert.assertArrayEquals(expected, actual, 1e-14);
    }

    @Test
    public void test_estimateRSS() {
        ols.estimateCoef();
        ols.estimateYhat();
        ols.estimateResid();
        ols.estimateRSS();
        double actual = ols.getRSS();
        double expected = 3835.3025371254;
        Assert.assertEquals(expected, actual, 1e-11);
    }

    @Test
    public void test_estimateSigmaSq() {
        ols.estimateCoef();
        ols.estimateYhat();
        ols.estimateResid();
        ols.estimateRSS();
        ols.estimateSigmaSq();
        double actual = ols.getSigmaSq();
        double expected = 17.5931309042449;
        Assert.assertEquals(expected, actual, 1e-13);
    }

    @Test
    public void test_estimateCoefSE() {
        ols.estimate();
        double[] actual = ols.getCoefSE().toArray();
        double[] expected = new double[]{0.0130245527533581, 0.0896267223859687, 0.6235662523711668};
        Assert.assertArrayEquals(expected, actual, 1e-14);
    }

}

package tamer.han15;

import org.junit.Assert;
import org.junit.Test;

/**
 * unit test for concentrated least squares
 *
 * @author Tamer Kulaksizoglu
 */
public class ConcentratedLeastSquaresTest {

    private final ConcentratedLeastSquares cls;
    private final ModelData modelData;

    public ConcentratedLeastSquaresTest() {

        cls = new ConcentratedLeastSquares();
        modelData = new ModelData();
        cls.setX(modelData.getX());
        cls.setY(modelData.getY());
        cls.setZ(modelData.getZ());
    }

    @Test
    public void test_estimateCoef() {
        cls.estimateCoef();
        double[] actual = cls.getCoef().toArray();
        double[] expected = new double[]{0.0334935012175448, -0.0671522918268750, 0.2786041077439921, 3.7821758914680230};
        Assert.assertArrayEquals(expected, actual, 1e-14);
    }

}

package tamer.han15;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.apache.commons.math3.linear.RealVector;

/**
 * class for Figure 2 in page 4
 *
 * @author Tamer Kulaksizoglu
 */
public class MainFigure2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        ModelData modelData = new ModelData();
        RealVector x = modelData.getX(); // debt/gdp
        RealVector y = modelData.getY(); // gdp growth rate

        stage.setTitle("Figure 2");
        final NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Debt/GDP");
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("GDP Growth Rate");
        final ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
        scatterChart.setHorizontalZeroLineVisible(false);
        //scatterChart.setTitle("GDP Growth Rate vs. Debt/GDP");

        XYChart.Series series = new XYChart.Series();
        series.setName("GDP Growth Rate vs. Debt/GDP");

        for (int i = 0; i < x.getDimension(); i++) {
            series.getData().add(new XYChart.Data(x.getEntry(i), y.getEntry(i)));
        }

        scatterChart.getData().add(series);
        Scene scene = new Scene(scatterChart, 500, 400);
        scene.getStylesheets().add("resources/css/Figure2.css");
        stage.setScene(scene);
        stage.show();

    }

}

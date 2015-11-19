package tamer.han15;

import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * class for Figure 1 in page 2
 *
 * @author Tamer Kulaksizoglu
 */
public class MainFigure1 extends Application {

    private List<Double[]> list;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // read data
        list = Misc.readData("src\\tamer\\han15\\USData");
        // line chart 1
        CategoryAxis xAxis1 = new CategoryAxis();
        xAxis1.setLabel("Year");
        xAxis1.setTickMarkVisible(false);
        NumberAxis yAxis1 = new NumberAxis();
        yAxis1.setLabel("GDP Growth Rate");
        yAxis1.setMinorTickCount(0);
        LineChart lineChart1 = new LineChart(xAxis1, yAxis1);
        lineChart1.setData(getGrowthData());
        lineChart1.setTitle("GDP Growth Rate by Year");
        lineChart1.setCreateSymbols(false);
        lineChart1.setHorizontalGridLinesVisible(false);
        lineChart1.setVerticalGridLinesVisible(false);
        lineChart1.setHorizontalZeroLineVisible(false);
        // line chart 2
        CategoryAxis xAxis2 = new CategoryAxis();
        xAxis2.setLabel("Year");
        xAxis2.setTickMarkVisible(false);
        NumberAxis yAxis2 = new NumberAxis();
        yAxis2.setLabel("Debt/GDP");
        yAxis2.setMinorTickCount(0);
        LineChart lineChart2 = new LineChart(xAxis2, yAxis2);
        lineChart2.setData(getDebtData());
        lineChart2.setTitle("Debt/GDP by Year");
        lineChart2.setCreateSymbols(false);
        lineChart2.setHorizontalGridLinesVisible(false);
        lineChart2.setVerticalGridLinesVisible(false);
        // chart layout
        HBox hBox = new HBox();
        hBox.getChildren().addAll(lineChart1, lineChart2);
        StackPane root = new StackPane();
        root.getChildren().add(hBox);
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.setTitle("Figure 1");
        primaryStage.show();
//        // save the file as jpeg (axis labels are missing!!!)
//        WritableImage snapShot = root.snapshot(null, null);
//        ImageIO.write(SwingFXUtils.fromFXImage(snapShot, null), "png",
//                new File("C:\\Tamer\\My_Articles\\Replications\\Hansen_2015\\Figure1.png"));

    }

    private ObservableList<XYChart.Series<String, Double>> getDebtData() {
        ObservableList<XYChart.Series<String, Double>> answer
                = FXCollections.observableArrayList();
        Series<String, Double> series = new Series<>();
        series.setName("Debt");
        for (int n = 0; n < list.size(); n++) {
            series.getData().add(new XYChart.Data(
                    list.get(n)[0].toString().replace(".0", ""), list.get(n)[1]));
        }
        answer.addAll(series);
        return answer;
    }

    private ObservableList<XYChart.Series<String, Double>> getGrowthData() {
        ObservableList<XYChart.Series<String, Double>> answer
                = FXCollections.observableArrayList();
        Series<String, Double> series = new Series<>();
        series.setName("Growth");
        for (int n = 0; n < list.size(); n++) {
            series.getData().add(new XYChart.Data(
                    list.get(n)[0].toString().replace(".0", ""), list.get(n)[2]));
        }
        answer.addAll(series);
        return answer;
    }
}

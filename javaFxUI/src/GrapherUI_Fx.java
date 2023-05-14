import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.knowm.xchart.internal.series.Series;

import static javafx.geometry.HPos.CENTER;

public class GrapherUI_Fx extends Application {
    TextField textLeftBound = new TextField("-5");
    TextField textRightBound = new TextField("5");
    TextField textDelta = new TextField("0.1");
    ComboBox<String> availableFunctions = new ComboBox<>();

    TextArea textArea = new TextArea();
    Button button = new Button("Compute");
    NumberAxis xAxis = new NumberAxis();
    NumberAxis yAxis = new NumberAxis();
    LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);

    XYChart.Series<Number, Number> series = new XYChart.Series<>();
    XYChart.Series<Number, Number> derivativeSeries = new XYChart.Series<>();

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        HBox inputPanel = new HBox();
        inputPanel.setSpacing(10);
        inputPanel.getChildren().addAll(
                new Label("Left bound:"), textLeftBound,
                new Label("Right bound:"), textRightBound,
                new Label("Delta:"), textDelta
        );
        root.setTop(inputPanel);

        VBox outputPanel = new VBox();

        outputPanel.setSpacing(10);
        outputPanel.getChildren().addAll(
                new HBox(
                    new Label("f(x)="), availableFunctions
                )
        );

        textArea.setWrapText(true);
        textArea.setMaxHeight(100.0);
        outputPanel.getChildren().addAll(new Label("derivative"), textArea);

        root.setBottom(outputPanel);
        chart.setStyle("-fx-stroke-type: centered;");
        chart.setTitle("f(x) | f'(x)");
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        chart.setLegendVisible(false);
        chart.setAnimated(false);
        chart.setCreateSymbols(false);
        chart.getData().addAll(series, derivativeSeries);
        root.setLeft(chart);

        HBox buttonPanel = new HBox();
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.getChildren().add(button);
        buttonPanel.setPadding(new Insets(10, 0, 0, 0));
        root.setCenter(buttonPanel);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Grapher JavaFX");
        primaryStage.show();
    }

}
package gui.javafx;
import App.Function;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.ArrayList;

public class javafx extends Application {

    private ComboBox<String> functionComboBox;
    private TextField pointTextField;
    private LineChart<Number, Number> chart;

    private Function[] functions;

    public javafx(Function... functions) {
        this.functions = functions;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create a ComboBox with the three functions
        functionComboBox = new ComboBox<>();
        for (Function function:
             functions) {
            functionComboBox.getItems().add(function.toPrettyString(NumberFormat.getInstance()));
        }

        // Create a TextField for entering a point
        Label pointLabel = new Label("Point:");
        pointTextField = new TextField();

        // Create buttons for calculating the derivative and drawing the graph
        Button derivativeButton = new Button("Calculate Derivative");
        derivativeButton.setOnAction(event -> {
            // TODO: Calculate the derivative of the selected function
        });

        Button drawGraphButton = new Button("Draw Graph");
        drawGraphButton.setOnAction(event -> {
            drawGraph();
        });

        // Create the chart
        chart = new LineChart<>(new NumberAxis(), new NumberAxis());
        chart.setAnimated(false);

        // Create a layout and add the components to it
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setVgap(10);
        layout.setHgap(10);
        layout.addRow(0, new Label("Function:"), functionComboBox);
        layout.addRow(1, pointLabel, pointTextField);
        layout.addRow(2, derivativeButton, drawGraphButton);
        layout.add(chart, 0, 3, 2, 1);

        // Create the scene and show the stage
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setTitle("Function Grapher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawGraph() {
        // Clear the chart
        chart.getData().clear();

        // Create a series for the function
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(functionComboBox.getValue());

        // Add data points to the series that represent the selected function
        Function function = functions[functionComboBox.getSelectionModel().getSelectedIndex()];
        for (double x = -10.0; x <= 10.0; x += 0.1) {
            double y = function.evaluate(x);
            series.getData().add(new XYChart.Data<>(x, y));
        }

        // Add the series to the chart
        chart.getData().add(series);
    }
}


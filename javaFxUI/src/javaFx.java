
import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import App.BackEnd;

import java.awt.*;

public class javaFx implements Runnable {
    GrapherUI_Fx ui;
    BackEnd logic;
    public javaFx(GrapherUI_Fx ui, BackEnd logic) {
        this.ui = ui;
        this.logic = logic;
    }

    @Override
    public void run() {
//        JFXPanel jfxPanel = new JFXPanel(); // create JavaFX panel
        Panel panel = new Panel();
        ui.availableFunctions.getItems().addAll(logic.getFunctionsList());// add it to Swing UI
        // create JavaFX scene with line chart
        Platform.runLater(() -> {
//            LineChart<Number, Number> chart = createLineChart();
//            StackPane root = new StackPane(chart);
//            Scene scene = new Scene(root, 800, 600);
//            panel.set(scene);
        });

        ui.button.setOnAction(event -> {
            int i = ui.availableFunctions.getSelectionModel().getSelectedIndex();
            logic.chooseCurrent(i);

            final double left = Double.parseDouble(ui.textLeftBound.getText());
            final double right = Double.parseDouble(ui.textRightBound.getText());
            final double delta = Double.parseDouble(ui.textDelta.getText());

            double[] xData, yData;
            xData = logic.evaluateRange(left, right, delta);
            yData = logic.evaluateCurrent(xData);
            updateSeries(ui.chart, "f(x)", xData, yData);

            String derivative = logic.evaluateDerivative();
            ui.textArea.setText(derivative);
            xData = logic.evaluateRange(left, right, delta);
            yData = logic.evaluateCurrent(xData);
            updateSeries(ui.chart, "f'(x)", xData, yData);
        });
    }

    private LineChart<Number, Number> createLineChart() {
        LineChart<Number, Number> chart = new LineChart<>(new NumberAxis(), new NumberAxis());
        chart.setAnimated(false);
        return chart;
    }

    private void updateSeries(LineChart<Number, Number> chart, String seriesName, double[] xData, double[] yData) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(seriesName);
        for (int i = 0; i < xData.length; i++) {
            series.getData().add(new XYChart.Data<>(xData[i], yData[i]));
        }
        if(seriesName == "f(x)"){
            chart.getData().set(0,series);
        } else if (seriesName == "f'(x)") {
            chart.getData().set(1,series);
        }
//        chart.getData().add(series);
    }

}

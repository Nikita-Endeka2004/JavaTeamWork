import App.BackEnd;

public class GrapherController implements Runnable {
    GrapherUI ui;
    BackEnd logic;

    public GrapherController(GrapherUI ui, BackEnd logic) {
        this.ui = ui;
        this.logic = logic;
    }

    @Override
    public void run() {
        for (String function :
                logic.getFunctionsList()) {
            ui.availableFunctions.addItem(function);
        }

        ui.button.addActionListener(e -> {
            final int i = ui.availableFunctions.getSelectedIndex();
            logic.chooseCurrent(i);

            final double left = Double.parseDouble(ui.textLeftBound.getText());
            final double right = Double.parseDouble(ui.textRightBound.getText());
            final double delta = Double.parseDouble(ui.textDelta.getText());

            double[] xData, yData;
            xData = logic.evaluateRange(left, right, delta);
            yData = logic.evaluateCurrent(xData);
            ui.chart.updateXYSeries("f(x)", xData, yData, null);

            String derivative = logic.evaluateDerivative();
            ui.textDerivative.setText("Derivative: " + derivative);
            xData = logic.evaluateRange(left, right, delta);
            yData = logic.evaluateCurrent(xData);
            ui.chart.updateXYSeries("f'(x)", xData, yData, null);

            ui.chartPanel.updateUI();
            ui.pack();
        });
        ui.setVisible(true);
    }
}

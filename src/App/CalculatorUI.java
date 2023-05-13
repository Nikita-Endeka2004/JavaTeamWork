package App;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {
    JTextField textNumber1 = new JTextField(10);
    JTextField textNumber2 = new JTextField(10);
    JLabel labeltextResult = new JLabel();
    JButton btnAdd = new JButton("Add");
    LinePanel pLine = new LinePanel();

    XYChart chart = new XYChartBuilder()
            .width(800)
            .height(600)
            .title("Sample Chart")
            .xAxisTitle("X")
            .yAxisTitle("Y")
            .theme(Styler.ChartTheme.Matlab)
            .build();

    XChartPanel<XYChart> chartPanel = new XChartPanel<>(chart);

    {
        textNumber1.setText("1");
        textNumber2.setText("2");
        pLine.setLine(5, 15, 30, 90);

        double[] xData = new double[]{0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
        double[] yData = new double[]{1.0, 2.0, 9.0, 16.0, 25.0, 36.0};
        chart.addSeries("Series 1", xData, yData)
                .setMarker(SeriesMarkers.CIRCLE)
                .setLineColor(Color.BLUE)
                .setLineStyle(SeriesLines.DASH_DASH);
    }

    public CalculatorUI() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Number 1:"));
        inputPanel.add(textNumber1);
        inputPanel.add(new JLabel("Number 2:"));
        inputPanel.add(textNumber2);
        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        add(buttonPanel, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel();
        outputPanel.add(new JLabel("Result:"));
        outputPanel.add(labeltextResult);
        add(outputPanel, BorderLayout.SOUTH);

        JPanel drawPanel = new JPanel();
        drawPanel.add(chartPanel);
        add(drawPanel, BorderLayout.EAST);

        pack();
    }

}
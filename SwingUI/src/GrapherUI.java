import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import javax.swing.*;
import java.awt.*;

public class GrapherUI extends JFrame {
    JTextField textLeftBound = new JTextField(10);
    JTextField textRightBound = new JTextField(10);
    JTextField textDelta = new JTextField(10);
    JComboBox<String> availableFunctions = new JComboBox<>();
    JButton button = new JButton("Compute");

    XYChart chart = new XYChartBuilder()
            .width(400)
            .height(400)
            .title("f(x) | f'(x)")
            .xAxisTitle("X")
            .yAxisTitle("Y")
            .theme(Styler.ChartTheme.Matlab)
            .build();

    XChartPanel<XYChart> chartPanel = new XChartPanel<>(chart);

    {
        textLeftBound.setText("-5");
        textRightBound.setText("5");
        textDelta.setText("0.1");

        chart.addSeries("f(x)", new double[]{0}, new double[]{0})
                .setMarker(SeriesMarkers.NONE)
                .setLineColor(Color.BLUE)
                .setLineStyle(SeriesLines.SOLID);
        chart.addSeries("f'(x)", new double[]{0}, new double[]{0})
                .setMarker(SeriesMarkers.NONE)
                .setLineColor(Color.RED)
                .setLineStyle(SeriesLines.SOLID);
    }

    public GrapherUI() {
        super("Grapher Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Left bound:"));
        inputPanel.add(textLeftBound);
        inputPanel.add(new JLabel("Right bound:"));
        inputPanel.add(textRightBound);
        inputPanel.add(new JLabel("Delta:"));
        inputPanel.add(textDelta);
        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel();
        outputPanel.add(new JLabel("f(x)="));
        outputPanel.add(availableFunctions);
        add(outputPanel, BorderLayout.SOUTH);

        JPanel drawPanel = new JPanel();
        drawPanel.add(chartPanel);
        add(drawPanel, BorderLayout.EAST);

        pack();
    }
}

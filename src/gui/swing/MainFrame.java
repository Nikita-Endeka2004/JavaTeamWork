package gui.swing;

import App.Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel inputPanel;
    private JTextField inputX;
    private JTextField inputLeftBorder;
    private JTextField inputRightBorder;
    private JComboBox<String> inputFunction;
    private JButton submitButton;
    private OutputFrame outputFrame;
    final private Function[] functions;

    public MainFrame(String title, Function... functions) {
        super(title);
        this.functions = functions;
        final int width = 500;
        final int height = 500;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        final int x = dimension.width / 2 - width / 2;
        final int y = dimension.height / 2 - height / 2;
        this.setBounds(x, y, width, height);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        for (Function function :
                this.functions) {
            inputFunction.addItem(function.toPrettyString(NumberFormat.getInstance()));
        }
        submitButton.addActionListener(new ActionListener() {
            private double x;
            private double leftBound;
            private double rightBound;
            private String function;
            private int functionIndex;

            @Override
            public void actionPerformed(ActionEvent e) {
                getInput();

                if (outputFrame == null) {
                    outputFrame = new OutputFrame();
                }
                outputFrame.setVisible(true);

                outputFrame.setFunctionAtPointPlaceholderText(Double.toString(functions[functionIndex].evaluate(x)));
                outputFrame.setFunctionDerivativePlaceholder(functions[functionIndex].derivative().toPrettyString(NumberFormat.getInstance()));
            }

            private void getInput() {
                try {
                    x = Double.parseDouble(inputX.getText());
                } catch (Exception ex) {
                    x = 0.0;
                }

                try {
                    leftBound = Double.parseDouble(inputLeftBorder.getText());
                } catch (Exception ex) {
                    leftBound = 0.0;
                }

                try {
                    rightBound = Double.parseDouble(inputRightBorder.getText());
                } catch (Exception ex) {
                    rightBound = 0.0;
                }

                function = (String)inputFunction.getSelectedItem();
                functionIndex = inputFunction.getSelectedIndex();
            }
        });
    }
}

package gui.swing;

import javax.swing.*;

public class OutputFrame extends JFrame {
    private JPanel outputPanel;
    private JPanel decriptionArea;
    private JPanel dataArea;
    private JTextArea functionAtPointPlaceholder;
    private JTextArea functionDerivativePlaceholder;

    public OutputFrame() {
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setContentPane(outputPanel);
        this.pack();
    }

    public void setFunctionAtPointPlaceholderText(String text) {
        this.functionAtPointPlaceholder.setText(text);
    }

    public void setFunctionDerivativePlaceholder(String text) {
        this.functionDerivativePlaceholder.setText(text);
    }
}

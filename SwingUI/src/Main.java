import App.BackEnd;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GrapherUI grapherUI = new GrapherUI();
            BackEnd backEnd = new BackEnd();
            GrapherController grapherController = new GrapherController(grapherUI, backEnd);
            grapherController.run();
        });
    }
}
package App;

import javax.swing.*;
import java.awt.*;

public class LinePanel extends JPanel {

    private int x1, y1;
    private int x2, y2;

    public LinePanel() {
        super();
    }

    public LinePanel(int x1, int y1, int x2, int y2) {
        super();
        setLine(x1, y1, x2, y2);
    }

    public void setLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        setPreferredSize(new Dimension(Math.max(x1, x2), Math.max(y1, y2)));
        repaint();
    }

    public void move() {
        setLine(x1 + 1, y1 + 1, x2 + 1, y2 + 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (g instanceof Graphics2D g2d) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(x1, y1, x2, y2);
        }
    }
}

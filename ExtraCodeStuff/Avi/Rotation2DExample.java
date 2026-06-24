
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Rotation2DExample extends JPanel {

    private double angle = 0;

    public Rotation2DExample() {
        Timer timer = new Timer(20, e -> {
            angle += 0.02; // rotate slowly
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int rectWidth = 120;
        int rectHeight = 70;

        // draw coordinate axes
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.drawLine(0, centerY, getWidth(), centerY);
        g2d.drawLine(centerX, 0, centerX, getHeight());

        // save old transform
        AffineTransform old = g2d.getTransform();

        // move origin to center and rotate
        g2d.translate(centerX, centerY);
        g2d.rotate(angle);

        // draw rotating rectangle
        g2d.setColor(Color.BLUE);
        g2d.fillRect(-rectWidth / 2, -rectHeight / 2, rectWidth, rectHeight);

        g2d.setColor(Color.RED);
        g2d.drawRect(-rectWidth / 2, -rectHeight / 2, rectWidth, rectHeight);

        // restore old transform
        g2d.setTransform(old);

        // draw center point
        g2d.setColor(Color.BLACK);
        g2d.fillOval(centerX - 4, centerY - 4, 8, 8);

        g2d.drawString("Center of Rotation", centerX + 10, centerY - 10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Rotation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new Rotation2DExample());
        frame.setVisible(true);
    }
}
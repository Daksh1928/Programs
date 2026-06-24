
import javax.swing.*;
import java.awt.*;

public class Rotation3DAllAxes extends JPanel {

    double angleX = 0;
    double angleY = 0;
    double angleZ = 0;

    double[][] cube = {
            { -50, -50, -50 }, { 50, -50, -50 },
            { 50, 50, -50 }, { -50, 50, -50 },
            { -50, -50, 50 }, { 50, -50, 50 },
            { 50, 50, 50 }, { -50, 50, 50 }
    };

    int[][] edges = {
            { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 },
            { 4, 5 }, { 5, 6 }, { 6, 7 }, { 7, 4 },
            { 0, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 }
    };

    public Rotation3DAllAxes() {
        Timer timer = new Timer(30, e -> {
            angleX += 0.02;
            angleY += 0.03;
            angleZ += 0.01;
            repaint();
        });
        timer.start();
    }

    double[] rotate(double x, double y, double z) {

        // Rotate X
        double cosX = Math.cos(angleX);
        double sinX = Math.sin(angleX);
        double y1 = y * cosX - z * sinX;
        double z1 = y * sinX + z * cosX;

        // Rotate Y
        double cosY = Math.cos(angleY);
        double sinY = Math.sin(angleY);
        double x2 = x * cosY + z1 * sinY;
        double z2 = -x * sinY + z1 * cosY;

        // Rotate Z
        double cosZ = Math.cos(angleZ);
        double sinZ = Math.sin(angleZ);
        double x3 = x2 * cosZ - y1 * sinZ;
        double y3 = x2 * sinZ + y1 * cosZ;

        return new double[] { x3, y3, z2 };
    }

    Point project(double x, double y, double z, int w, int h) {
        double scale = 200 / (z + 200);
        int px = (int) (x * scale + w / 2);
        int py = (int) (y * scale + h / 2);
        return new Point(px, py);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Point[] points = new Point[8];

        for (int i = 0; i < cube.length; i++) {
            double[] p = rotate(cube[i][0], cube[i][1], cube[i][2]);
            points[i] = project(p[0], p[1], p[2], getWidth(), getHeight());
        }

        g2.setColor(Color.BLUE);
        for (int[] e : edges) {
            Point p1 = points[e[0]];
            Point p2 = points[e[1]];
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("3D Rotation (All Axes)");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Rotation3DAllAxes());
        frame.setVisible(true);
    }
}

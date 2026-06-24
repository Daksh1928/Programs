
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Rotation3DExample extends JPanel {

    double angle = 0;

    // Cube vertices (x, y, z)
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

    public Rotation3DExample() {
        Timer timer = new Timer(30, e -> {
            angle += 0.03;
            repaint();
        });
        timer.start();
    }

    // Rotate around Y-axis
    double[] rotateY(double x, double y, double z) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        double x1 = x * cos + z * sin;
        double z1 = -x * sin + z * cos;

        return new double[] { x1, y, z1 };
    }

    // Simple projection (3D → 2D)
    Point project(double x, double y, double z, int w, int h) {
        double scale = 200 / (z + 200); // perspective
        int px = (int) (x * scale + w / 2);
        int py = (int) (y * scale + h / 2);
        return new Point(px, py);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Point[] points = new Point[8];

        // Rotate + project each vertex
        for (int i = 0; i < cube.length; i++) {
            double[] p = rotateY(cube[i][0], cube[i][1], cube[i][2]);
            points[i] = project(p[0], p[1], p[2], getWidth(), getHeight());
        }

        // Draw edges
        g2.setColor(Color.BLUE);
        for (int[] e : edges) {
            Point p1 = points[e[0]];
            Point p2 = points[e[1]];
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("3D Rotation (Cube)");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Rotation3DExample());
        frame.setVisible(true);
    }
}
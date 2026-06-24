import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SubwayRunnerGame extends JPanel implements ActionListener, KeyListener {

    // Screen
    private static final int WIDTH = 600;
    private static final int HEIGHT = 800;

    // Road / lanes
    private static final int ROAD_WIDTH = 360;
    private static final int ROAD_LEFT = (WIDTH - ROAD_WIDTH) / 2;
    private static final int LANE_WIDTH = ROAD_WIDTH / 3;
    private static final int[] LANE_CENTERS = {
            ROAD_LEFT + LANE_WIDTH / 2,
            ROAD_LEFT + LANE_WIDTH + LANE_WIDTH / 2,
            ROAD_LEFT + 2 * LANE_WIDTH + LANE_WIDTH / 2
    };

    // Player
    private static final int PLAYER_W = 50;
    private static final int PLAYER_H = 80;
    private static final int GROUND_Y = 660;

    // Game
    private Timer timer;
    private Random random = new Random();
    private boolean running = true;

    private int lane = 1; // 0,1,2
    private int jumpOffset = 0;
    private int jumpVelocity = 0;
    private boolean jumping = false;

    private int score = 0;
    private int coinsCollected = 0;
    private int frameCount = 0;
    private int roadOffset = 0;

    private final int speed = 8;

    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private ArrayList<Coin> coins = new ArrayList<>();

    // Player rectangle (updated every frame)
    private Rectangle playerRect = new Rectangle();

    public SubwayRunnerGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(25, 25, 25));
        setFocusable(true);
        addKeyListener(this);

        timer = new Timer(20, this); // 50 FPS
        timer.start();
    }

    // ---------- Game Objects ----------
    class Obstacle {
        int lane;
        int x, y, w, h;

        Obstacle(int lane, int y, int h) {
            this.lane = lane;
            this.w = 60;
            this.h = h;
            this.x = LANE_CENTERS[lane] - w / 2;
            this.y = y;
        }

        Rectangle getRect() {
            return new Rectangle(x, y, w, h);
        }
    }

    class Coin {
        int lane;
        int x, y, size;

        Coin(int lane, int y) {
            this.lane = lane;
            this.size = 24;
            this.x = LANE_CENTERS[lane] - size / 2;
            this.y = y;
        }

        Rectangle getRect() {
            return new Rectangle(x, y, size, size);
        }
    }

    // ---------- Update Loop ----------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            frameCount++;
            score++;

            // Spawn obstacles and coins
            if (frameCount % 55 == 0) {
                int obsLane = random.nextInt(3);
                int h = random.nextBoolean() ? 70 : 130;
                obstacles.add(new Obstacle(obsLane, -140, h));
            }

            if (frameCount % 35 == 0) {
                int coinLane = random.nextInt(3);
                coins.add(new Coin(coinLane, -50));
            }

            // Move road background
            roadOffset += speed;
            if (roadOffset > 80)
                roadOffset = 0;

            // Move obstacles
            Iterator<Obstacle> obsIt = obstacles.iterator();
            while (obsIt.hasNext()) {
                Obstacle ob = obsIt.next();
                ob.y += speed;

                if (ob.y > HEIGHT) {
                    obsIt.remove();
                } else if (playerRect.intersects(ob.getRect())) {
                    running = false;
                }
            }

            // Move coins
            Iterator<Coin> coinIt = coins.iterator();
            while (coinIt.hasNext()) {
                Coin c = coinIt.next();
                c.y += speed;

                if (c.y > HEIGHT) {
                    coinIt.remove();
                } else if (playerRect.intersects(c.getRect())) {
                    coinsCollected++;
                    score += 100;
                    coinIt.remove();
                }
            }

            // Jump physics
            if (jumping) {
                jumpVelocity += 1; // gravity
                jumpOffset += jumpVelocity;

                if (jumpOffset >= 0) {
                    jumpOffset = 0;
                    jumpVelocity = 0;
                    jumping = false;
                }
            }

            updatePlayerRect();
        }

        repaint();
    }

    private void updatePlayerRect() {
        int px = LANE_CENTERS[lane] - PLAYER_W / 2;
        int py = GROUND_Y - PLAYER_H - jumpOffset;
        playerRect = new Rectangle(px, py, PLAYER_W, PLAYER_H);
    }

    // ---------- Drawing ----------
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        drawBackground(g2);
        drawRoad(g2);
        drawCoins(g2);
        drawObstacles(g2);
        drawPlayer(g2);
        drawHUD(g2);

        if (!running) {
            drawGameOver(g2);
        }
    }

    private void drawBackground(Graphics2D g2) {
        g2.setColor(new Color(18, 18, 18));
        g2.fillRect(0, 0, WIDTH, HEIGHT);
    }

    private void drawRoad(Graphics2D g2) {
        // Road
        g2.setColor(new Color(60, 60, 60));
        g2.fillRect(ROAD_LEFT, 0, ROAD_WIDTH, HEIGHT);

        // Lane lines
        g2.setColor(new Color(220, 220, 220));
        for (int i = 1; i < 3; i++) {
            int x = ROAD_LEFT + i * LANE_WIDTH;
            for (int y = -80 + roadOffset; y < HEIGHT; y += 80) {
                g2.fillRect(x - 3, y, 6, 45);
            }
        }

        // Road borders
        g2.setColor(Color.YELLOW);
        g2.fillRect(ROAD_LEFT - 4, 0, 4, HEIGHT);
        g2.fillRect(ROAD_LEFT + ROAD_WIDTH, 0, 4, HEIGHT);
    }

    private void drawPlayer(Graphics2D g2) {
        int px = playerRect.x;
        int py = playerRect.y;

        g2.setColor(new Color(255, 70, 70));
        g2.fillRoundRect(px, py, PLAYER_W, PLAYER_H, 18, 18);

        g2.setColor(Color.BLACK);
        g2.drawRoundRect(px, py, PLAYER_W, PLAYER_H, 18, 18);

        // small head
        g2.setColor(new Color(240, 210, 180));
        g2.fillOval(px + 12, py - 18, 26, 26);
    }

    private void drawObstacles(Graphics2D g2) {
        for (Obstacle ob : obstacles) {
            if (ob.h > 100) {
                g2.setColor(new Color(30, 144, 255));
            } else {
                g2.setColor(new Color(139, 69, 19));
            }
            g2.fillRoundRect(ob.x, ob.y, ob.w, ob.h, 12, 12);

            g2.setColor(Color.BLACK);
            g2.drawRoundRect(ob.x, ob.y, ob.w, ob.h, 12, 12);
        }
    }

    private void drawCoins(Graphics2D g2) {
        for (Coin c : coins) {
            g2.setColor(Color.YELLOW);
            g2.fillOval(c.x, c.y, c.size, c.size);

            g2.setColor(new Color(160, 120, 0));
            g2.drawOval(c.x, c.y, c.size, c.size);
        }
    }

    private void drawHUD(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("Score: " + score, 20, 30);
        g2.drawString("Coins: " + coinsCollected, 20, 55);

        g2.setFont(new Font("Arial", Font.PLAIN, 16));
        g2.drawString("Controls: Left/Right = Lane, Up = Jump, R = Restart", 20, HEIGHT - 20);
    }

    private void drawGameOver(Graphics2D g2) {
        g2.setColor(new Color(0, 0, 0, 170));
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        g2.setColor(Color.RED);
        g2.setFont(new Font("Arial", Font.BOLD, 54));
        String over = "GAME OVER";
        FontMetrics fm1 = g2.getFontMetrics();
        g2.drawString(over, (WIDTH - fm1.stringWidth(over)) / 2, HEIGHT / 2 - 40);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 24));
        String s1 = "Final Score: " + score;
        String s2 = "Coins: " + coinsCollected;
        String s3 = "Press R to Restart";

        FontMetrics fm2 = g2.getFontMetrics();
        g2.drawString(s1, (WIDTH - fm2.stringWidth(s1)) / 2, HEIGHT / 2 + 10);
        g2.drawString(s2, (WIDTH - fm2.stringWidth(s2)) / 2, HEIGHT / 2 + 45);
        g2.drawString(s3, (WIDTH - fm2.stringWidth(s3)) / 2, HEIGHT / 2 + 85);
    }

    // ---------- Controls ----------
    @Override
    public void keyPressed(KeyEvent e) {
        if (running) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (lane > 0)
                    lane--;
                updatePlayerRect();
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (lane < 2)
                    lane++;
                updatePlayerRect();
            }

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (!jumping) {
                    jumping = true;
                    jumpVelocity = -18;
                }
            }
        }

        if (!running && e.getKeyCode() == KeyEvent.VK_R) {
            restartGame();
        }
    }

    private void restartGame() {
        lane = 1;
        jumpOffset = 0;
        jumpVelocity = 0;
        jumping = false;
        score = 0;
        coinsCollected = 0;
        frameCount = 0;
        roadOffset = 0;
        running = true;
        obstacles.clear();
        coins.clear();
        updatePlayerRect();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        JFrame frame = new JFrame("Subway Runner Game");
        SubwayRunnerGame game = new SubwayRunnerGame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.requestFocusInWindow();
    }
}


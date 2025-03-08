import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JFrame {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = (WIDTH * HEIGHT) / (DOT_SIZE * DOT_SIZE);
    
    private ArrayList<Point> snake; // Menyimpan posisi ular
    private Point food; // Posisi makanan
    private char direction; // Arah ular
    private boolean running; // Status permainan

    public SnakeGame() {
        setTitle("Game Ular");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        snake = new ArrayList<>();
        snake.add(new Point(5, 5)); // Posisi awal ular
        direction = 'R'; // Arah awal: kanan
        running = true;

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    move();
                    checkCollision();
                    checkFood();
                    repaint();
                }
            }
        });
        timer.start();

        generateFood(); // Menghasilkan makanan

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (direction != 'D') direction = 'U';
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direction != 'U') direction = 'D';
                        break;
                    case KeyEvent.VK_LEFT:
                        if (direction != 'R') direction = 'L';
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direction != 'L') direction = 'R';
                        break;
                }
            }
        });
        
        setFocusable(true);
    }

    private void generateFood() {
        Random rand = new Random();
        int x = rand.nextInt(WIDTH / DOT_SIZE);
        int y = rand.nextInt(HEIGHT / DOT_SIZE);
        food = new Point(x, y);
    }

    private void move() {
        Point head = snake.get(0);
        Point newHead;

        switch (direction) {
            case 'U':
                newHead = new Point(head.x, head.y - 1);
                break;
            case 'D':
                newHead = new Point(head.x, head.y + 1);
                break;
            case 'L':
                newHead = new Point(head.x - 1, head.y);
                break;
            case 'R':
                newHead = new Point(head.x + 1, head.y);
                break;
            default:
                return;
        }

        snake.add(0, newHead); // Tambahkan kepala baru ke depan

        if (!newHead.equals(food)) {
            snake.remove(snake.size() - 1); // Hapus ekor jika tidak makan
        } else {
            generateFood(); // Jika makan, hasilkan makanan baru
        }
    }

    private void checkCollision() {
        Point head = snake.get(0);

        // Cek tabrakan dengan dinding
        if (head.x < 0 || head.x >= WIDTH / DOT_SIZE || head.y < 0 || head.y >= HEIGHT / DOT_SIZE) {
            running = false;
            JOptionPane.showMessageDialog(this, "Game Over! Tabrakan dengan dinding.");
        }

        // Cek tabrakan dengan tubuh sendiri
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                running = false;
                JOptionPane.showMessageDialog(this, "Game Over! Tabrakan dengan tubuh sendiri.");
            }
        }
    }

    private void checkFood() {
        if (snake.get(0).equals(food)) {
            generateFood(); // Hasilkan makanan baru jika dimakan
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.GREEN);
        
        for (Point p : snake) {
            g.fillRect(p.x * DOT_SIZE, p.y * DOT_SIZE, DOT_SIZE, DOT_SIZE);
        }

        g.setColor(Color.RED); // Makanan berwarna merah
        g.fillRect(food.x * DOT_SIZE, food.y * DOT_SIZE, DOT_SIZE, DOT_SIZE);
        
        if (!running) {
            g.setColor(Color.BLACK);
            g.drawString("Game Over", WIDTH / 2 - 30, HEIGHT / 2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SnakeGame game = new SnakeGame();
            game.setVisible(true);
        });
    }
}
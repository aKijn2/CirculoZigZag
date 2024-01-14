import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private int width = 20;
    private int height = 20;
    private int positionX = 0;
    private int positionY = 0;
    private boolean moveRight = true;
    private boolean moveDown = true;

    public App() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBall();
                repaint();
            }
        });

        timer.start();
    }

    private void moveBall() {
        if (moveRight) {
            positionX++;
        } else {
            positionX--;
        }

        if (moveDown) {
            positionY++;
        }

        if (positionX == 0 || positionX == width - 1) {
            moveRight = !moveRight;
        }

        if (positionY == height) {
            moveDown = false;
        } else if (positionY == 0) {
            moveDown = true;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBall(g);
    }

    private void drawBall(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == positionY && j == positionX) {
                    g.drawString("o", j * 15, i * 15);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App().setVisible(true);
            }
        });
    }
}

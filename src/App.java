import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private int width = 20;
    private int height = 20;
    private int positionX = 0;
    private int positionY = 0;
    private int xSpeed = 7;
    private int ySpeed = 7;

    public App() {
        initUI();
    }

    private void initUI() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(200, e -> {
            moveBall();
            repaint();
        });

        timer.start();
    }

    private void moveBall() {
        positionX += xSpeed;
        positionY += ySpeed;

        if (positionX <= 0 || positionX >= getWidth() - width) {
            xSpeed = -xSpeed;
        }

        if (positionY <= 0 || positionY >= getHeight() - height) {
            ySpeed = -ySpeed;
        }
    }

    @Override
    public void paint(Graphics g) {

        // Esto es el color de fondo.
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());


        // Esto es el color que cogera la pelota.
        g.setColor(Color.RED);
        drawBall(g);

        // Añadir un marcador en el centro superior
        g.drawString("Marcador", getWidth() / 2 - 30, 20);
    }

    private void drawBall(Graphics g) {
        g.fillOval(positionX, positionY, width, height);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}

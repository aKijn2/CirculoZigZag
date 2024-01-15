import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel {

    private int width = 20;
    private int height = 20;
    private int positionX = 0;
    private int positionY = 0;
    private int xSpeed = 2;
    private int ySpeed = 2;

    private String marcador = "0";

    private long lastUpdateTime = System.currentTimeMillis();

    public void moveBall() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastUpdateTime;

        positionX += xSpeed;
        positionY += ySpeed;

        if (positionX <= 0 || positionX >= getWidth() - width) {
            xSpeed = -xSpeed;
        }

        if (positionY <= 0 || positionY >= getHeight() - height) {
            ySpeed = -ySpeed;
        }

        if (positionX >= getWidth() - width && positionY >= getHeight() - height) {
            marcador = String.valueOf(Integer.parseInt(marcador) + 1);
        }

        lastUpdateTime = currentTime;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.RED);
        g.fillOval(positionX, positionY, width, height);

        g.setColor(Color.WHITE);
        g.drawString(marcador, getWidth() / 2 - 15, 20);
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }
}

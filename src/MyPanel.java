import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private int width = 20;
    private int height = 20;
    private int positionX = 0;
    private int positionY = 0;
    private int xSpeed = 100;
    private int ySpeed = 100;

    private String marcador = "0";

    public void moveBall() {
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.RED);
        g.fillOval(positionX, positionY, width, height);

        g.setColor(Color.WHITE);
        g.drawString(marcador, getWidth() / 2 - 15, 20);
        g.toString();
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }
}

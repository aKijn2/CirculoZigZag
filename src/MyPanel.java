import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private int ballWidth = 20;
    private int ballHeight = 20;
    private int positionX = 0;
    private int positionY = 0;
    private int xSpeed = 2;
    private int ySpeed = 2;
    private int plataformaRevota = 40;

    private String marcador = "0";

    private long lastUpdateTime = System.currentTimeMillis();

    public void moveBall() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastUpdateTime;

        positionX += xSpeed;
        positionY += ySpeed;

        if (positionX <= 0 || positionX >= getWidth() - ballWidth) {
            xSpeed = -xSpeed;
        }

        if (positionY <= 0 || positionY >= getHeight() - ballHeight) {
            ySpeed = -ySpeed;
        }

        if (positionX >= getWidth() - ballWidth && positionY >= getHeight() - ballHeight) {
            marcador = String.valueOf(Integer.parseInt(marcador) + 1);
        }

        lastUpdateTime = currentTime;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.RED);
        g.fillOval(positionX, positionY, ballWidth, ballHeight);

        g.setColor(Color.WHITE);
        g.drawString(marcador, getWidth() / 2 - 15, 20);

        g.setColor(Color.BLUE);

        for (int i = 0; i < 3; i++) {
            g.fillRect(getWidth() / 2 - plataformaRevota / 2 + plataformaRevota * i, getHeight() - plataformaRevota * 2,
                    plataformaRevota, plataformaRevota);
        }
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }
}

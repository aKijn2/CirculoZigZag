import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyPanel extends JPanel {

    private int ballWidth = 20;
    private int ballHeight = 20;
    private int positionX = 0;
    private int positionY = 0;
    private int xSpeed = 2;
    private int ySpeed = 2;
    private int plataformaRevota = 40;

    private boolean moveLeft = false;
    private boolean moveRight = false;

    public MyPanel() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_A) {
                    moveLeft = true;
                } else if (key == KeyEvent.VK_D) {
                    moveRight = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_A) {
                    moveLeft = false;
                } else if (key == KeyEvent.VK_D) {
                    moveRight = false;
                }
            }
        });
    }

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

        movePlatform();

        lastUpdateTime = currentTime;
    }

    private void movePlatform() {
        int speed = 2;

        if (moveLeft) {
            plataformaRevota -= speed;
            if (plataformaRevota < 0) {
                plataformaRevota = 0;
            }
            
        } else if (moveRight) {
            plataformaRevota += speed;
            if (plataformaRevota > getWidth() - 3 * plataformaRevota) {
                plataformaRevota = getWidth() - 3 * plataformaRevota;
            }
        }

    }

    public void paint() {
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.ORANGE);
        g.fillOval(positionX, positionY, ballWidth, ballHeight);

        g.setColor(Color.WHITE);
        g.drawString(marcador, getWidth() / 2 - 15, 20);

        g.setColor(Color.WHITE);

        for (int i = 0; i < 3; i++) {
            g.fillRect(getWidth() / 2 - plataformaRevota / 2 + plataformaRevota * i, getHeight() - plataformaRevota * 2,
                    plataformaRevota, plataformaRevota);
        }
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }
}

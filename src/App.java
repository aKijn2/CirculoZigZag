import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class App extends JFrame {

    private MyPanel myPanel;

    public App() {
        initUI();
    }

    private void initUI() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel = new MyPanel();
        add(myPanel);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBall();
                myPanel.repaint();
            }
        });

        timer.start();
    }

    private void moveBall() {
        myPanel.moveBall();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App app = new App();
            app.setVisible(true);
        });
    }
}

import javax.swing.*;

public class App extends JFrame {

    private MyPanel myPanel;

    public App() {
        initUI();
    }

    private void initUI() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel = new MyPanel();
        add(myPanel);

        Timer timer = new Timer(200, e -> {
            moveBall();
            myPanel.repaint();
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

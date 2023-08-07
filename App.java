import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Flappy_Bird extends JFrame {
    private int birdY;
    private int birdVelocity;
    private Timer timer;

    public Flappy_Bird() {
        setTitle("Flappy Bird");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        birdY = 300;
        birdVelocity = 0;

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                birdVelocity += 1;
                birdY += birdVelocity;
                
                if (birdY > 550) {
                    birdY = 550;
                    timer.stop();
                }

                repaint();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    birdVelocity = -15;
                }
            }
        });

        setVisible(true);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.ORANGE);
        g.fillRect(100, birdY, 50, 50);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Flappy_Bird();
            }
        });
    }
}

// Write java program using Multithreading to demonstrated drawing indian flag(use swing)

import javax.swing.*;
import java.awt.*;

public class IndianFlag extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public IndianFlag() {
        setTitle("Indian Flag");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new FlagPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IndianFlag flag = new IndianFlag();
            flag.setVisible(true);
            // Create and start thread to animate
            new Thread(new FlagAnimator(flag)).start();
        });
    }
}

class FlagPanel extends JPanel {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private Color saffron = new Color(255, 153, 51);
    private Color white = Color.WHITE;
    private Color green = new Color(18, 136, 7);
    private Color navyBlue = new Color(7, 74, 149); // Define navyBlue color

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int stripeHeight = HEIGHT / 3;

        // Draw saffron rectangle
        g.setColor(saffron);
        g.fillRect(0, 0, WIDTH, stripeHeight);

        // Draw white rectangle
        g.setColor(white);
        g.fillRect(0, stripeHeight, WIDTH, stripeHeight);

        // Draw green rectangle
        g.setColor(green);
        g.fillRect(0, 2 * stripeHeight, WIDTH, stripeHeight);

        // Draw Ashok Chakra (24 spokes)
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;
        int radius = 50;
        int innerRadius = 45;
        int startAngle = 0;
        int arcAngle = 15;

        g.setColor(navyBlue); // Set color to navyBlue
        for (int i = 0; i < 24; i++) {
            if (i % 2 == 0) {
                g.fillArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, startAngle, arcAngle);
            } else {
                g.fillArc(centerX - innerRadius, centerY - innerRadius, 2 * innerRadius, 2 * innerRadius, startAngle, arcAngle);
            }
            startAngle += arcAngle;
        }
    }
}

class FlagAnimator implements Runnable {
    private static final int ANIMATION_DELAY = 500;
    private IndianFlag flag;

    public FlagAnimator(IndianFlag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Redraw the flag
                flag.repaint();
                // Delay for animation
                Thread.sleep(ANIMATION_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// Write a java program using multithrerading to demonstrated drawing simple temple ( use swing)

import javax.swing.*;
import java.awt.*;

public class q2 extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public q2() {
        setTitle("Simple Temple Drawing");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new TemplePanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            q2 templeDrawing = new q2();
            templeDrawing.setVisible(true);
            // Create and start thread to animate
            new Thread(new TempleAnimator(templeDrawing)).start();
        });
    }
}

class TemplePanel extends JPanel {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private Color templeColor = new Color(255, 204, 153); // Light brown color

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw temple base
        g.setColor(templeColor);
        g.fillRect(100, 200, 400, 150);

        // Draw temple roof
        int[] xPoints = {100, 300, 500};
        int[] yPoints = {200, 100, 200};
        g.fillPolygon(xPoints, yPoints, 3);

        // Draw temple door
        g.setColor(Color.WHITE);
        g.fillRect(270, 250, 60, 100);

        // Draw temple door outline
        g.setColor(Color.BLACK);
        g.drawRect(270, 250, 60, 100);

        // Draw temple pillars
        g.setColor(Color.WHITE);
        g.fillRect(160, 200, 50, 150);
        g.fillRect(390, 200, 50, 150);

        // Draw temple pillar outlines
        g.setColor(Color.BLACK);
        g.drawRect(160, 200, 50, 150);
        g.drawRect(390, 200, 50, 150);

        // Draw temple flags
        g.setColor(Color.RED);
        g.fillRect(180, 100, 20, 80);
        g.fillRect(400, 100, 20, 80);
    }
}

class TempleAnimator implements Runnable {
    private static final int ANIMATION_DELAY = 500;
    private q2 templeDrawing;

    public TempleAnimator(q2 templeDrawing) {
        this.templeDrawing = templeDrawing;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Redraw the temple
                templeDrawing.repaint();
                // Delay for animation
                Thread.sleep(ANIMATION_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

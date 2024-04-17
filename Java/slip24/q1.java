// Write a java program to scroll the text from left to right continuously.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class q1 extends JPanel implements Runnable {
    private int x, y;
    private String message;
    private Thread thread;
    private boolean running;

    public q1(String message) {
        this.message = message;
        x = getWidth();
        y = getHeight() / 2;
        setFont(new Font("Arial", Font.BOLD, 20));
        setForeground(Color.RED);
        setBackground(Color.WHITE);
        thread = new Thread(this);
        running = true;
        thread.start();
    }

    public void run() {
        while (running) {
            try {
                Thread.sleep(20); // Adjust the speed of scrolling here
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x--;
            if (x < -getFontMetrics(getFont()).stringWidth(message)) {
                x = getWidth();
            }
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(message, x, y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrolling Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        q1 q1 = new q1("This is scrolling text");
        frame.add(q1);
        frame.setVisible(true);
    }
}
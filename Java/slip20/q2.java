// Write a java program to blink image on the JFrame continuously. 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class q2 extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private Image image;
    private boolean blinkOn = true;

 public q2(Image image) {
 this.image = image;
 Timer timer = new Timer(500, this); // timer fires every 500ms
 timer.start();
 }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (blinkOn) {
            g.drawImage(image, 0, 0, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        blinkOn = !blinkOn;
        repaint();
    }

    public static void main(String[] args) {
        try {
            Image image = ImageIO.read(new File("path/to/image.png"));
            JPanel contentPane = new q2(image);
            contentPane.setPreferredSize(new Dimension(image.getWidth(null),
                    image.getHeight(null)));
            JFrame frame = new JFrame("Blinking Image");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(contentPane, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
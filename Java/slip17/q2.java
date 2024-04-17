// Write a Multithreading program in java to display the number’s between 1 to 100
// continuously in a TextField by clicking on button. (Use Runnable Interface). 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class q2 implements Runnable {
    private JTextField textField;

    public q2(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            textField.setText(Integer.toString(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Start");
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(button);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                q2 numberDisplay = new q2(textField);
                Thread thread = new Thread(numberDisplay);
                thread.start();
            }
        });
    }
}
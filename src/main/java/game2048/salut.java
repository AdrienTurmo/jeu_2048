package game2048;

import javax.swing.*;

public class salut {


    public static void main(String[] args) {
        JFrame frame2048 = new JFrame("2048");

        final JTextField tf = new JTextField();
        tf.setBounds(50,50, 150,20);

        JButton buttonClick = new JButton("click");
        buttonClick.setBounds(50, 100, 150, 30);

        buttonClick.addActionListener(e -> tf.setText("Welcome to Javatpoint."));

        frame2048.add(buttonClick);
        frame2048.add(tf);

        frame2048.setSize(500, 500);
        frame2048.setLayout(null);
        frame2048.setVisible(true);
        frame2048.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

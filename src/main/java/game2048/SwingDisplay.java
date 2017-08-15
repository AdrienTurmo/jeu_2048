package game2048;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SwingDisplay {

    public static void main(String[] args) {

        Printer consolePrinter = new ConsolePrinter();
        Board board = new Board(4, 4);
        BoardPrinter boardPrinter = new BoardPrinter(consolePrinter);
        MovingRules2048 movingRules2048 = new MovingRules2048();
        Game2048 game2048 = new Game2048(board, movingRules2048, boardPrinter);


        game2048.addTwoInRandomEmptyCell();
        game2048.addTwoInRandomEmptyCell();

        int[][] intTable = board.getTable();

        String firstLine = String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][3], intTable[1][3], intTable[2][3], intTable[3][3]);
        String secondLine = String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][2], intTable[1][2], intTable[2][2], intTable[3][2]);
        String thirdLine = String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][1], intTable[1][1], intTable[2][1], intTable[3][1]);
        String forthLine = String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][0], intTable[1][0], intTable[2][0], intTable[3][0]);

        JFrame frame2048 = new JFrame("2048");

        JLabel l1 = new JLabel(firstLine);
        JLabel l2 = new JLabel(secondLine);
        JLabel l3 = new JLabel(thirdLine);
        JLabel l4 = new JLabel(forthLine);
        JLabel l5 = new JLabel("");
        l1.setBounds(100, 100, 150, 50);
        l2.setBounds(100, 150, 150, 50);
        l3.setBounds(100, 200, 150, 50);
        l4.setBounds(100, 250, 150, 50);
        l5.setBounds(100, 450, 150, 50);

        Button up = new Button("Up");
        up.setBounds(300, 200, 30, 30);
        Button down = new Button("Down");
        down.setBounds(300, 300, 30, 30);
        Button left = new Button("Left");
        left.setBounds(250, 250, 30, 30);
        Button right = new Button("Right");
        right.setBounds(350, 250, 30, 30);

        up.addActionListener(e -> {
            game2048.moveUp();
            game2048.addTwoInRandomEmptyCell();
            l1.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][3], intTable[1][3], intTable[2][3], intTable[3][3]));
            l2.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][2], intTable[1][2], intTable[2][2], intTable[3][2]));
            l3.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][1], intTable[1][1], intTable[2][1], intTable[3][1]));
            l4.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][0], intTable[1][0], intTable[2][0], intTable[3][0]));
        });

        down.addActionListener(e -> {
            game2048.moveDown();
            game2048.addTwoInRandomEmptyCell();
            l1.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][3], intTable[1][3], intTable[2][3], intTable[3][3]));
            l2.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][2], intTable[1][2], intTable[2][2], intTable[3][2]));
            l3.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][1], intTable[1][1], intTable[2][1], intTable[3][1]));
            l4.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][0], intTable[1][0], intTable[2][0], intTable[3][0]));
        });

        right.addActionListener(e -> {
            game2048.moveRight();
            game2048.addTwoInRandomEmptyCell();
            l1.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][3], intTable[1][3], intTable[2][3], intTable[3][3]));
            l2.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][2], intTable[1][2], intTable[2][2], intTable[3][2]));
            l3.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][1], intTable[1][1], intTable[2][1], intTable[3][1]));
            l4.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][0], intTable[1][0], intTable[2][0], intTable[3][0]));
        });

        left.addActionListener(e -> {
            game2048.moveLeft();
            game2048.addTwoInRandomEmptyCell();
            l1.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][3], intTable[1][3], intTable[2][3], intTable[3][3]));
            l2.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][2], intTable[1][2], intTable[2][2], intTable[3][2]));
            l3.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][1], intTable[1][1], intTable[2][1], intTable[3][1]));
            l4.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][0], intTable[1][0], intTable[2][0], intTable[3][0]));
        });


        up.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        game2048.moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        game2048.moveDown();
                        break;
                    case KeyEvent.VK_LEFT:
                        game2048.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        game2048.moveRight();
                        break;
                    default:
                        break;

                }
                game2048.addTwoInRandomEmptyCell();
                l1.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][3], intTable[1][3], intTable[2][3], intTable[3][3]));
                l2.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][2], intTable[1][2], intTable[2][2], intTable[3][2]));
                l3.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][1], intTable[1][1], intTable[2][1], intTable[3][1]));
                l4.setText(String.format("|%-5s|%-5s|%-5s|%-5s|", intTable[0][0], intTable[1][0], intTable[2][0], intTable[3][0]));
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });


        frame2048.add(l1);
        frame2048.add(l2);
        frame2048.add(l3);
        frame2048.add(l4);


        frame2048.add(up);
        frame2048.add(down);
        frame2048.add(left);
        frame2048.add(right);


        frame2048.add(l5);

        frame2048.setSize(500, 500);
        frame2048.setVisible(true);
        frame2048.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

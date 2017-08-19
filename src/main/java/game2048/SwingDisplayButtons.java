package game2048;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SwingDisplayButtons {

    public static void main(String[] args) {

        Printer consolePrinter = new ConsolePrinter();
        Board board = new Board(4, 4);
        BoardPrinter boardPrinter = new BoardPrinter(consolePrinter);
        MovingRules2048 movingRules2048 = new MovingRules2048();
        Game2048 game2048 = new Game2048(board, movingRules2048, boardPrinter);


        game2048.addTwoInRandomEmptyCell();
        game2048.addTwoInRandomEmptyCell();

        int[][] intTable = board.getTable();

        JFrame frame2048 = new JFrame("2048");

        Button[][] buttons = new Button[4][4];


        for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
            for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
                buttons[columnIndex][rowIndex] = new Button(String.valueOf(intTable[columnIndex][rowIndex]));
                buttons[columnIndex][rowIndex].setBounds(20+columnIndex*50, 20+(3-rowIndex)*50,50,50);
                buttons[columnIndex][rowIndex].addKeyListener(customListener(game2048,intTable,buttons,frame2048));
                buttons[columnIndex][rowIndex].setBackground(numberToColor(intTable[columnIndex][rowIndex]));
                frame2048.add(buttons[columnIndex][rowIndex]);
            }
        }



        JLabel l5 = new JLabel("");

        l5.setBounds(100, 450, 150, 50);

        frame2048.add(l5);

        frame2048.setSize(265, 285);
        frame2048.setLocation(800,400);
        frame2048.setVisible(true);
        frame2048.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private static Color numberToColor(int value) {
        int exponent = (int) Math.round(Math.log(value) / Math.log(2));
        return new Color(250, 255 - 20 * exponent, 255 - 20 * exponent);
    }

    private static KeyListener customListener(Game2048 game2048, int[][] intTable, Button[][] buttons,Frame frame) {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (game2048.isOver()) {
                    JOptionPane.showMessageDialog(frame.getComponent(0), "You lost!");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                boolean boardHasMoved = false;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        boardHasMoved = game2048.moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        boardHasMoved = game2048.moveDown();
                        break;
                    case KeyEvent.VK_LEFT:
                        boardHasMoved = game2048.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        boardHasMoved = game2048.moveRight();
                        break;
                    default:
                        break;

                }
                if (boardHasMoved) {
                    game2048.addTwoInRandomEmptyCell();
                    int r = new Random().nextInt(100);
                    if (r > 75) {
                        game2048.addTwoInRandomEmptyCell();
                    }
                    for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
                        for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
                            buttons[columnIndex][rowIndex].setLabel(String.valueOf(intTable[columnIndex][rowIndex]));
                            buttons[columnIndex][rowIndex].setBackground(numberToColor(intTable[columnIndex][rowIndex]));
                        }
                    }
                }
            }
        };
    }


}

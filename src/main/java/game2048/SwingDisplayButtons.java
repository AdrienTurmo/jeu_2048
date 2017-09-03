package game2048;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SwingDisplayButtons {

    private static final int SIZE = 8;

    public static void main(String[] args) {

        Printer consolePrinter = new ConsolePrinter();
        Board[] board = {new Board(SIZE, SIZE)};
        BoardPrinter boardPrinter = new BoardPrinter(consolePrinter);
        MovingRules2048 movingRules2048 = new MovingRules2048();
        Game2048[] game2048 = {new Game2048(board[0], movingRules2048, boardPrinter)};


        game2048[0].addTwoInRandomEmptyCell();
        game2048[0].addTwoInRandomEmptyCell();

        int[][][] intTable = {board[0].getTable()};

        JFrame frame2048 = new JFrame("2048");

        //JOptionPane.showMessageDialog(frame2048.getComponent(0), "Hello! \n To play use the arrow keys. \n To restart a game, press R.");

        Button[][] buttons = new Button[SIZE][SIZE];


        for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
            for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
                buttons[columnIndex][rowIndex] = new Button(intTable[0][columnIndex][rowIndex] == 0 ? "" : String.valueOf(intTable[0][columnIndex][rowIndex]));
                buttons[columnIndex][rowIndex].setBounds(20 + columnIndex * 50, 20 + (SIZE-1 - rowIndex) * 50, 50, 50);
                buttons[columnIndex][rowIndex].addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        boolean boardHasMoved = false;
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_UP:
                                if (game2048[0].isOver()) {
                                    JOptionPane.showMessageDialog(frame2048.getComponent(0), "You lost!");
                                }
                                boardHasMoved = game2048[0].moveUp();
                                break;
                            case KeyEvent.VK_DOWN:
                                if (game2048[0].isOver()) {
                                    JOptionPane.showMessageDialog(frame2048.getComponent(0), "You lost!");
                                }
                                boardHasMoved = game2048[0].moveDown();
                                break;
                            case KeyEvent.VK_LEFT:
                                if (game2048[0].isOver()) {
                                    JOptionPane.showMessageDialog(frame2048.getComponent(0), "You lost!");
                                }
                                boardHasMoved = game2048[0].moveLeft();
                                break;
                            case KeyEvent.VK_RIGHT:
                                if (game2048[0].isOver()) {
                                    JOptionPane.showMessageDialog(frame2048.getComponent(0), "You lost!");
                                }
                                boardHasMoved = game2048[0].moveRight();
                                break;
                            case KeyEvent.VK_R:
                                board[0] = new Board(SIZE, SIZE);
                                game2048[0] = new Game2048(board[0], movingRules2048, boardPrinter);
                                game2048[0].addTwoInRandomEmptyCell();
                                game2048[0].addTwoInRandomEmptyCell();
                                intTable[0] = board[0].getTable();
                                for (int columnIndex1 = 0; columnIndex1 < SIZE; columnIndex1++) {
                                    for (int rowIndex1 = 0; rowIndex1 < SIZE; rowIndex1++) {
                                        int value = intTable[0][columnIndex1][rowIndex1];
                                        buttons[columnIndex1][rowIndex1].setLabel(value == 0 ? "" : String.valueOf(value));
                                        int exponent = (int) Math.round(Math.log(intTable[0][columnIndex1][rowIndex1]) / Math.log(2));
                                        buttons[columnIndex1][rowIndex1].setBackground(new Color(250, 255 - 5 * exponent, 255 - 5 * exponent));
                                    }
                                }
                                bloup(game2048, intTable, buttons, board, movingRules2048, boardPrinter);
                                break;
                            case KeyEvent.VK_P:

                            default:
                                break;

                        }
                        if (boardHasMoved) {
                            game2048[0].addTwoInRandomEmptyCell();
                            int r = new Random().nextInt(100);
                            if (r > 75) {
                                game2048[0].addTwoInRandomEmptyCell();
                            }
                            for (int columnIndex1 = 0; columnIndex1 < SIZE; columnIndex1++) {
                                for (int rowIndex1 = 0; rowIndex1 < SIZE; rowIndex1++) {
                                    int value = intTable[0][columnIndex1][rowIndex1];
                                    buttons[columnIndex1][rowIndex1].setLabel(value == 0 ? "" : String.valueOf(value));
                                    int exponent = (int) Math.round(Math.log(intTable[0][columnIndex1][rowIndex1]) / Math.log(2));
                                    buttons[columnIndex1][rowIndex1].setBackground(new Color(250, 255 - 5 * exponent, 255 - 5 * exponent));
                                }
                            }
                        }
                    }
                });
                int exponent = (int) Math.round(Math.log(intTable[0][columnIndex][rowIndex]) / Math.log(2));
                buttons[columnIndex][rowIndex].setBackground(new Color(250, 255 - 20 * exponent, 255 - 20 * exponent));
                frame2048.add(buttons[columnIndex][rowIndex]);
            }
        }


        JLabel l5 = new JLabel("");

        l5.setBounds(100, 450, 150, 50);

        frame2048.add(l5);

        frame2048.setSize(600, 600);
        frame2048.setLocation(800, 400);
        frame2048.setVisible(true);
        frame2048.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        bloup(game2048, intTable, buttons, board, movingRules2048, boardPrinter);

    }

    private static void bloup(Game2048[] game2048, int[][][] intTable, Button[][] buttons, Board[] board, MovingRules2048 movingRules2048, BoardPrinter boardPrinter) {
        while (!game2048[0].isOver()) {
            int nextMove = new Random().nextInt(100);
            boolean boardHasMoved;
            if (nextMove < 24) {
                boardHasMoved = game2048[0].moveRight();
            } else if (nextMove < 49) {
                boardHasMoved = game2048[0].moveLeft();
            } else if (nextMove < 74) {
                boardHasMoved = game2048[0].moveDown();
            } else {
                boardHasMoved = game2048[0].moveUp();
            }
            if (boardHasMoved) {
                game2048[0].addTwoInRandomEmptyCell();
                int r = new Random().nextInt(100);
                if (r > 75) {
                    game2048[0].addTwoInRandomEmptyCell();
                }
                for (int columnIndex1 = 0; columnIndex1 < SIZE; columnIndex1++) {
                    for (int rowIndex1 = 0; rowIndex1 < SIZE; rowIndex1++) {
                        int value = intTable[0][columnIndex1][rowIndex1];
                        buttons[columnIndex1][rowIndex1].setLabel(value == 0 ? "" : String.valueOf(value));
                        int exponent = (int) Math.round(Math.log(intTable[0][columnIndex1][rowIndex1]) / Math.log(2));
                        buttons[columnIndex1][rowIndex1].setBackground(new Color(250, 255 - 5 * exponent, 255 - 5 * exponent));
                    }
                }
            }
            /*
            try {
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
        }

    }


}

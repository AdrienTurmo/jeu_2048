package game2048;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class Game2048 {
    private Board board;
    private final MovingRules2048 movingRules2048;
    private final BoardPrinter boardPrinter;

    public Game2048(Board board, MovingRules2048 movingRules2048, BoardPrinter boardPrinter) {
        this.board = board;
        this.movingRules2048 = movingRules2048;
        this.boardPrinter = boardPrinter;
    }

    public void moveUp() {
        movingRules2048.moveUp(board);
    }

    public void moveDown() {
        movingRules2048.moveDown(board);
    }

    public void moveLeft() {
        movingRules2048.moveLeft(board);
    }

    public void moveRight() {
        movingRules2048.moveRight(board);
    }

    public void printBoard() {
        boardPrinter.printBoard(board);
    }

    public void addTwoInRandomEmptyCell() {
        List<SimpleEntry<Integer,Integer>> positionsOfZeros = board.positionsOfZeros();

        if (positionsOfZeros.size() != 0) {
            Collections.shuffle(positionsOfZeros);
            int columnIndex = positionsOfZeros.get(0).getKey();
            int rowIndex = positionsOfZeros.get(0).getValue();

            board.addValueAtPosition(2, columnIndex,rowIndex);
        }

    }

    public boolean isOver() {
        throw new NotImplementedException();
    }
}

package game2048;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;

public class Game2048 {
    private Board board;
    private final MovingRules2048 movingRules2048;
    private final BoardPrinter boardPrinter;

    public Game2048(Board board, MovingRules2048 movingRules2048, BoardPrinter boardPrinter) {
        this.board = board;
        this.movingRules2048 = movingRules2048;
        this.boardPrinter = boardPrinter;
    }

    public boolean moveUp() {
        return movingRules2048.moveUp(board);
    }

    public boolean moveDown() {
        return movingRules2048.moveDown(board);
    }

    public boolean moveLeft() {
        return movingRules2048.moveLeft(board);
    }

    public boolean moveRight() {
        return movingRules2048.moveRight(board);
    }

    public void printBoard() {
        boardPrinter.printBoard(board);
    }

    public void addTwoInRandomEmptyCell() {
        List<SimpleEntry<Integer, Integer>> positionsOfZeros = board.positionsOfZeros();

        if (positionsOfZeros.size() != 0) {
            Collections.shuffle(positionsOfZeros);
            int columnIndex = positionsOfZeros.get(0).getKey();
            int rowIndex = positionsOfZeros.get(0).getValue();

            board.addValueAtPosition(2, columnIndex, rowIndex);
        }

    }

    public boolean isOver() {
        return !board.areMovesStillPossible();
    }

}

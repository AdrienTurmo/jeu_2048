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

    public void printBoard() {
        boardPrinter.printBoard(board);
    }
}

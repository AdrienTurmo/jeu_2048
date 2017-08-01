import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Game2048 {
    private final Board board;
    private final BoardPrinter boardPrinter;

    public Game2048(Board board, BoardPrinter boardPrinter) {
        this.board = board;
        this.boardPrinter = boardPrinter;
    }

    public void moveUp() {
        board.moveCellsUp();
    }

    public void printBoard() {
        throw new NotImplementedException();
    }
}

import java.util.concurrent.TimeUnit;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        Printer consolePrinter = new ConsolePrinter();
        Board board = new Board(4,4);
        BoardPrinter boardPrinter = new BoardPrinter(consolePrinter);
        MovingRules2048 movingRules2048 = new MovingRules2048();
        Game2048 game = new Game2048(board, movingRules2048, boardPrinter);

        for (int index = 0 ; index < 4 ; index++) {
            for(int j = 0 ; j < 4 ; j++) {
                board.put2AtPosition(index,j);
            }
        }

        game.printBoard();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("/////////////////");
        System.out.println("///MOVING DOWN///");
        System.out.println("/////////////////");

        game.moveDown();
        game.printBoard();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("/////////////////");
        System.out.println("//MOVING RIGHT///");
        System.out.println("/////////////////");

        game.moveRight();
        game.printBoard();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("/////////////////");
        System.out.println("///MOVING LEFT///");
        System.out.println("/////////////////");

        game.moveLeft();
        game.printBoard();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("/////////////////");
        System.out.println("////MOVING UP////");
        System.out.println("/////////////////");

        game.moveUp();
        game.printBoard();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("/////////////////");
        System.out.println("///////DONE//////");
        System.out.println("/////////////////");
    }
}

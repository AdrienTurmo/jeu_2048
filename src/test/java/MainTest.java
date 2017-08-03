import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.stream.IntStream;

public class MainTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        Printer consolePrinter = new ConsolePrinter();
        Board board = new Board(4, 4);
        BoardPrinter boardPrinter = new BoardPrinter(consolePrinter);
        MovingRules2048 movingRules2048 = new MovingRules2048();
        Game2048 game = new Game2048(board, movingRules2048, boardPrinter);

        /*
        for (int index = 0; index < 4; index++) {
            for (int j = 0; j < 4; j++) {
                board.put2AtPosition(index, j);
            }
        }
*/
        game.addTwoInRandomEmptyCell();
        game.addTwoInRandomEmptyCell();

        game.printBoard();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            System.out.println("Next move ?");
            String nextMove = bufferedReader.readLine().toLowerCase();

            System.out.println("/////////////////");
            switch (nextMove) {
                case "up":
                    game.moveUp();
                    game.addTwoInRandomEmptyCell();
                    System.out.println("////MOVING UP////");
                    break;
                case "down":
                    game.moveDown();
                    game.addTwoInRandomEmptyCell();
                    System.out.println("///MOVING DOWN///");
                    break;
                case "left":
                    game.moveLeft();
                    game.addTwoInRandomEmptyCell();
                    System.out.println("///MOVING LEFT///");
                    break;
                case "right":
                    game.moveRight();
                    game.addTwoInRandomEmptyCell();
                    System.out.println("//MOVING RIGHT///");
                    break;
                default:
                    System.out.println("NOT A VALID MOVE");
                    break;
            }
            System.out.println("/////////////////");
            int r = new Random().nextInt(100);
            if (r>75) {
                game.addTwoInRandomEmptyCell();
            }
            game.printBoard();
        }


    }
}

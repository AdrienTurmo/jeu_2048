import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class MainTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        Printer consolePrinter = new ConsolePrinter();
        Board board = new Board(4, 4);
        BoardPrinter boardPrinter = new BoardPrinter(consolePrinter);
        MovingRules2048 movingRules2048 = new MovingRules2048();
        Game2048 game = new Game2048(board, movingRules2048, boardPrinter);

        for (int index = 0; index < 4; index++) {
            for (int j = 0; j < 4; j++) {
                board.put2AtPosition(index, j);
            }
        }

        /*
        game.printBoard();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            System.out.println("Next move ?");
            String nextMove = bufferedReader.readLine().toLowerCase();

            System.out.println("/////////////////");
            switch (nextMove) {
                case "up":
                    game.moveUp();
                    System.out.println("////MOVING UP////");
                    break;
                case "down":
                    game.moveDown();
                    System.out.println("///MOVING DOWN///");
                    break;
                case "left":
                    game.moveLeft();
                    System.out.println("///MOVING LEFT///");
                    break;
                case "right":
                    game.moveRight();
                    System.out.println("//MOVING RIGHT///");
                    break;
                default:
                    System.out.println("NOT A VALID MOVE");
                    break;
            }
            System.out.println("/////////////////");

            game.printBoard();
        }
            */


        final int[] indice = {0};

        String blah = "22éés2efg dd";
        System.out.println(blah);
        System.out.println(blah.toCharArray());

        List<String> bbb = new ArrayList<>();
        for ( char c : blah.toCharArray() ){
            bbb.add(String.valueOf(c));
        }

        System.out.println(bbb);

        long x = bbb.stream().filter(s -> s.equals("2")).count();

        System.out.println(x);
/*
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
  */

    }
}

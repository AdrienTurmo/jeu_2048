import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class FeatureTest {

    private Board board;
    private BoardPrinter boardPrinter;
    private MovingRules2048 movingRules2048;
    private Game2048 game;

    @Mock
    Printer printer;

    @Before
    public void setUp() throws Exception {
        board = new Board(4,4);
        boardPrinter = new BoardPrinter(printer);
        movingRules2048 = new MovingRules2048();
        game = new Game2048(board, movingRules2048, boardPrinter);
    }

    @Test
    public void should_move_up() throws Exception {
        board.put2AtPosition(0, 0);

        game.moveUp();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|2| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void should_move_up_and_merge_cells_if_they_have_same_value() throws Exception {
        board.put2AtPosition(0, 3);
        board.put2AtPosition(0, 2);

        game.moveUp();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void move_up_should_not_merge_cells_if_they_have_different_values() throws Exception {
        board.addValueAtPosition(4,0, 3);
        board.put2AtPosition(0, 2);

        game.moveUp();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|2| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void should_move_down_and_merge_cells_or_not() throws Exception {
        board.addValueAtPosition(4,0, 3);
        board.put2AtPosition(0, 2);

        board.put2AtPosition(2, 3);
        board.put2AtPosition(2, 1);

        game.moveDown();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|2| |4| |");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void when_moving_vertically_cells_should_merge_only_once() throws Exception {
        board.put2AtPosition(1, 3);
        board.put2AtPosition(1, 2);
        board.addValueAtPosition(4,1, 1);

        board.put2AtPosition(3, 3);
        board.put2AtPosition(3, 2);
        board.put2AtPosition(3, 1);
        board.put2AtPosition(3, 0);

        game.moveDown();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| |4| |4|");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| |4| |4|");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void can_move_left() throws Exception {
        board.addValueAtPosition(4,1,3);
        board.put2AtPosition(3,3);

        board.put2AtPosition(1,2);
        board.put2AtPosition(3,2);

        board.put2AtPosition(0,1);
        board.put2AtPosition(1,1);
        board.put2AtPosition(2,1);
        board.put2AtPosition(3,1);

        board.put2AtPosition(1,0);
        board.put2AtPosition(2,0);
        board.put2AtPosition(3,0);

        game.moveLeft();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4|2| | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4|4| | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4|2| | |");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void can_move_right() throws Exception {
        board.addValueAtPosition(4,1,3);
        board.put2AtPosition(3,3);

        board.put2AtPosition(1,2);
        board.put2AtPosition(3,2);

        board.addValueAtPosition(4,0,1);
        board.addValueAtPosition(4,1,1);
        board.addValueAtPosition(4,2,1);
        board.addValueAtPosition(4,3,1);

        board.put2AtPosition(1,0);
        board.put2AtPosition(2,0);
        board.put2AtPosition(3,0);

        game.moveRight();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | |4|2|");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | |4|");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | |8|8|");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | |2|4|");
        inOrder.verify(printer).print("---------");
    }
}
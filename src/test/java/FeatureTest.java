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
    Printer consolePrinter;

    @Before
    public void setUp() throws Exception {
        board = new Board(4,4);
        boardPrinter = new BoardPrinter(consolePrinter);
        movingRules2048 = new MovingRules2048();
        game = new Game2048(board, movingRules2048, boardPrinter);
    }

    @Test
    public void should_move_up() throws Exception {
        board.put2AtPosition(0, 0);

        game.moveUp();
        game.printBoard();

        InOrder inOrder = inOrder(consolePrinter);
        inOrder.verify(consolePrinter).print("---------");
        inOrder.verify(consolePrinter).print("|2| | | |");
        inOrder.verify(consolePrinter).print("---------");
        inOrder.verify(consolePrinter).print("| | | | |");
        inOrder.verify(consolePrinter).print("---------");
        inOrder.verify(consolePrinter).print("| | | | |");
        inOrder.verify(consolePrinter).print("---------");
        inOrder.verify(consolePrinter).print("| | | | |");
        inOrder.verify(consolePrinter).print("---------");

    }
}
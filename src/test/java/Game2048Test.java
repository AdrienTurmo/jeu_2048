import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class Game2048Test {

    private Game2048 game;

    @Mock
    private Board board;
    @Mock
    private BoardPrinter boardPrinter;
    @Mock
    private MovingRules2048 movingRules2048;

    @Before
    public void setUp() throws Exception {
        game = new Game2048(board,movingRules2048,boardPrinter);
    }

    @Test
    public void should_move_cells_up() throws Exception {
        game.moveUp();

        verify(movingRules2048).moveCellsUp(board);
    }

    @Test
    public void should_move_cells_down() throws Exception {
        game.moveDown();

        verify(movingRules2048).moveCellsDown(board);
    }
}
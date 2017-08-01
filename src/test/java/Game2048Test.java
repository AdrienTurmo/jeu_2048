import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class Game2048Test {

    private Game2048 game;

    @Mock
    private Board board;
    @Mock
    private BoardPrinter boardPrinter;

    @Before
    public void setUp() throws Exception {
        game = new Game2048(board,boardPrinter);
    }

    @Test
    public void should_move_cells_up() throws Exception {
        game.moveUp();

        verify(board).moveCellsUp();
    }
}
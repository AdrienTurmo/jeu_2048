import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MovingRules2048Test {

    private MovingRules2048 movingRules2048;
    @Mock
    private Board board;

    @Before
    public void setUp() throws Exception {
        movingRules2048 = new MovingRules2048();
    }

    @Test
    public void should_move_cells_up() throws Exception {
        Mockito.when(board.moveCellsUpByOne()).thenReturn(true,true,true,false);
        movingRules2048.moveCellsUp(board);

        Mockito.inOrder(board).verify(board,Mockito.calls(4)).moveCellsUpByOne();
    }

}
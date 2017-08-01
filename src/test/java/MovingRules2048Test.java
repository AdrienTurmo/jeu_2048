import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MovingRules2048Test {

    private MovingRules2048 movingRules2048;
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(4,4);
        movingRules2048 = new MovingRules2048();
    }

    @Test
    public void should_move_up_the_cell_to_the_top() throws Exception {
        board.put2AtPosition(0,0);
        boolean boardHasMoved = movingRules2048.moveCellsUp(board);

        assertThat(boardHasMoved).isTrue();
        assertThat(board.valueAtPosition(0,0)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,1)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,2)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,3)).isEqualTo(2);
    }

    @Test
    public void cell_should_not_move_and_return_false() throws Exception {
        board.put2AtPosition(0,3);
        boolean boardHasMoved = movingRules2048.moveCellsUp(board);

        assertThat(boardHasMoved).isFalse();
        assertThat(board.valueAtPosition(0,3)).isEqualTo(2);
    }

}
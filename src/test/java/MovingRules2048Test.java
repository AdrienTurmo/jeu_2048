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
    public void should_move_the_cell_to_the_top() throws Exception {
        board.put2AtPosition(0,0);
        boolean boardHasMoved = movingRules2048.moveCellsUp(board);

        assertThat(boardHasMoved).isTrue();
        assertThat(board.valueAtPosition(0,3)).isEqualTo(2);
        assertThat(board.valueAtPosition(0,2)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,1)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,0)).isEqualTo(0);
    }

    @Test
    public void cell_should_not_move_and_return_false() throws Exception {
        board.put2AtPosition(0,3);
        boolean boardHasMoved = movingRules2048.moveCellsUp(board);

        assertThat(boardHasMoved).isFalse();
        assertThat(board.valueAtPosition(0,3)).isEqualTo(2);
    }

    @Test
    public void should_move_the_cell_to_the_bottom() throws Exception {
        board.put2AtPosition(0,3);
        boolean boardHasMoved = movingRules2048.moveCellsDown(board);

        assertThat(boardHasMoved).isTrue();
        assertThat(board.valueAtPosition(0,3)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,2)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,1)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,0)).isEqualTo(2);
    }

    @Test
    public void move_up_should_merge_two_cells_if_they_have_the_same_value() throws Exception {
        board.put2AtPosition(0,3);
        board.put2AtPosition(0,2);
        boolean boardHasMoved = movingRules2048.moveCellsUp(board);

        assertThat(boardHasMoved).isTrue();
        assertThat(board.valueAtPosition(0,3)).isEqualTo(4);
        assertThat(board.valueAtPosition(0,2)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,1)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,0)).isEqualTo(0);
    }

    @Test
    public void move_up_should_not_merge_two_cells_if_they_have_different_values() throws Exception {
        board.addValueAtPosition(4,0,3);
        board.put2AtPosition(0,2);
        boolean boardHasMoved = movingRules2048.moveCellsUp(board);

        assertThat(boardHasMoved).isFalse();
        assertThat(board.valueAtPosition(0,3)).isEqualTo(4);
        assertThat(board.valueAtPosition(0,2)).isEqualTo(2);
        assertThat(board.valueAtPosition(0,1)).isEqualTo(0);
        assertThat(board.valueAtPosition(0,0)).isEqualTo(0);
    }

    @Test
    public void move_down_should_merge_two_cells_if_they_have_the_same_value() throws Exception {
        board.put2AtPosition(1,3);
        board.put2AtPosition(1,2);

        boolean boardHasMoved = movingRules2048.moveCellsDown(board);

        assertThat(boardHasMoved).isTrue();
        assertThat(board.valueAtPosition(1,3)).isEqualTo(0);
        assertThat(board.valueAtPosition(1,2)).isEqualTo(0);
        assertThat(board.valueAtPosition(1,1)).isEqualTo(0);
        assertThat(board.valueAtPosition(1,0)).isEqualTo(4);
    }

    @Test
    public void move_down_should_not_merge_two_cells_if_they_have_different_values() throws Exception {
        board.addValueAtPosition(4,1,3);
        board.put2AtPosition(1,2);

        boolean boardHasMoved = movingRules2048.moveCellsDown(board);

        assertThat(boardHasMoved).isTrue();
        assertThat(board.valueAtPosition(1,3)).isEqualTo(0);
        assertThat(board.valueAtPosition(1,2)).isEqualTo(0);
        assertThat(board.valueAtPosition(1,1)).isEqualTo(4);
        assertThat(board.valueAtPosition(1,0)).isEqualTo(2);
    }

}
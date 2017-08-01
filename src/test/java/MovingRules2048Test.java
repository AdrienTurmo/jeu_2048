import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingRules2048Test {

    private MovingRules2048 movingRules2048;
    private Board board;

    @Before
    public void setUp() throws Exception {
        movingRules2048 = new MovingRules2048();
        board = new Board(4, 4);
    }

    @Test
    public void should_move_cells_up() throws Exception {
        board.put2AtPosition(0, 0);
        Board expectedBoard = new Board(4, 4);
        expectedBoard.put2AtPosition(0, 0);

        Board newBoard = movingRules2048.moveCellsUp(board);

        assertThat(newBoard).isEqualTo(expectedBoard);
    }
}
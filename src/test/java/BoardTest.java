import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(4, 4);
    }

    @Test
    public void should_create_a_board_with_empty_cells() throws Exception {
        for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
                assertThat(board.valueAtPosition(rowIndex, columnIndex)).isEqualTo(0);
            }
        }
    }

    @Test
    public void should_put_2_in_the_0_0_cell() throws Exception {
        board.put2AtPosition(0, 0);

        assertThat(board.valueAtPosition(0, 0)).isEqualTo(2);
    }

    @Test
    public void should_add_specified_value() throws Exception {
        board.put2AtPosition(0,0);

        board.addValueAtPosition(5,1,1);
        board.addValueAtPosition(2,0,0);

        assertThat(board.valueAtPosition(0,0)).isEqualTo(4);
        assertThat(board.valueAtPosition(1,1)).isEqualTo(5);
    }

    @Test
    public void should_set_value_at_zero() throws Exception {
        board.put2AtPosition(0,0);

        board.setValueToZeroAtPosition(0,0);

        assertThat(board.valueAtPosition(0,0)).isEqualTo(0);
    }
}
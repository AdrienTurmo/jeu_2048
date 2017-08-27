package game2048;

import org.junit.Before;
import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(4, 4);
    }

    @Test
    public void should_create_a_board_with_empty_cells() throws Exception {
        Board board = new Board(4, 4);
        for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
                assertThat(board.valueAtPosition(rowIndex, columnIndex)).isEqualTo(0);
            }
        }
    }

    @Test
    public void should_put_2_in_the_0_0_cell() throws Exception {
        board.addValueAtPosition(2, 0, 0);

        assertThat(board.valueAtPosition(0, 0)).isEqualTo(2);
    }

    @Test
    public void should_add_specified_value() throws Exception {
        board.addValueAtPosition(2, 0,0);

        board.addValueAtPosition(5,1,1);
        board.addValueAtPosition(2,0,0);

        assertThat(board.valueAtPosition(0,0)).isEqualTo(4);
        assertThat(board.valueAtPosition(1,1)).isEqualTo(5);
    }

    @Test
    public void should_set_value_at_zero() throws Exception {
        board.addValueAtPosition(2, 0,0);

        board.setValueToZeroAtPosition(0,0);

        assertThat(board.valueAtPosition(0,0)).isEqualTo(0);
    }

    @Test
    public void should_return_a_list_of_zeros_positions_as_simple_entries() throws Exception {
        //given
        board.addValueAtPosition(2, 0,1);
        board.addValueAtPosition(2, 0,3);

        board.addValueAtPosition(2, 1,0);
        board.addValueAtPosition(2, 1,1);
        board.addValueAtPosition(2, 1,3);

        board.addValueAtPosition(2, 2,0);
        board.addValueAtPosition(2, 2,1);
        board.addValueAtPosition(2, 2,2);
        board.addValueAtPosition(2, 2,3);

        board.addValueAtPosition(2, 3,0);
        board.addValueAtPosition(2, 3,1);
        board.addValueAtPosition(2, 3,3);

        SimpleEntry<Integer,Integer> zeroIn0_0 = new SimpleEntry<>(0, 0);
        SimpleEntry<Integer,Integer> zeroIn0_2 = new SimpleEntry<>(0, 2);
        SimpleEntry<Integer,Integer> zeroIn1_2 = new SimpleEntry<>(1, 2);
        SimpleEntry<Integer,Integer> zeroIn3_2 = new SimpleEntry<>(3, 2);

        List<SimpleEntry> expectedZeros = Arrays.asList(zeroIn0_0,zeroIn0_2,zeroIn1_2,zeroIn3_2);

        //when
        List<SimpleEntry<Integer, Integer>> zeros = board.positionsOfZeros();

        //then
        assertThat(zeros).contains(expectedZeros.get(0));
        assertThat(zeros).contains(expectedZeros.get(1));
        assertThat(zeros).contains(expectedZeros.get(2));
        assertThat(zeros).contains(expectedZeros.get(3));
    }

    @Test
    public void should_tell_if_no_move_are_possible() throws Exception {
        //given
        board.addValueAtPosition(2, 0,0);
        board.addValueAtPosition(8, 0,1);
        board.addValueAtPosition(64, 0,2);
        board.addValueAtPosition(128, 0,3);

        board.addValueAtPosition(8, 1,0);
        board.addValueAtPosition(64, 1,1);
        board.addValueAtPosition(128, 1,2);
        board.addValueAtPosition(256, 1,3);

        board.addValueAtPosition(64, 2,0);
        board.addValueAtPosition(128, 2,1);
        board.addValueAtPosition(256, 2,2);
        board.addValueAtPosition(512, 2,3);

        board.addValueAtPosition(128, 3,0);
        board.addValueAtPosition(256, 3,1);
        board.addValueAtPosition(512, 3,2);
        board.addValueAtPosition(1024, 3,3);

        //when

        boolean canStillMove = board.areMovesStillPossible();


        //then
        assertThat(canStillMove).isFalse();
    }

    @Test
    public void should_tell_that_moves_are_still_possible() throws Exception {
        //given
        board.addValueAtPosition(8, 0,0);
        board.addValueAtPosition(8, 0,1);
        board.addValueAtPosition(64, 0,2);
        board.addValueAtPosition(128, 0,3);

        board.addValueAtPosition(8, 1,0);
        board.addValueAtPosition(64, 1,1);
        board.addValueAtPosition(128, 1,2);
        board.addValueAtPosition(256, 1,3);

        board.addValueAtPosition(64, 2,0);
        board.addValueAtPosition(128, 2,1);
        board.addValueAtPosition(256, 2,2);
        board.addValueAtPosition(512, 2,3);

        board.addValueAtPosition(128, 3,0);
        board.addValueAtPosition(256, 3,1);
        board.addValueAtPosition(512, 3,2);
        board.addValueAtPosition(1024, 3,3);

        //when

        boolean canStillMove = board.areMovesStillPossible();


        //then
        assertThat(canStillMove).isTrue();
    }
}
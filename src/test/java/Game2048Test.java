import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        verify(movingRules2048).moveUp(board);
    }

    @Test
    public void should_move_cells_down() throws Exception {
        game.moveDown();

        verify(movingRules2048).moveDown(board);
    }

    @Test
    public void should_move_cells_left() throws Exception {
        game.moveLeft();

        verify(movingRules2048).moveLeft(board);
    }

    @Test
    public void should_move_cells_right() throws Exception {
        game.moveRight();

        verify(movingRules2048).moveRight(board);
    }

    @Test
    public void you_select_a_zero_and_put_two() throws Exception {
        //given
        SimpleEntry<Integer,Integer> zeroIn0_0 = new SimpleEntry<>(0, 0);
        SimpleEntry<Integer,Integer> zeroIn0_2 = new SimpleEntry<>(0, 2);
        SimpleEntry<Integer,Integer> zeroIn4_0 = new SimpleEntry<>(2, 0);

        List<SimpleEntry<Integer,Integer>> zeros = Arrays.asList(zeroIn0_0,zeroIn0_2,zeroIn4_0);

        when(board.positionsOfZeros()).thenReturn(zeros);

        //when

        game.addTwoInRandomEmptyCell();

        //then
        ArgumentCaptor<Integer> number = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> columnIndex = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> rowIndex = ArgumentCaptor.forClass(Integer.class);
        verify(board).addValueAtPosition(number.capture(), columnIndex.capture(),rowIndex.capture());

        SimpleEntry<Integer,Integer> zeroFilledWithTwoPosition = new SimpleEntry<>(columnIndex.getValue(),rowIndex.getValue());

        assertThat(number.getValue()).isEqualTo(2);
        assertThat(zeros).contains(zeroFilledWithTwoPosition);
    }
}
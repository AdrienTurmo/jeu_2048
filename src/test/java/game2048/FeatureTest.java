package game2048;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FeatureTest {

    private Board board;
    private Game2048 game;

    @Mock
    private
    Printer printer;

    @Before
    public void setUp() throws Exception {
        board = new Board(4, 4);
        BoardPrinter boardPrinter = new BoardPrinter(printer);
        MovingRules2048 movingRules2048 = new MovingRules2048();
        game = new Game2048(board, movingRules2048, boardPrinter);
    }

    @Test
    public void should_move_up() throws Exception {
        board.addValueAtPosition(2, 0, 0);

        game.moveUp();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|2| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void should_move_up_and_merge_cells_if_they_have_same_value() throws Exception {
        board.addValueAtPosition(2, 0, 3);
        board.addValueAtPosition(2, 0, 2);

        game.moveUp();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void move_up_should_not_merge_cells_if_they_have_different_values() throws Exception {
        board.addValueAtPosition(4, 0, 3);
        board.addValueAtPosition(2, 0, 2);

        game.moveUp();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|2| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void should_move_down_and_merge_cells_or_not() throws Exception {
        board.addValueAtPosition(4, 0, 3);
        board.addValueAtPosition(2, 0, 2);

        board.addValueAtPosition(2, 2, 3);
        board.addValueAtPosition(2, 2, 1);

        game.moveDown();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|2| |4| |");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void when_moving_vertically_cells_should_merge_only_once() throws Exception {
        board.addValueAtPosition(2, 1, 3);
        board.addValueAtPosition(2, 1, 2);
        board.addValueAtPosition(4, 1, 1);

        board.addValueAtPosition(2, 3, 3);
        board.addValueAtPosition(2, 3, 2);
        board.addValueAtPosition(2, 3, 1);
        board.addValueAtPosition(2, 3, 0);

        game.moveDown();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| |4| |4|");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| |4| |4|");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void can_move_left() throws Exception {
        board.addValueAtPosition(4, 1, 3);
        board.addValueAtPosition(2, 3, 3);

        board.addValueAtPosition(2, 1, 2);
        board.addValueAtPosition(2, 3, 2);

        board.addValueAtPosition(2, 0, 1);
        board.addValueAtPosition(2, 1, 1);
        board.addValueAtPosition(2, 2, 1);
        board.addValueAtPosition(2, 3, 1);

        board.addValueAtPosition(2, 1, 0);
        board.addValueAtPosition(2, 2, 0);
        board.addValueAtPosition(2, 3, 0);

        game.moveLeft();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4|2| | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4| | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4|4| | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|4|2| | |");
        inOrder.verify(printer).print("---------");

    }

    @Test
    public void can_move_right() throws Exception {
        board.addValueAtPosition(4, 1, 3);
        board.addValueAtPosition(2, 3, 3);

        board.addValueAtPosition(2, 1, 2);
        board.addValueAtPosition(2, 3, 2);

        board.addValueAtPosition(4, 0, 1);
        board.addValueAtPosition(4, 1, 1);
        board.addValueAtPosition(4, 2, 1);
        board.addValueAtPosition(4, 3, 1);

        board.addValueAtPosition(2, 1, 0);
        board.addValueAtPosition(2, 2, 0);
        board.addValueAtPosition(2, 3, 0);

        game.moveRight();
        game.printBoard();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | |4|2|");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | |4|");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | |8|8|");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | |2|4|");
        inOrder.verify(printer).print("---------");
    }

    @Test
    public void can_add_a_two_in_a_random_empty_cell() throws Exception {
        //given
        board.addValueAtPosition(2,0,3);
        board.addValueAtPosition(4,1,3);
        board.addValueAtPosition(0,2,3);
        board.addValueAtPosition(4,3,3);

        board.addValueAtPosition(0,0,2);
        board.addValueAtPosition(0,1,2);
        board.addValueAtPosition(2,2,2);
        board.addValueAtPosition(0,3,2);

        board.addValueAtPosition(4,0,1);
        board.addValueAtPosition(8,1,1);
        board.addValueAtPosition(2,2,1);
        board.addValueAtPosition(4,3,1);

        board.addValueAtPosition(2,0,0);
        board.addValueAtPosition(0,1,0);
        board.addValueAtPosition(0,2,0);
        board.addValueAtPosition(0,3,0);

        int initialNumberOfZeros = 7;
        int initialNumberOfTwos = 4;

        //when

        game.addTwoInRandomEmptyCell();
        game.printBoard();

        //then

        ArgumentCaptor<String> text = ArgumentCaptor.forClass(String.class);
        verify(printer, times(9)).print(text.capture());

        List<String> listText = text.getAllValues();

        int numberOfZeros = 0;
        int numberOfTwos = 0;

        for (int index = 1 ; index <= 7 ; index += 2 ) {
            numberOfZeros += countNumberOfEmptyCellInString(listText.get(index));
            numberOfTwos += countNumberOfTwoInString(listText.get(index));
        }

        assertThat(numberOfZeros).isEqualTo(initialNumberOfZeros-1);
        assertThat(numberOfTwos).isEqualTo(initialNumberOfTwos+1);
    }

    @Test
    public void can_detect_if_no_more_moves_are_possible() throws Exception {
        //given
        board.addValueAtPosition(2,0,3);
        board.addValueAtPosition(4,1,3);
        board.addValueAtPosition(8,2,3);
        board.addValueAtPosition(16,3,3);

        board.addValueAtPosition(16,0,2);
        board.addValueAtPosition(8,1,2);
        board.addValueAtPosition(4,2,2);
        board.addValueAtPosition(2,3,2);

        board.addValueAtPosition(32,0,1);
        board.addValueAtPosition(64,1,1);
        board.addValueAtPosition(128,2,1);
        board.addValueAtPosition(256,3,1);

        board.addValueAtPosition(512,0,0);
        board.addValueAtPosition(128,1,0);
        board.addValueAtPosition(64,2,0);
        board.addValueAtPosition(32,3,0);

        //when

        boolean gameOver = game.isOver();

        //then

        assertThat(gameOver).isTrue();
    }


    private int countNumberOfTwoInString(String text) {
        List<String> characters = new ArrayList<>();
        for ( char c : text.toCharArray() ){
            characters.add(String.valueOf(c));
        }

        return (int) characters.stream().filter(s -> s.equals("2")).count();
    }
    private int countNumberOfEmptyCellInString(String text) {
        List<String> characters = new ArrayList<>();
        for ( char c : text.toCharArray() ){
            characters.add(String.valueOf(c));
        }

        return (int) characters.stream().filter(s -> s.equals(" ")).count();
    }
}
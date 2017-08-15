package game2048;

import game2048.Board;
import game2048.BoardPrinter;
import game2048.Printer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class BoardPrinterTest {

    private Board board;
    private BoardPrinter boardPrinter;

    @Mock
    private Printer printer;

    @Before
    public void setUp() throws Exception {
        board = new Board(4,4);
        boardPrinter = new BoardPrinter(printer);
    }

    @Test
    public void should_print_the_board() throws Exception {
        board.addValueAtPosition(2, 0, 0);

        boardPrinter.printBoard(board);

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("| | | | |");
        inOrder.verify(printer).print("---------");
        inOrder.verify(printer).print("|2| | | |");
        inOrder.verify(printer).print("---------");

    }

}
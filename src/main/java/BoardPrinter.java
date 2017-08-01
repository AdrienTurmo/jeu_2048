public class BoardPrinter {
    public static final String LINE_SEPARATOR = "---------";
    public static final String CELL_SEPARATOR = "|";
    private Printer printer;

    public BoardPrinter(Printer printer) {
        this.printer = printer;
    }

    public void printBoard(Board board) {
        for (int rowIndex = board.numberOfRows()-1 ; rowIndex>=0 ; rowIndex--) {
            printer.print(LINE_SEPARATOR);
            String line = "";
            for (int columnIndex = 0 ; columnIndex<board.numberOfColumns() ; columnIndex++) {
                int cellValue = board.valueAtPosition(columnIndex,rowIndex);
                line += CELL_SEPARATOR + (cellValue == 0 ? " " : cellValue);
            }
            line += CELL_SEPARATOR;
            printer.print(line);
        }

        printer.print(LINE_SEPARATOR);
    }
}

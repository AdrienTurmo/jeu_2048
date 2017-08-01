public class MovingRules2048 {

    public boolean moveCellsUp(Board board) {

        boolean boardMoved = false;

        while (moveCellsUpOnce(board)) {
            boardMoved = true;
        }

        return boardMoved;
    }

    private boolean moveCellsUpOnce(Board board) {
        boolean aCellMoved = false;
        for (int rowIndex = board.numberOfRows() - 1; rowIndex > 0; rowIndex--) {
            for (int columnIndex = 0; columnIndex < board.numberOfColumns(); columnIndex++) {

                int cellBelowValue = board.valueAtPosition(columnIndex, rowIndex - 1);
                if (cellBelowValue != 0) {
                    board.addValueAtPosition(cellBelowValue, columnIndex, rowIndex);
                    board.setValueToZeroAtPosition(columnIndex, rowIndex - 1);
                    aCellMoved = true;
                }

            }
        }
        return aCellMoved;
    }

}

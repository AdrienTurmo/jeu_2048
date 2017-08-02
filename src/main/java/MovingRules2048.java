public class MovingRules2048 {

    public boolean moveUp(Board board) {

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

                int belowCellValue = board.valueAtPosition(columnIndex, rowIndex - 1);
                int currentCellValue = board.valueAtPosition(columnIndex, rowIndex);
                if (belowCellValue != 0 && (currentCellValue == 0 || currentCellValue == belowCellValue)) {
                    board.addValueAtPosition(belowCellValue, columnIndex, rowIndex);
                    board.setValueToZeroAtPosition(columnIndex, rowIndex - 1);
                    aCellMoved = true;
                }

            }
        }
        return aCellMoved;
    }

    public boolean moveDown(Board board) {
        boolean boardMoved = false;
        while (moveCellsDown(board)) {
            boardMoved = true;
        }
        boardMoved = mergeCellsDown(board) || boardMoved;
        while (moveCellsDown(board)) {
            boardMoved = true;
        }

        return boardMoved;
    }

    private boolean mergeCellsDown(Board board) {
        boolean atLeastTwoCellsMerged = false;
        for (int rowIndex = 0; rowIndex < board.numberOfRows() - 1; rowIndex++) {
            for (int columnIndex = 0; columnIndex < board.numberOfColumns(); columnIndex++) {

                int upwardCellValue = board.valueAtPosition(columnIndex, rowIndex + 1);
                int currentCellValue = board.valueAtPosition(columnIndex, rowIndex);
                if (currentCellValue == upwardCellValue) {
                    board.addValueAtPosition(upwardCellValue, columnIndex, rowIndex);
                    board.setValueToZeroAtPosition(columnIndex, rowIndex + 1);
                    atLeastTwoCellsMerged = true;
                }

            }
        }
        return atLeastTwoCellsMerged;
    }

    private boolean moveCellsDown(Board board) {
        boolean aCellMoved = false;
        for (int rowIndex = board.numberOfRows() - 1; rowIndex > 0; rowIndex--) {
            for (int columnIndex = 0; columnIndex < board.numberOfColumns(); columnIndex++) {

                int bellowCellValue = board.valueAtPosition(columnIndex, rowIndex - 1);
                int currentCellValue = board.valueAtPosition(columnIndex, rowIndex);

                if (bellowCellValue == 0 && currentCellValue != 0) {
                    board.addValueAtPosition(currentCellValue, columnIndex, rowIndex - 1);
                    board.setValueToZeroAtPosition(columnIndex, rowIndex);
                    aCellMoved = true;
                }

            }
        }
        return aCellMoved;
    }

    private boolean moveCellsDownOnce(Board board) {
        boolean aCellMoved = false;
        for (int rowIndex = 0; rowIndex < board.numberOfRows() - 1; rowIndex++) {
            for (int columnIndex = 0; columnIndex < board.numberOfColumns(); columnIndex++) {

                int cellUpwardValue = board.valueAtPosition(columnIndex, rowIndex + 1);
                int currentCellValue = board.valueAtPosition(columnIndex, rowIndex);
                if (cellUpwardValue != 0 && (currentCellValue == 0 || currentCellValue == cellUpwardValue)) {
                    board.addValueAtPosition(cellUpwardValue, columnIndex, rowIndex);
                    board.setValueToZeroAtPosition(columnIndex, rowIndex + 1);
                    aCellMoved = true;
                }

            }
        }
        return aCellMoved;
    }
}

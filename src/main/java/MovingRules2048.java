import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MovingRules2048 {

    public boolean moveUp(Board board) {

        boolean boardMoved = false;

        while (moveCellsUp(board)) {
            boardMoved = true;
        }
        boardMoved = mergeCellsUp(board) || boardMoved;
        while (moveCellsUp(board)) {
            boardMoved = true;
        }
        return boardMoved;
    }

    private boolean moveCellsUp(Board board) {
        boolean aCellMoved = false;
        for (int rowIndex = 0; rowIndex < board.numberOfRows() - 1; rowIndex++) {
            for (int columnIndex = 0; columnIndex < board.numberOfColumns(); columnIndex++) {

                int upwardCellValue = board.valueAtPosition(columnIndex, rowIndex + 1);
                int currentCellValue = board.valueAtPosition(columnIndex, rowIndex);
                if (upwardCellValue == 0 && currentCellValue != 0) {
                    board.addValueAtPosition(currentCellValue, columnIndex, rowIndex + 1);
                    board.setValueToZeroAtPosition(columnIndex, rowIndex);
                    aCellMoved = true;
                }

            }
        }
        return aCellMoved;
    }

    private boolean mergeCellsUp(Board board) {
        boolean atLeastTwoCellsMerged = false;
        for (int rowIndex = board.numberOfRows() - 1; rowIndex > 0; rowIndex--) {
            for (int columnIndex = 0; columnIndex < board.numberOfColumns(); columnIndex++) {

                int downwardCellValue = board.valueAtPosition(columnIndex, rowIndex - 1);
                int currentCellValue = board.valueAtPosition(columnIndex, rowIndex);
                if (currentCellValue == downwardCellValue && currentCellValue != 0) {
                    board.addValueAtPosition(downwardCellValue, columnIndex, rowIndex);
                    board.setValueToZeroAtPosition(columnIndex, rowIndex - 1);
                    atLeastTwoCellsMerged = true;
                }

            }
        }
        return atLeastTwoCellsMerged;
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

    private boolean moveCellsDown(Board board) {
        boolean aCellMoved = false;
        for (int rowIndex = board.numberOfRows() - 1; rowIndex > 0; rowIndex--) {
            for (int columnIndex = 0; columnIndex < board.numberOfColumns(); columnIndex++) {

                int downwardCellValue = board.valueAtPosition(columnIndex, rowIndex - 1);
                int currentCellValue = board.valueAtPosition(columnIndex, rowIndex);

                if (downwardCellValue == 0 && currentCellValue != 0) {
                    board.addValueAtPosition(currentCellValue, columnIndex, rowIndex - 1);
                    board.setValueToZeroAtPosition(columnIndex, rowIndex);
                    aCellMoved = true;
                }

            }
        }
        return aCellMoved;
    }

    private boolean mergeCellsDown(Board board) {
        boolean atLeastTwoCellsMerged = false;
        for (int rowIndex = 0; rowIndex < board.numberOfRows() - 1; rowIndex++) {
            for (int columnIndex = 0; columnIndex < board.numberOfColumns(); columnIndex++) {

                int upwardCellValue = board.valueAtPosition(columnIndex, rowIndex + 1);
                int currentCellValue = board.valueAtPosition(columnIndex, rowIndex);
                if (currentCellValue == upwardCellValue && currentCellValue != 0) {
                    board.addValueAtPosition(upwardCellValue, columnIndex, rowIndex);
                    board.setValueToZeroAtPosition(columnIndex, rowIndex + 1);
                    atLeastTwoCellsMerged = true;
                }

            }
        }
        return atLeastTwoCellsMerged;
    }

    public boolean moveLeft(Board board) {
        boolean boardMoved = false;
        while (moveCellsLeft(board)) {
            boardMoved = true;
        }
        boardMoved = mergeCellsLeft(board) || boardMoved;
        while (moveCellsLeft(board)) {
            boardMoved = true;
        }

        return boardMoved;
    }

    private boolean moveCellsLeft(Board board) {
        boolean aCellMoved = false;

        for (int columnIndex = 0; columnIndex < board.numberOfColumns() - 1; columnIndex++) {
            for (int rowIndex = 0; rowIndex < board.numberOfRows(); rowIndex++) {

                int currentCellValue = board.valueAtPosition(columnIndex, rowIndex);
                int leftCellValue = board.valueAtPosition(columnIndex + 1, rowIndex);

                if (leftCellValue == 0 && currentCellValue != 0) {
                    board.addValueAtPosition(currentCellValue, columnIndex+1, rowIndex);
                    board.setValueToZeroAtPosition(columnIndex,rowIndex);
                    aCellMoved = true;
                }


            }
        }

        return aCellMoved;
    }

    private boolean mergeCellsLeft(Board board) {
        boolean atLeastTwoCellsMerged = false;

        for (int columnIndex = board.numberOfColumns()-1; columnIndex > 0; columnIndex--) {
            for (int rowIndex = 0; rowIndex < board.numberOfRows(); rowIndex++) {

                int currentCellValue = board.valueAtPosition(columnIndex, rowIndex);
                int rightCellValue = board.valueAtPosition(columnIndex - 1, rowIndex);

                if (rightCellValue == currentCellValue && currentCellValue != 0) {
                    board.addValueAtPosition(rightCellValue, columnIndex, rowIndex);
                    board.setValueToZeroAtPosition(columnIndex-1, rowIndex);
                    atLeastTwoCellsMerged = true;
                }

            }
        }

        return atLeastTwoCellsMerged;
    }
}

import java.util.Arrays;

public class Board {
    int[][] cellTable;

    public Board(int nbColumns, int nbRows) {
        cellTable = new int[nbColumns][nbRows];

        for (int columnIndex = 0; columnIndex < nbColumns ; columnIndex++) {
            for (int rowIndex = 0; rowIndex < nbRows ; rowIndex++) {
                cellTable[columnIndex][rowIndex] = 0;
            }
        }

    }

    public void put2AtPosition(int columnIndex, int rowIndex) {
        cellTable[columnIndex][rowIndex] = 2;
    }

    public int valueAtPosition(int columnIndex, int rowIndex) {
        return cellTable[columnIndex][rowIndex];
    }

    public boolean moveCellsUpByOne() {
        boolean aCellMoved = false;

        for (int rowIndex = numberOfRows()-1; rowIndex > 0 ; rowIndex--) {
            for (int columnIndex = 0; columnIndex < numberOfColumns(); columnIndex++) {
                if (cellTable[columnIndex][rowIndex-1] != 0) {
                    if (cellTable[columnIndex][rowIndex] == cellTable[columnIndex][rowIndex - 1]) {
                        cellTable[columnIndex][rowIndex] = 2 * cellTable[columnIndex][rowIndex - 1];
                        cellTable[columnIndex][rowIndex - 1] = 0;
                        aCellMoved = true;
                    }
                    if (cellTable[columnIndex][rowIndex] == 0) {
                        cellTable[columnIndex][rowIndex] = cellTable[columnIndex][rowIndex - 1];
                        cellTable[columnIndex][rowIndex - 1] = 0;
                        aCellMoved = true;
                    }
                }
            }
        }
        return aCellMoved;
    }

    private int numberOfRows() {
        return cellTable[0].length;
    }

    private int numberOfColumns() {
        return cellTable.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.equals(this.cellTable, board.cellTable);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cellTable);
    }
}

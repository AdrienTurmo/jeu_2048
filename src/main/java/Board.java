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


    public int numberOfRows() {
        return cellTable[0].length;
    }

    public int numberOfColumns() {
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

    public void addValueAtPosition(int value, int columnIndex, int rowIndex) {
        cellTable[columnIndex][rowIndex] += value;
    }

    public void setValueToZeroAtPosition(int columnIndex, int rowIndex) {
        cellTable[columnIndex][rowIndex] = 0;
    }
}

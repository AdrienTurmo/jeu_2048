import java.util.Arrays;

public class Board {
    int[][] cellTable;

    public Board(int nbRow, int nbColumn) {
        cellTable = new int[nbRow][nbColumn];
        for (int rowIndex = 0; rowIndex < 4 ; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 4 ; columnIndex++) {
                cellTable[rowIndex][columnIndex] = 0;
            }
        }
    }

    public void put2AtPosition(int rowIndex, int columnIndex) {
        cellTable[rowIndex][columnIndex] = 2;
    }

    public int valueAtPosition(int rowIndex, int columnIndex) {
        return cellTable[rowIndex][columnIndex];
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
}

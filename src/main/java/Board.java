import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    public void put2AtPosition(int columnIndex, int rowIndex) {
        cellTable[columnIndex][rowIndex] = 2;
    }

    public int valueAtPosition(int columnIndex, int rowIndex) {
        return cellTable[columnIndex][rowIndex];
    }

    public boolean moveCellsUpByOne() {
        throw new NotImplementedException();
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

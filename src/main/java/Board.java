import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    public void put2AtPosition(int row, int column) {
        throw new NotImplementedException();
    }

    public int valueAtPosition(int rowIndex, int columnIndex) {
        return cellTable[rowIndex][columnIndex];
    }
}

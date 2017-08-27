package game2048;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Board {
    private int[][] cellTable;

    public Board(int nbColumns, int nbRows) {
        cellTable = new int[nbColumns][nbRows];

        for (int columnIndex = 0; columnIndex < nbColumns; columnIndex++) {
            for (int rowIndex = 0; rowIndex < nbRows; rowIndex++) {
                cellTable[columnIndex][rowIndex] = 0;
            }
        }
    }

    public void addValueAtPosition(int value, int columnIndex, int rowIndex) {
        cellTable[columnIndex][rowIndex] += value;
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

    public void setValueToZeroAtPosition(int columnIndex, int rowIndex) {
        cellTable[columnIndex][rowIndex] = 0;
    }

    public List<SimpleEntry<Integer, Integer>> positionsOfZeros() {
        List<SimpleEntry<Integer, Integer>> zeros = new ArrayList<>();


        for (int rowIndex = 0; rowIndex < numberOfRows(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns(); columnIndex++) {
                if (valueAtPosition(columnIndex, rowIndex) == 0) {
                    zeros.add(new SimpleEntry<>(columnIndex, rowIndex));
                }
            }
        }

        return zeros;
    }

    public boolean areMovesStillPossible() {

        for (int rowIndex = 0; rowIndex < numberOfRows(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns(); columnIndex++) {
                if (valueAtPosition(columnIndex, rowIndex) == 0) {
                    return true;
                }
            }
        }
        for (int rowIndex = 0; rowIndex < numberOfRows() - 1; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns(); columnIndex++) {
                if (valueAtPosition(columnIndex, rowIndex + 1) == valueAtPosition(columnIndex, rowIndex)) {
                    return true;
                }
            }
        }
        for (int rowIndex = 1; rowIndex < numberOfRows(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns(); columnIndex++) {
                if (valueAtPosition(columnIndex, rowIndex - 1) == valueAtPosition(columnIndex, rowIndex)) {
                    return true;
                }
            }
        }
        for (int rowIndex = 0; rowIndex < numberOfRows(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns() - 1; columnIndex++) {
                if (valueAtPosition(columnIndex + 1, rowIndex) == valueAtPosition(columnIndex, rowIndex)) {
                    return true;
                }
            }
        }
        for (int rowIndex = 0; rowIndex < numberOfRows(); rowIndex++) {
            for (int columnIndex = 1; columnIndex < numberOfColumns(); columnIndex++) {
                if (valueAtPosition(columnIndex - 1, rowIndex) == valueAtPosition(columnIndex, rowIndex)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void forEachCell(Function<Object, Integer> function) {
        for (int rowIndex = 0; rowIndex < numberOfRows(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns(); columnIndex++) {
                function.apply(valueAtPosition(columnIndex, rowIndex));
            }
        }
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


    public int[][] getTable() {
        return cellTable;
    }

}

package lab4;

public class MultiDimensionalArray {
    private final int[] dimensions;
    private final int[] strides;
    private final double[] data;

    public MultiDimensionalArray(int[] dimensions) {
        this.dimensions = dimensions;
        this.strides = new int[dimensions.length];
        int stride = 1;
        for (int i = 0; i < dimensions.length; i++) {
            this.strides[i] = stride;
            stride *= dimensions[i];
        }
        this.data = new double[stride];
    }

    public double get(int... indices) {
        int index = getIndex(indices);
        return data[index];
    }

    public void set(double value, int... indices) {
        int index = getIndex(indices);
        data[index] = value;
    }


    public double getAiliff(int... indices) {
        int[] coords = getAiliffCoords(indices);
        int index = getIndex(coords);
        return data[index];
    }

    public void setAiliff(double value, int... indices) {
        int[] coords = getAiliffCoords(indices);
        int index = getIndex(coords);
        data[index] = value;
    }


    public double[] getColumn(int columnIndex) {
        double[] column = new double[dimensions[0]];
        for (int i = 0; i < dimensions[0]; i++) {
            int index = getIndex(i, columnIndex);
            column[i] = data[index];
        }
        return column;
    }

    public double[] getRow(int rowIndex) {
        double[] row = new double[dimensions[1]];
        for (int i = 0; i < dimensions[1]; i++) {
            int index = getIndex(rowIndex, i);
            row[i] = data[index];
        }
        return row;
    }

    private int getIndex(int... indices) {
        int index = 0;
        for (int i = 0; i < indices.length; i++) {
            index += indices[i] * strides[i];
        }
        return index;
    }

    private int[] getAiliffCoords(int... indices) {
        int[] coords = new int[dimensions.length];
        coords[0] = indices[0];
        for (int i = 1; i < dimensions.length; i++) {
            coords[i] = (indices[i] - 1) / coords[i - 1];
        }
        return coords;
    }
}


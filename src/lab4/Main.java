package lab4;

public class Main {
    public static void main(String[] args) {
        int[] dimensions = { 3, 4, 5 };
        MultiDimensionalArray array = new MultiDimensionalArray(dimensions);

// Прямой доступ
        array.set(42.0, 1, 2, 3);
        double value1 = array.get(1, 2, 3);

// Доступ посредством векторов Айлиффа
        int[] indices = { 2, 3, 4 };
        array.setAiliff(42.0, 2, 3, 4);
        double value2 = array.getAiliff(indices);
// Метод определяющих векторов
        double[] column = array.getColumn(1);
        double[] row = array.getRow(2);

        System.out.println("Прямой доступ: " + AccessTime.straightAccess());
        System.out.println("Доступ посредством векторов Айлиффа: " + AccessTime.AiliffAccess());
        System.out.println("Метод определяющих векторов: " + AccessTime.DefiningVectorsAccess());

    }
}

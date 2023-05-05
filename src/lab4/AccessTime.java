package lab4;

public class AccessTime {
    static MultiDimensionalArray array = new MultiDimensionalArray(new int[]{100,100,100});

    public static long straightAccess(){
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            array.set(42.0, 50, 50, 50);
            double value = array.get(50, 50, 50);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public static long AiliffAccess(){
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            array.setAiliff(42.0, 51, 51, 51);
            double value = array.getAiliff(51, 51, 51);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;


    }
    public static long DefiningVectorsAccess(){
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            double[] column = array.getColumn(50);
            double[] row = array.getRow(50);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}

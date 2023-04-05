package lab2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Dish> listOfDishes = new ArrayList<>(ReadingFomFile.getList());
    public static void main(String[] args) {

        // bubbleSort();
        // quickSort();
       // insertionSort();



    }

    public static void insertionSort(){
        int before = (int) System.currentTimeMillis();

        Sort.insertionSort(listOfDishes);
        for (Dish d: listOfDishes) {
            System.out.println(d.toString());
        }

        int after = (int) System.currentTimeMillis();
        System.out.println("Execution time = " + (after - before) + " ms.");
        System.out.println("Algorithm difficulty in the worst case : O(n)");
        System.out.println("Algorithm difficulty in the major case : O(n2)");
        System.out.println("Algorithm difficulty in the best case : O(n2)");
    }
    public static void bubbleSort(){
        int before = (int) System.currentTimeMillis();

        Sort.bubbleSort(listOfDishes);
        for (Dish d: listOfDishes) {
            System.out.println(d.toString());
        }

        int after = (int) System.currentTimeMillis();
        System.out.println("Execution time = " + (after - before) + " ms.");
        System.out.println("Algorithm difficulty in the worst case : O(n^2)");
        System.out.println("Algorithm difficulty in the major case : O(n^2)");
        System.out.println("Algorithm difficulty in the best case : O(n)");
    }

    public static void quickSort(){
        int before = (int) System.currentTimeMillis();
        Sort.quickSort(listOfDishes,0,15);
        for (Dish d: listOfDishes) {
            System.out.println(d.toString());
        }
        int after = (int) System.currentTimeMillis();
        System.out.println("Execution time = " + (after - before) + " ms.");
        System.out.println("Algorithm difficulty in the worst case : O(nlogn)");
        System.out.println("Algorithm difficulty in the major case : O(nlogn)");
        System.out.println("Algorithm difficulty in the best case : O(n^2)");
    }
}

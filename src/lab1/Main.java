package lab1;

import lab0.Category;
import lab0.Dish;
import lab0.Type;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static lab0.Dish.inputStreamDemo;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            File restaurantDishes= new File("D:\\IntelliJ\\ASDC\\src\\lab0" +
                    "\\restaurant_menu.txt");
            String[] fileStrings = inputStreamDemo(restaurantDishes);
            var list = new ArrayList<>(Arrays.stream(fileStrings)
                    .map(x -> x.split(","))
                    .map(z -> new Dish(Integer.parseInt(z[0]), z[1], Integer.parseInt(z[2]), Integer.parseInt(z[3]), Type.valueOf(z[5]), Category.valueOf(z[4])))
                    .sorted()
                    .toList());


            int[] arr = new int[list.size()];
            for (Dish dish: list
            ) {
                Dish dish1=new Dish(dish);
                Arrays.fill(arr, dish1.getId());
            }
            Search.linearSearch(arr,5);

            FibonacciSearch fs = new FibonacciSearch();

            int element = scanner.nextInt();
            int index = fs.search(arr, element);
            System.out.println(index);

            System.out.println(Search.interpolationSearch(arr, element));



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

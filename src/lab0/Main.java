package lab0;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static lab0.Dish.*;

public class Main {
    public static void main(String[] args) {
        try {
            File restaurantDishes= new File("D:\\IntelliJ\\ASDC\\src\\lab0" +
                    "\\restaurant_menu.txt");
            String[] fileStrings = inputStreamDemo(restaurantDishes);

            var list = Arrays.stream(fileStrings)
                    .map(x -> x.split(","))
                    .map(z-> new Dish(Integer.parseInt(z[0]),z[1],Integer.parseInt(z[2]),Integer.parseInt(z[3]), Type.valueOf(z[5]), Category.valueOf(z[4])))
                    .toList();
            ///output only salads(enum)
            list.stream().filter(dish -> dish.getType()==Type.Salad).forEach(System.out::println);
            System.out.println("--------------------------------------------------------------------------------------");
            /// weight>300
            list.stream().filter(dish -> dish.getWeight()>300).forEach(System.out::println);

            Scanner sc = new Scanner(System.in);
            Dish.outputStreamDemo(restaurantDishes,sc.nextLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

///with stream count second minimal element by price
        /*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
        //same thing as 17-22 lines(but without lambada)
//            Dish[] arrayOfDishes = new Dish[16];
//            for (int i = 0; i < fileStrings.length; i++) {
//                String[] temp =
//                        fileStrings[i].split(",");
//                int id = Integer.parseInt(temp[0]);
//                String name = temp[1];
//                int price = Integer.parseInt(temp[2]);
//                int weight = Integer.parseInt(temp[3]);
//                Category category = Category.valueOf(temp[4]);
//                Type type = Type.valueOf(temp[5]);
//                arrayOfDishes[i] = (new Dish(id, name, price, weight, type, category));
//            }
//            for (Dish dish : list) {
//                System.out.println(dish.getId());
//            }

    }


}

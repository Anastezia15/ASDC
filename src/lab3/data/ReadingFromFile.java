package lab3.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReadingFromFile {
    public static List<Dish> getList(){
        List<Dish> listOfDishes;
        try {
            File restaurantDishes= new File("/Users/agavriluta/Desktop/IntelliJ/ASDC/src/lab2/restaurant_menu.txt");
            String[] fileStrings = inputStreamDemo(restaurantDishes);

            listOfDishes = Arrays.stream(fileStrings)
                    .map(x -> x.split(","))
                    .map(z-> new Dish(Integer.parseInt(z[0]),z[1],Integer.parseInt(z[2]),Integer.parseInt(z[3]), Type.valueOf(z[5]), Category.valueOf(z[4])))
                    .toList();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfDishes;
    }
    private static String[] inputStreamDemo(File readingFile) throws IOException {
        String[] array = new String[16];
        try (BufferedReader inputStream = new BufferedReader(new FileReader(readingFile))) {
            for (int i = 0; inputStream.read() != -1; i++) {
                if (i < array.length){
                    array[i] = inputStream.readLine();
                }
            }
        }
        return array;
    }
}

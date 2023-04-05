package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {


    public static List<Dish> bubbleSort(List<Dish> list) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getId() > list.get(j).getId()) {
                    Dish temp = new Dish(list.get(i));
                    list.remove(i);
                    list.add(i, list.get(j - 1));
                    list.remove(j);
                    list.add(j, temp);
                }
            }

        }

        return list;
    }


    public static List<Dish> quickSort(List<Dish> list, int low, int high) {

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        Dish border = new Dish(list.get(middle));
        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (list.get(i).getId() < border.getId()) i++;
            while (list.get(j).getId() > border.getId()) j--;
            if (i <= j) {
                Dish temp = new Dish(list.get(i));
                list.remove(i);
                list.add(i, list.get(j - 1));
                list.remove(j);
                list.add(j, temp);
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(list, low, j);
        if (high > i) quickSort(list, i, high);

        return list;

    }

    public static List<Dish> insertionSort(List<Dish> list) {
        Dish[] dishes = new Dish[16];
        for (int i = 0; i < list.size(); i++) {
            dishes[i] = list.get(i);
        }
        int j;
        for (int i = 1; i < dishes.length; i++) {

            Dish swap = dishes[i];
            for (j = i; j > 0 && swap.getId() < dishes[j - 1].getId(); j--) {

                dishes[j] = dishes[j - 1];
            }
            dishes[j] = swap;
        }
        list.clear();
        list.addAll(Arrays.stream(dishes).toList());
        return list;
    }
}

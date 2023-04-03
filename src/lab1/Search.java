package lab1;
import lab0.Category;
import lab0.Dish;
import lab0.Type;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static lab0.Dish.*;

public class Search {


    public static int linearSearch(int[] arr, int elementToSearch) {
        Arrays.sort(arr);

        for (int index = 0; index < arr.length; index++) {
            if (arr[index]==elementToSearch)
                return index;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int elementToSearch) {
        Arrays.sort(arr);
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // условие прекращения (элемент не представлен)
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[middleIndex]==elementToSearch) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (arr[middleIndex]<elementToSearch)
                firstIndex = middleIndex + 1;

                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (arr[middleIndex]>elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }

    public static int interpolationSearch(int[] sequince, int element) {
        int l = 0;
        int r = sequince.length - 1;
        for (; sequince[l] < element && element < sequince[r];) {
            if (sequince[l] == sequince[r]) {
                break;
            }
            int index = (int) ((long) (element - sequince[l]) * (l - r) / (sequince[l] - sequince[r]) + l);
            if (sequince[index] > element) {
                r = index - 1;
            } else if (sequince[index] < element) {
                l = index + 1;
            } else {
                return index;
            }
        }
        if (sequince[l] == element) {
            return l;
        }
        if (sequince[r] == element) {
            return r;
        }
        return -1;
    }

}




package test2;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSortArrayList { 

    private static final Random random = new Random();

    public static <T extends Comparable<T>> void quickSort(List<T> list, int low, int high) {
        if (low < high) {
            int pi = randomPartition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int randomPartition(List<T> list, int low, int high) {
        // Pick a random pivot index between low and high
        int randomIndex = low + random.nextInt(high - low + 1);

        // Swap the random pivot with the last element
        Collections.swap(list, randomIndex, high);

        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    }
}

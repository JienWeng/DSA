package test2;

import java.util.LinkedList;
import java.util.Random;

public class QuickSortLinkedList {

    private static final Random random = new Random();

    public static <T extends Comparable<T>> void quickSort(LinkedList<T> list) {
        if (list.size() <= 1) return; // Base case: list is already sorted
        quickSort(list, 0, list.size() - 1);
    }

    static <T extends Comparable<T>> void quickSort(LinkedList<T> list, int low, int high) {
        if (low < high) {
            int pi = randomPartition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int randomPartition(LinkedList<T> list, int low, int high) {
        // Pick a random pivot index between low and high
        int randomIndex = low + random.nextInt(high - low + 1);

        // Swap the random pivot with the last element
        swap(list, randomIndex, high);

        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(LinkedList<T> list, int i, int j) {
        if (i == j) return;

        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

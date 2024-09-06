package DSA;

import java.util.List;

public class TimSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    @Override
    public void sort(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        list.sort(Comparable::compareTo); // Uses Java's built-in TimSort
    }
}
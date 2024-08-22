package test2;

import java.util.List;

@FunctionalInterface
public interface SortingAlgorithm<T> {
    void sort(List<T> list);
}

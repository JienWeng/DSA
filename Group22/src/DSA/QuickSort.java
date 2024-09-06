package DSA;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class QuickSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    private static final Random random = new Random();

    @Override
    public void sort(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List<T> list, int low, int high) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{low, high});
        
        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            low = range[0];
            high = range[1];
            
            if (low < high) {
                int pi = medianOfThreePartition(list, low, high);
                stack.push(new int[]{low, pi - 1});
                stack.push(new int[]{pi + 1, high});
            }
        }
    }

    private int medianOfThreePartition(List<T> list, int low, int high) {
        int mid = low + (high - low) / 2;
        int medianIndex = medianOfThree(list, low, mid, high);
        Collections.swap(list, medianIndex, high);
        return partition(list, low, high);
    }

    private int medianOfThree(List<T> list, int low, int mid, int high) {
        T a = list.get(low);
        T b = list.get(mid);
        T c = list.get(high);
        
        if (a.compareTo(b) > 0) {
            if (b.compareTo(c) > 0) {
                return mid;
            } else if (a.compareTo(c) > 0) {
                return high;
            } else {
                return low;
            }
        } else {
            if (a.compareTo(c) > 0) {
                return low;
            } else if (b.compareTo(c) > 0) {
                return high;
            } else {
                return mid;
            }
        }
    }

    private int partition(List<T> list, int low, int high) {
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
package test2;
import java.util.*;

public class HeapArray {
	// Heap sort for List<Integer>
    public static void sortIntegers(List<Integer> list) {
        int N = list.size();

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapifyIntegers(list, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            Collections.swap(list, 0, i);

            // Call max heapify on the reduced heap
            heapifyIntegers(list, i, 0);
        }
    }

    // Heapify function for List<Integer>
    public static void heapifyIntegers(List<Integer> list, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && list.get(l) > list.get(largest))
            largest = l;

        // If right child is larger than largest so far
        if (r < N && list.get(r) > list.get(largest))
            largest = r;

        // If largest is not root
        if (largest != i) {
            Collections.swap(list, i, largest);

            // Recursively heapify the affected sub-tree
            heapifyIntegers(list, N, largest);
        }
    }

    // Heap sort for List<String>
    public static void sortStrings(List<String> list) {
        int N = list.size();

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapifyStrings(list, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            Collections.swap(list, 0, i);

            // Call max heapify on the reduced heap
            heapifyStrings(list, i, 0);
        }
    }

    // Heapify function for List<String>
    public static void heapifyStrings(List<String> list, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && list.get(l).compareTo(list.get(largest)) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < N && list.get(r).compareTo(list.get(largest)) > 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            Collections.swap(list, i, largest);

            // Recursively heapify the affected sub-tree
            heapifyStrings(list, N, largest);
        }
    }
}

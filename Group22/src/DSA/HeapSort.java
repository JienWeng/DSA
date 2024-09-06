package DSA;

import java.util.List;

public class HeapSort<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public void sort(List<T> list) {
        int n = list.size();

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            T temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            // Call heapify on the reduced heap
            heapify(list, i, 0);
        }
    }

    // To heapify a subtree rooted with node i, which is an index in the list[]
    // n is the size of the heap
    private void heapify(List<T> list, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && list.get(left).compareTo(list.get(largest)) > 0) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && list.get(right).compareTo(list.get(largest)) > 0) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            // Swap list[i] and list[largest]
            T swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(list, n, largest);
        }
    }
}
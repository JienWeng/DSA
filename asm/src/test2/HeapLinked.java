package test2;
import java.util.*;
public class HeapLinked {
	public static void sort(LinkedList<Integer> list) {
        int N = list.size();

        // Build heap (rearrange list)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(list, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            Collections.swap(list, 0, i);

            // call max heapify on the reduced heap
            heapify(list, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in list. n is size of heap
    public static void heapify(LinkedList<Integer> list, int N, int i) {
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
            heapify(list, N, largest);
        }
    }
	

}

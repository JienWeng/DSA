package DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortingCaseTester {

    public static void main(String[] args) {
        // Number of elements to sort for the test
        int size = 10000000;

        // Generate average case (random) dataset
        List<Integer> averageCase = generateRandomList(size);
        List<Integer> worstCase = generateWorstCaseList(size);

        System.out.println("Testing Average Case (Random) Data:");
        SortingComparison.compareSortingAlgorithms(averageCase);

        System.out.println("\nTesting Worst Case (Sorted) Data:");
        SortingComparison.compareSortingAlgorithms(worstCase);

        // If needed, we can reverse the worst case to get reverse sorted list
        Collections.reverse(worstCase);
        System.out.println("\nTesting Worst Case (Reverse Sorted) Data:");
        SortingComparison.compareSortingAlgorithms(worstCase);
    }

    // Generates a random list of integers
    public static List<Integer> generateRandomList(int size) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(size));
        }
        return list;
    }

    // Generates a worst-case list (sorted in ascending order)
    public static List<Integer> generateWorstCaseList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }
}

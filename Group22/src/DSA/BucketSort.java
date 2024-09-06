package DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    @Override
    public void sort(List<T> list) {
        if (list.isEmpty()) return;

        // Check if the first element is an Integer or String to determine the sorting method
        if (list.get(0) instanceof Integer) {
            sortIntegers((List<Integer>) list);
        } else if (list.get(0) instanceof String) {
            sortStrings((List<String>) list);
        }
    }

    private void sortIntegers(List<Integer> list) {
        if (list.isEmpty()) return;

        // Define a fixed number of buckets
        int bucketCount = 10; // You can adjust this number based on your needs
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        // Initialize buckets
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new LinkedList<>());
        }

        // Find the range of the input values
        int minValue = list.stream().min(Integer::compare).orElse(0);
        int maxValue = list.stream().max(Integer::compare).orElse(0);
        int range = maxValue - minValue + 1;

        // If range is 0, all elements are the same, put them in the first bucket
        if (range == 1) {
            buckets.get(0).addAll(list);
        } else {
            // Distribute elements into buckets
            for (Integer num : list) {
                // Normalize to bucket index
                int bucketIndex = (num - minValue) * (bucketCount - 1) / (range - 1);
                // Clamp the index to ensure it's within bounds
                bucketIndex = Math.max(0, Math.min(bucketIndex, bucketCount - 1));
                buckets.get(bucketIndex).add(num);
            }
        }

        // Clear the original list and merge the buckets back
        list.clear();
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); // Sort each bucket
            list.addAll(bucket); // Merge sorted buckets
        }
    }

    private void sortStrings(List<String> list) {
        if (list.isEmpty()) return;

        // Define a fixed number of buckets (e.g., 52 for both lowercase and uppercase letters)
        int bucketCount = 52; // Adjust as needed for your character set
        List<List<String>> buckets = new ArrayList<>(bucketCount);

        // Initialize buckets
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new LinkedList<>());
        }

        // Distribute elements into buckets based on the first character
        for (String str : list) {
            if (str.isEmpty()) continue; // Skip empty strings
            char firstChar = Character.toLowerCase(str.charAt(0)); // Handle case sensitivity
            int bucketIndex;

            // Determine bucket index based on character
            if (firstChar >= 'a' && firstChar <= 'z') {
                bucketIndex = firstChar - 'a'; // 0-25 for lowercase letters
            } else if (firstChar >= 'A' && firstChar <= 'Z') {
                bucketIndex = firstChar - 'A' + 26; // 26-51 for uppercase letters
            } else {
                continue; // Skip non-alphabetic characters
            }

            buckets.get(bucketIndex).add(str);
        }

        // Clear the original list and merge the buckets back
        list.clear();
        for (List<String> bucket : buckets) {
            Collections.sort(bucket); // Sort each bucket
            list.addAll(bucket); // Merge sorted buckets
        }
    }
}
package test2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BucketSortLinkedList {

    public static void bucketSort(LinkedList<Integer> list) {
        if (list.isEmpty()) return;

        int max = list.stream().mapToInt(Integer::intValue).max().orElse(0);
        int min = list.stream().mapToInt(Integer::intValue).min().orElse(0);
        int range = (max - min) / list.size() + 1;
        int bucketCount = (max - min) / range + 1;
        LinkedList<LinkedList<Integer>> buckets = new LinkedList<>();

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new LinkedList<>());
        }

        for (Integer number : list) {
            int bucketIndex = (number - min) / range;
            buckets.get(bucketIndex).add(number);
        }

        list.clear();
        for (LinkedList<Integer> bucket : buckets) {
            countingSort(bucket);  // Use counting sort instead of sorting
            list.addAll(bucket);
        }
    }

    private static void countingSort(LinkedList<Integer> bucket) {
        if (bucket.isEmpty()) return;

        int max = bucket.stream().mapToInt(Integer::intValue).max().orElse(0);
        int min = bucket.stream().mapToInt(Integer::intValue).min().orElse(0);
        int range = max - min + 1;

        int[] count = new int[range];
        for (Integer num : bucket) {
            count[num - min]++;
        }

        bucket.clear();
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                bucket.add(i + min);
            }
        }
    }

    public static void bucketSortWorstCase(LinkedList<Integer> list) {
        if (list.isEmpty()) return;

        // Create a single bucket for all elements
        LinkedList<Integer> bucket = new LinkedList<>(list);

        // Sort the single bucket using counting sort
        countingSort(bucket);

        // Replace original list with sorted bucket
        list.clear();
        list.addAll(bucket);
    }
}

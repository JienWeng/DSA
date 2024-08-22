package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSortArrayList {

    // Method to perform bucket sort for integers
    public static void bucketSortIntegers(List<Integer> list) {
        if (list.isEmpty()) return;

        int max = Collections.max(list);
        int min = Collections.min(list);
        
        int range=(max-min)/list.size()+1;
        int bucketCount = (max - min)/range+ 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Integer number : list) {
        	int bucketIndex=(number-min)/range;
            buckets.get(bucketIndex).add(number);
        }

        list.clear();
        for (List<Integer> bucket : buckets) {
        	Collections.sort(bucket);
            list.addAll(bucket);
        }
    }

    private static final int ALPHABET_SIZE = 26; // Number of English letters

    // Method to perform bucket sort for strings
    public static void bucketSortStrings(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        List<String> sortedList = createBuckets(list, 0);
        list.clear();
        list.addAll(sortedList);
    }

    private static List<String> createBuckets(List<String> names, int indent) {
        List<List<String>> buckets = new ArrayList<>(ALPHABET_SIZE);
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute strings into buckets based on the current character position
        for (String name : names) {
            int charIndex = getCharIndex(name, indent);
            if (charIndex >= 0 && charIndex < ALPHABET_SIZE) {
                buckets.get(charIndex).add(name);
            }
        }

        List<String> output = new ArrayList<>();
        // Process each bucket
        for (List<String> bucket : buckets) {
            if (bucket.size() > 1 && indent < getMaxLength(names)) {
                List<String> sortedBucket = createBuckets(bucket, indent + 1);
                for (String str : sortedBucket) {
                    if (str.length() > indent) {
                        output.add(str);
                    }
                }
            } else {
                output.addAll(bucket);
            }
        }

        return output;
    }

    private static int getCharIndex(String str, int index) {
        if (str.length() > index) {
            char c = Character.toLowerCase(str.charAt(index));
            return c - 'a';
        }
        return -1; // Default bucket for empty or shorter strings
    }

    private static int getMaxLength(List<String> names) {
        int maxLength = 0;
        for (String name : names) {
            if (name.length() > maxLength) {
                maxLength = name.length();
            }
        }
        return maxLength;
    }

    // Method to perform bucket sort for strings in worst-case scenario
    public static void bucketSortStringsWorstCase(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        // Generate worst-case bucket sort for strings
        List<String> sortedList = createWorstCaseBuckets(list, 0);
        list.clear();
        list.addAll(sortedList);
    }

    private static List<String> createWorstCaseBuckets(List<String> names, int indent) {
        List<List<String>> buckets = new ArrayList<>(ALPHABET_SIZE);
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute strings into buckets based on the current character position
        for (String name : names) {
            int charIndex = getCharIndex(name, indent);
            if (charIndex >= 0 && charIndex < ALPHABET_SIZE) {
                buckets.get(charIndex).add(name);
            }
        }

        List<String> output = new ArrayList<>();
        // Process each bucket
        for (List<String> bucket : buckets) {
            if (bucket.size() > 1 && indent < getMaxLength(names)) {
                List<String> sortedBucket = createWorstCaseBuckets(bucket, indent + 1);
                for (String str : sortedBucket) {
                    if (str.length() > indent) {
                        output.add(str);
                    }
                }
            } else {
                output.addAll(bucket);
            }
        }

        return output;
    }
    public static void bucketSortIntegersWorstCase(List<Integer> list) {
        if (list.isEmpty()) return;

        // Create a single bucket for all elements
        List<Integer> bucket = new ArrayList<>(list);

        // Sort the single bucket
        Collections.sort(bucket);

        // Replace original list with sorted bucket
        list.clear();
        list.addAll(bucket);
    }
}

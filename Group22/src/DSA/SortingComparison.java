package DSA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SortingComparison {
    public static void main(String[] args) {
        String[] fileNames = {
            "data/integers/length/long_numbers.txt",
            "data/integers/length/medium_numbers.txt",
            "data/integers/length/short_numbers.txt",
            "data/integers/stateOfData/nearlySorted.txt",
            "data/integers/stateOfData/partiallySorted.txt",
            "data/integers/stateOfData/random.txt",
            "data/strings/length/words.txt",
            "data/strings/length/short.txt"
        };

        // Create an array to hold the additional file names for numbers of records
        String[] additionalFiles = new String[10];

        // Generate file names for numbersofrecords from 1,000,000 to 10,000,000
        for (int i = 1; i <= 10; i++) {
            additionalFiles[i - 1] = "data/integers/numberOfRecords/numbersofrecords_" + (i * 1000000) + ".txt";
        }

        // Combine the original and additional file names
        String[] allFileNames = new String[fileNames.length + additionalFiles.length];
        System.arraycopy(fileNames, 0, allFileNames, 0, fileNames.length);
        System.arraycopy(additionalFiles, 0, allFileNames, fileNames.length, additionalFiles.length);

        for (String fileName : allFileNames) {
            System.out.println("Processing file: " + fileName);
            // Determine if the file contains integers or strings
            if (fileName.contains("strings")) {
                List<String> stringList = readFileToStringList(fileName);
                System.out.println("\nString List Sorting Times:");
                compareStringSortingAlgorithms(stringList);
            } else {
                List<Integer> integerList = readFileToArrayList(fileName);
                System.out.println("\nInteger List Sorting Times:");
                compareSortingAlgorithms(integerList);
            }
        }
    }

    private static List<Integer> readFileToArrayList(String filePath) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception
        }
        return list;
    }

    private static List<String> readFileToStringList(String filePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception
        }
        return list;
    }

    private static void compareSortingAlgorithms(List<Integer> originalList) {
        // Clone the original list for each sorting algorithm
        List<Integer> listToSort;

        // Print the size of the list being sorted
        System.out.println("Sorting " + originalList.size() + " elements.");

        // Store sorting times
        long heapSortTime, quickSortTime, timSortTime, bucketSortTime;

        // Create instances of sorting algorithms
        SortAlgorithm<Integer> heapSort = new HeapSort();
        SortAlgorithm<Integer> quickSort = new QuickSort();
        SortAlgorithm<Integer> timSort = new TimSort();
        SortAlgorithm<Integer> bucketSort = new BucketSort();

        // Heap Sort
        listToSort = new ArrayList<>(originalList);
        long startTime = System.currentTimeMillis();
        heapSort.sort(listToSort);
        long endTime = System.currentTimeMillis();
        heapSortTime = endTime - startTime;

        // Quick Sort
        listToSort = new ArrayList<>(originalList);
        startTime = System.currentTimeMillis();
        quickSort.sort(listToSort);
        endTime = System.currentTimeMillis();
        quickSortTime = endTime - startTime;

        // Tim Sort
        listToSort = new ArrayList<>(originalList);
        startTime = System.currentTimeMillis();
        timSort.sort(listToSort);
        endTime = System.currentTimeMillis();
        timSortTime = endTime - startTime;

        // Bucket Sort
        listToSort = new ArrayList<>(originalList);
        startTime = System.currentTimeMillis();
        bucketSort.sort(listToSort);
        endTime = System.currentTimeMillis();
        bucketSortTime = endTime - startTime;

        // Print results in tabular format
        System.out.println("\n| Algorithm    | Time (ms) ");
        System.out.println("|--------------|-----------");
        System.out.printf("| Heap Sort    | %d        \n", heapSortTime);
        System.out.printf("| Quick Sort   | %d        \n", quickSortTime);
        System.out.printf("| Tim Sort     | %d        \n", timSortTime);
        System.out.printf("| Bucket Sort  | %d        \n", bucketSortTime);
    }

    private static void compareStringSortingAlgorithms(List<String> originalList) {
        // Clone the original list for each sorting algorithm
        List<String> listToSort;

        // Print the size of the list being sorted
        System.out.println("Sorting " + originalList.size() + " elements.");

        // Store sorting times
        long heapSortTime, quickSortTime, timSortTime, bucketSortTime;

        // Create instances of sorting algorithms
        SortAlgorithm<String> heapSort = new HeapSort();
        SortAlgorithm<String> quickSort = new QuickSort();
        SortAlgorithm<String> timSort = new TimSort();
        SortAlgorithm<String> bucketSort = new BucketSort();

        // Heap Sort
        listToSort = new ArrayList<>(originalList);
        long startTime = System.currentTimeMillis();
        heapSort.sort(listToSort);
        long endTime = System.currentTimeMillis();
        heapSortTime = endTime - startTime;

        // Quick Sort
        listToSort = new ArrayList<>(originalList);
        startTime = System.currentTimeMillis();
        quickSort.sort(listToSort);
        endTime = System.currentTimeMillis();
        quickSortTime = endTime - startTime;

        // Tim Sort
        listToSort = new ArrayList<>(originalList);
        startTime = System.currentTimeMillis();
        timSort.sort(listToSort);
        endTime = System.currentTimeMillis();
        timSortTime = endTime - startTime;

        // Bucket Sort
        listToSort = new ArrayList<>(originalList);
        startTime = System.currentTimeMillis();
        bucketSort.sort(listToSort);
        endTime = System.currentTimeMillis();
        bucketSortTime = endTime - startTime;

        // Print results in tabular format
        System.out.println("\n| Algorithm    | Time (ms) ");
        System.out.println("|--------------|-----------");
        System.out.printf("| Heap Sort    | %d        \n", heapSortTime);
        System.out.printf("| Quick Sort   | %d        \n", quickSortTime);
        System.out.printf("| Tim Sort     | %d        \n", timSortTime);
        System.out.printf("| Bucket Sort  | %d        \n", bucketSortTime);
    }
}
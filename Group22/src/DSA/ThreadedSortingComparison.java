package DSA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadedSortingComparison {

    // Different thread counts to test for parallel sorting
    private static final int[] THREAD_COUNTS = {1, 4, 12};

    public static void main(String[] args) {
        // File names to process
        String[] fileNames = {
            "data/integers/length/long_numbers.txt" // Path to the input file
        };

        // Loop through each file to perform sorting comparisons
        for (String fileName : fileNames) {
            System.out.println("Processing file: " + fileName);
            
            // Read integers from the file into an ArrayList and LinkedList
            List<Integer> integerArrayList = readFileToArrayList(fileName);
            List<Integer> integerLinkedList = readFileToLinkedList(fileName);
            
            // Compare sorting times for ArrayList
            System.out.println("\nInteger ArrayList Sorting Times:");
            compareSortingWithThreads(integerArrayList);
            
            // Compare sorting times for LinkedList
            System.out.println("\nInteger LinkedList Sorting Times:");
            compareSortingWithThreads(integerLinkedList);
        }
    }

    // Method to read integers from a file into an ArrayList
    public static List<Integer> readFileToArrayList(String filePath) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line and parse it as an integer
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer from file: " + filePath);
            e.printStackTrace();
        }
        return list; // Return the populated ArrayList
    }

    // Method to read integers from a file into a LinkedList
    public static List<Integer> readFileToLinkedList(String filePath) {
        List<Integer> list = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line and parse it as an integer
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer from file: " + filePath);
            e.printStackTrace();
        }
        return list; // Return the populated LinkedList
    }

    // Method to compare sorting times using different algorithms and thread counts
    public static void compareSortingWithThreads(List<Integer> originalList) {
        System.out.println("\n| Algorithm     | Threads | Time (ms) |");
        System.out.println("|---------------|---------|-----------|");

        // Loop through each thread count
        for (int threadCount : THREAD_COUNTS) {
            // Create a copy of the original list for sorting
            List<Integer> listToSort = new ArrayList<>(originalList);
            long startTime = System.nanoTime(); // Start timing
            parallelSort(listToSort, threadCount); // Perform parallel sort
            long endTime = System.nanoTime(); // End timing
            long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
            System.out.printf("| Heap Sort     | %d       | %d        |\n", threadCount, duration);
            
            // Repeat for Quick Sort
            listToSort = new ArrayList<>(originalList);
            startTime = System.nanoTime();
            parallelSort(listToSort, threadCount);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.printf("| Quick Sort    | %d       | %d        |\n", threadCount, duration);
            
            // Repeat for Tim Sort
            listToSort = new ArrayList<>(originalList);
            startTime = System.nanoTime();
            parallelSort(listToSort, threadCount);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.printf("| Tim Sort      | %d       | %d        |\n", threadCount, duration);
            
            // Repeat for Bucket Sort
            listToSort = new ArrayList<>(originalList);
            startTime = System.nanoTime();
            parallelSort(listToSort, threadCount); 
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.printf("| Bucket Sort   | %d       | %d        |\n", threadCount, duration);
        }
    }

    // Method to perform parallel sorting
    public static void parallelSort(List<Integer> array, int numThreads) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads); // Create a thread pool
        int segmentSize = array.size() / numThreads; // Calculate segment size for each thread

        // Submit sorting tasks for each segment
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * segmentSize; // Start index for the segment
            int endIndex = (i == numThreads - 1) ? array.size() - 1 : (startIndex + segmentSize - 1); // End index
            executor.submit(new SortTask(array, startIndex, endIndex)); // Submit the sorting task
        }

        executor.shutdown(); // Shutdown the executor
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Wait for all tasks to finish
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle interruption
        }
    }

    // Inner class for sorting task
    static class SortTask implements Runnable {
        private final List<Integer> array; // The array to sort
        private final int start; // Start index of the segment
        private final int end; // End index of the segment

        // Constructor
        public SortTask(List<Integer> array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            // Create a segment of the array to sort
            List<Integer> segment = new ArrayList<>(array.subList(start, end + 1));
            segment.sort(Integer::compareTo); // Sort the segment
            // Place the sorted segment back into the original array
            for (int i = 0; i < segment.size(); i++) {
                array.set(start + i, segment.get(i));
            }
        }
    }
}
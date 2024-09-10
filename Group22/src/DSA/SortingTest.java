package DSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SortingTest {
    public static void main(String[] args) {
        // Hardcoded small example datasets
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(3);
        integerList.add(8);
        integerList.add(1);
        integerList.add(7);
        integerList.add(6);
        integerList.add(4);
        integerList.add(2);

        LinkedList<Integer> integerLinkedList = new LinkedList<>(integerList);

        List<String> stringList = new ArrayList<>();
        stringList.add("cherry");
        stringList.add("date");
        stringList.add("fig");
        stringList.add("grape");
        stringList.add("apple");
        stringList.add("banana");

        // Display unsorted lists
        System.out.println("Original Integer List (ArrayList): " + integerList);
        System.out.println("Original Integer List (LinkedList): " + integerLinkedList);
        System.out.println("Original String List: " + stringList);

        // Create sorting algorithm instances
        SortAlgorithm<Integer> heapSort = new HeapSort<>();
        SortAlgorithm<Integer> quickSort = new QuickSort<>();
        SortAlgorithm<Integer> timSort = new TimSort<>();
        SortAlgorithm<Integer> bucketSort = new BucketSort<>();

        // Sort and print results for integer ArrayList
        System.out.println("\nSorting Integer ArrayList:");
        List<Integer> sortedIntegerArrayList = new ArrayList<>(integerList);

        long startTime, endTime, duration;

        // HeapSort
        startTime = System.nanoTime();
        heapSort.sort(sortedIntegerArrayList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Heap Sorted Integer ArrayList: " + sortedIntegerArrayList + " | Time taken: " + duration + " ns");

        // QuickSort
        sortedIntegerArrayList = new ArrayList<>(integerList);  
        startTime = System.nanoTime();
        quickSort.sort(sortedIntegerArrayList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Quick Sorted Integer ArrayList: " + sortedIntegerArrayList + " | Time taken: " + duration + " ns");

        // TimSort
        sortedIntegerArrayList = new ArrayList<>(integerList);  
        startTime = System.nanoTime();
        timSort.sort(sortedIntegerArrayList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Tim Sorted Integer ArrayList: " + sortedIntegerArrayList + " | Time taken: " + duration + " ns");

        // BucketSort
        sortedIntegerArrayList = new ArrayList<>(integerList);  
        startTime = System.nanoTime();
        bucketSort.sort(sortedIntegerArrayList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Bucket Sorted Integer ArrayList: " + sortedIntegerArrayList + " | Time taken: " + duration + " ns");

        // Sort and print results for integer LinkedList
        System.out.println("\nSorting Integer LinkedList:");
        List<Integer> sortedIntegerLinkedList = new LinkedList<>(integerLinkedList);

        // HeapSort
        startTime = System.nanoTime();
        heapSort.sort(sortedIntegerLinkedList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Heap Sorted Integer LinkedList: " + sortedIntegerLinkedList + " | Time taken: " + duration + " ns");

        // QuickSort
        sortedIntegerLinkedList = new LinkedList<>(integerLinkedList); 
        startTime = System.nanoTime();
        quickSort.sort(sortedIntegerLinkedList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Quick Sorted Integer LinkedList: " + sortedIntegerLinkedList + " | Time taken: " + duration + " ns");

        // TimSort
        sortedIntegerLinkedList = new LinkedList<>(integerLinkedList);  
        startTime = System.nanoTime();
        timSort.sort(sortedIntegerLinkedList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Tim Sorted Integer LinkedList: " + sortedIntegerLinkedList + " | Time taken: " + duration + " ns");

        // BucketSort
        sortedIntegerLinkedList = new LinkedList<>(integerLinkedList);  
        startTime = System.nanoTime();
        bucketSort.sort(sortedIntegerLinkedList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Bucket Sorted Integer LinkedList: " + sortedIntegerLinkedList + " | Time taken: " + duration + " ns");

        // Sort and print results for string lists
        System.out.println("\nSorting String List:");
        List<String> sortedStringList = new ArrayList<>(stringList);

        SortAlgorithm<String> stringHeapSort = new HeapSort<>();
        SortAlgorithm<String> stringQuickSort = new QuickSort<>();
        SortAlgorithm<String> stringTimSort = new TimSort<>();
        SortAlgorithm<String> stringBucketSort = new BucketSort<>();

        // HeapSort
        startTime = System.nanoTime();
        stringHeapSort.sort(sortedStringList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Heap Sorted String List: " + sortedStringList + " | Time taken: " + duration + " ns");

        // QuickSort
        sortedStringList = new ArrayList<>(stringList); 
        startTime = System.nanoTime();
        stringQuickSort.sort(sortedStringList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Quick Sorted String List: " + sortedStringList + " | Time taken: " + duration + " ns");

        // TimSort
        sortedStringList = new ArrayList<>(stringList);  
        startTime = System.nanoTime();
        stringTimSort.sort(sortedStringList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Tim Sorted String List: " + sortedStringList + " | Time taken: " + duration + " ns");

        // BucketSort
        sortedStringList = new ArrayList<>(stringList); 
        startTime = System.nanoTime();
        stringBucketSort.sort(sortedStringList);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Bucket Sorted String List: " + sortedStringList + " | Time taken: " + duration + " ns");
    }
}

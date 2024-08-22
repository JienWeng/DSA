package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {

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

        // Quick-Sort (ArrayList) for integers
        System.out.println("Integer List Before Quick-Sort: " + integerList);
        measureQuickSortArrayListTime(integerList, "ArrayList", "Average Case");
        System.out.println("Integer List After Quick-Sort: " + integerList);

        // Quick-Sort (ArrayList) for strings
        System.out.println("String List Before Quick-Sort: " + stringList);
        measureQuickSortArrayListTimeForStrings(stringList, "ArrayList", "Average Case");
        System.out.println("String List After Quick-Sort: " + stringList);
        
        // Quick-Sort (LinkedList) for strings
        System.out.println("Array List Before Quick-Sort: " + integerList);
        measureQuickSortLinkedListTime(integerLinkedList, "ArrayList", "Average Case");
        System.out.println("Integer List After Quick-Sort: " + integerLinkedList);

        // Bucket-Sort (ArrayList) for integers
        System.out.println("Integer List Before Bucket-Sort: " + integerList);
        measureBucketSortArrayListTime(integerList, "ArrayList", "Average Case");
        System.out.println("Integer List After Bucket-Sort: " + integerList);

        // Bucket-Sort (LinkedList) for integers
        System.out.println("Integer LinkedList Before Bucket-Sort: " + integerLinkedList);
        measureBucketSortLinkedListTime(integerLinkedList, "LinkedList", "Average Case");
        System.out.println("Integer LinkedList After Bucket-Sort: " + integerLinkedList);

        // Bucket-Sort (ArrayList) for strings
        System.out.println("String List Before Bucket-Sort: " + stringList);
        measureBucketSortArrayListTimeForStrings(stringList, "ArrayList", "Average Case");
        System.out.println("String List After Bucket-Sort: " + stringList);
        
        // Tim-Sort (ArrayList) for integers
        System.out.println("Integer List Before Tim-Sort: " + integerList);
        averageTimSortArrayInt(integerList,"ArrayList","Average Case");
        System.out.println("Integer List After Tim-Sort: " + integerList);

        // Tim-Sort (ArrayList) for strings
        System.out.println("String List Before Tim-Sort: " + stringList);
        averageTimSortArrayWords(stringList, "ArrayList", "Average Case");
        System.out.println("String List After Tim-Sort: " + stringList);
        
        // Tim-Sort (LinkedList) for strings
        System.out.println("Array List Before Tim-Sort: " + integerList);
        averageTimSortLinkedInt(integerLinkedList, "ArrayList", "Average Case");
        System.out.println("Integer List After Tim-Sort: " + integerLinkedList);

        // Heap-Sort (ArrayList) for integers
        System.out.println("Integer List Before Heap-Sort: " + integerList);
        averageHeapSortArrayInt(integerList, "ArrayList", "Average Case");
        System.out.println("Integer List After Heap-Sort: " + integerList);

        // Heap-Sort (LinkedList) for integers
        System.out.println("Integer LinkedList Before Heap-Sort: " + integerLinkedList);
        averageHeapSortLinkedInt(integerLinkedList, "LinkedList", "Average Case");
        System.out.println("Integer LinkedList After Heap-Sort: " + integerLinkedList);

        // Heap-Sort (ArrayList) for strings
        System.out.println("String List Before Heap-Sort: " + stringList);
        averageHeapSortArrayWords(stringList, "ArrayList", "Average Case");
        System.out.println("String List After Heap-Sort: " + stringList);
    }

    // Methods to measure sorting times
    private static void measureQuickSortArrayListTime(List<Integer> list, String type, String caseType) {
        long startTime = System.nanoTime();
        QuickSortArrayList.quickSort(list, 0, list.size() - 1);
        long endTime = System.nanoTime();
        System.out.println("Quick-Sort (" + type + ") " + caseType + " Time: " + (endTime - startTime) + " ns");
    }

    private static void measureQuickSortArrayListTimeForStrings(List<String> list, String type, String caseType) {
        long startTime = System.nanoTime();
        QuickSortArrayList.quickSort(list, 0, list.size() - 1);
        long endTime = System.nanoTime();
        System.out.println("Quick-Sort (" + type + ") " + caseType + " Time: " + (endTime - startTime) + " ns");
    }
    
    private static void measureQuickSortLinkedListTime(LinkedList<Integer> list, String type, String caseType) {
        long startTime = System.nanoTime();
        QuickSortLinkedList.quickSort(list);
        long endTime = System.nanoTime();
        System.out.println("Quick-Sort (" + type + ") " + caseType + " Time: " + (endTime - startTime) + " ns");
    }

    private static void measureBucketSortArrayListTime(List<Integer> list, String type, String caseType) {
        long startTime = System.nanoTime();
        BucketSortArrayList.bucketSortIntegers(list);
        long endTime = System.nanoTime();
        System.out.println("Bucket-Sort (" + type + ") " + caseType + " Time: " + (endTime - startTime) + " ns");
    }

    private static void measureBucketSortArrayListTimeForStrings(List<String> list, String type, String caseType) {
        long startTime = System.nanoTime();
        BucketSortArrayList.bucketSortStrings(list);
        long endTime = System.nanoTime();
        System.out.println("Bucket-Sort (" + type + ") " + caseType + " Time: " + (endTime - startTime) + " ns");
    }

    private static void measureBucketSortLinkedListTime(LinkedList<Integer> list, String type, String caseType) {
        long startTime = System.nanoTime();
        BucketSortLinkedList.bucketSort(list);
        long endTime = System.nanoTime();
        System.out.println("Bucket-Sort (" + type + ") " + caseType + " Time: " + (endTime - startTime) + " ns");
    }
	private static void averageHeapSortLinkedInt(LinkedList<Integer> list,String type,String caseType) {
		long startTime = System.nanoTime();
		HeapLinked.sort(list);
		long endTime = System.nanoTime();

		System.out.print("Heap-Sort ("+type+")" + type + "Time:"  + (endTime - startTime) + " ns\n");
	}
	private static void averageHeapSortArrayInt(List<Integer> list,String type,String caseType) {
		long startTime = System.nanoTime();
		HeapArray.sortIntegers(list);
		long endTime = System.nanoTime();

		System.out.print("Heap-Sort ("+type+")" + caseType + "Time:"  + (endTime - startTime) + " ns\n");
	}
	private static void averageHeapSortArrayWords(List<String> list,String type,String caseType) {
		long startTime = System.nanoTime();
		HeapArray.sortStrings(list);
		long endTime = System.nanoTime();

		System.out.print("Heap-Sort ("+type+")" + caseType + "Time:"  + (endTime - startTime) + " ns\n");
	}
	private static void averageTimSortLinkedInt(LinkedList<Integer> list,String type,String caseType) {
		long startTime = System.nanoTime();
		TimSortLinked.timSort(list, list.size());
		long endTime = System.nanoTime();

		System.out.print("Tim-Sort ("+type+") "+ caseType +" Time:"  + (endTime - startTime) + " ns\n");
	}
	private static void averageTimSortArrayWords(List<String> list,String type,String caseType) {
		long startTime = System.nanoTime();
		TimSortArray.timSort(list,list.size());
		long endTime = System.nanoTime();

		System.out.print("Tim-Sort ("+type+")" + caseType + "Time:"  + (endTime - startTime) + " ns\n");
	}
	
	private static void averageTimSortArrayInt(List<Integer> list,String type,String caseType) {
		long startTime = System.nanoTime();
		TimSortArray.timSort(list,list.size());
		long endTime = System.nanoTime();

		System.out.print("Tim-Sort ("+type+")" + caseType + "Time:"  + (endTime - startTime) + " ns\n");
	}
}

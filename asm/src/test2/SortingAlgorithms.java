package test2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingAlgorithms {

	public static void main(String[] args) {

		String integersFolderName = "integers";
		String stringsFolderName = "strings";

		// Process integer files
		processFilesInDirectory(new File(integersFolderName), "Integer");

		// Process string files
		processFilesInDirectory(new File(stringsFolderName), "String");
	}

	private static void processFilesInDirectory(File directory, String type) {
		File[] files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					processFilesInDirectory(file, type);
				} else {
					processFile(file, type);
				}
			}
		}
	}

	private static void processFile(File file, String type) {
		System.out.println("Processing " + file.getName());
		List<String> lines = readFile(file.getAbsolutePath());

		if (type.equals("Integer")) {
			List<Integer> originalIntegerList = parseIntegerList(lines);

			// Copy the original list to avoid side effects
			List<Integer> integerList = new ArrayList<>(originalIntegerList);
			LinkedList<Integer> integerLinkedList = new LinkedList<>(originalIntegerList);

			// Quick-Sort (ArrayList)
            measureAvgQuickSortArrayListTime(new ArrayList<>(originalIntegerList), "ArrayList", "Average Case");
            measureWorstQuickSortArrayListTime(new ArrayList<>(originalIntegerList), "ArrayList", "Worst Case");

            // Quick-Sort (LinkedList)
            measureAvgQuickSortLinkedListTime(new LinkedList<>(originalIntegerList), "LinkedList", "Average Case");
            measureWorstQuickSortLinkedListTime(new LinkedList<>(originalIntegerList), "LinkedList", "Worst Case");

            // Bucket-Sort (ArrayList)
            measureBucketSortArrayListTimeAverage(new ArrayList<>(originalIntegerList), "ArrayList", "Average Case");
            measureBucketSortArrayListTimeWorst(new ArrayList<>(originalIntegerList), "ArrayList", "Worst Case");

            // Bucket-Sort (LinkedList)
            measureBucketSortLinkedListTimeAverage(new LinkedList<>(originalIntegerList), "LinkedList", "Average Case");
            measureBucketSortLinkedListTimeWorst(new LinkedList<>(originalIntegerList), "LinkedList", "Worst Case");

			// Tim-Sort (ArrayList)
			measureAvgTimSortArrayInt(new ArrayList<>(originalIntegerList), "ArrayList", "Average Case");
			measureWorstTimSortArrayInt(new ArrayList<>(originalIntegerList), "ArrayList", "Worst Case");

			// Tim-Sort (LinkedList)
			measureAvgTimSortLinkedInt(new LinkedList<>(originalIntegerList), "LinkedList", "Average Case");
			measureWorstTimSortLinkedInt(new LinkedList<>(originalIntegerList), "LinkedList", "Worst Case");

			// Heap-Sort (ArrayList)
			measureAvgHeapSortArrayInt(new ArrayList<>(originalIntegerList), "ArrayList", "Average Case");
			measureWorstHeapSortArrayInt(new ArrayList<>(originalIntegerList), "ArrayList", "Worst Case");

			// Heap-Sort (LinkedList)
			measureAvgHeapSortLinkedInt(new LinkedList<>(originalIntegerList), "LinkedList", "Average Case");
			measureWorstHeapSortLinkedInt(new LinkedList<>(originalIntegerList), "LinkedList", "Worst Case");


		} else if (type.equals("String")) {
			List<String> originalStringList = new ArrayList<>(lines);

			// Quick-Sort (ArrayList)
            measureAvgQuickSortArrayListTimeForStrings(new ArrayList<>(originalStringList), "ArrayList", "Average Case");
            measureWorstQuickSortArrayListTimeForStrings(new ArrayList<>(originalStringList), "ArrayList", "Worst Case");

            // Bucket-Sort (ArrayList)
            measureBucketSortArrayListTimeForStringsAverage(new ArrayList<>(originalStringList), "ArrayList", "Average Case");
            measureBucketSortArrayListTimeForStringsWorst(new ArrayList<>(originalStringList), "ArrayList", "Worst Case");
            

			// Tim-Sort (ArrayList)
			measureAvgTimSortArrayWords(new ArrayList<>(originalStringList), "ArrayList", "Average Case");
			measureWorstTimSortArrayWords(new ArrayList<>(originalStringList), "ArrayList", "Worst Case");

			// Heap-Sort (ArrayList)
			measureAvgHeapSortArrayWords(new ArrayList<>(originalStringList), "ArrayList", "Average Case");
			measureWorstHeapSortArrayWords(new ArrayList<>(originalStringList), "ArrayList", "Worst Case");
		}
	}

	private static List<String> readFile(String filePath) {
		try {
			return Files.readAllLines(new File(filePath).toPath());
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	private static List<Integer> parseIntegerList(List<String> lines) {
		List<Integer> integers = new ArrayList<>();
		for (String line : lines) {
			try {
				integers.add(Integer.parseInt(line.trim()));
			} catch (NumberFormatException e) {
				// Handle parsing error if needed
			}
		}
		return integers;
	}

	private static void measureAvgQuickSortArrayListTime(List<Integer> list, String type, String caseType) {
		measureSortingPerformance(list, l -> QuickSortArrayList.quickSort(l, 0, l.size() - 1), 
				"Quick-Sort ", type, caseType);
	}
	
	private static void measureWorstQuickSortArrayListTime(List<Integer> list, String type, String caseType) {
        Collections.sort(list, Collections.reverseOrder());
		measureSortingPerformance(list, l -> QuickSortArrayList.quickSort(l, 0, l.size() - 1), 
				"Quick-Sort ", type, caseType);
	}

	private static void measureAvgQuickSortLinkedListTime(LinkedList<Integer> list, String type, String caseType) {
		measureSortingPerformance(new ArrayList<>(list), 
				l -> QuickSortLinkedList.quickSort(new LinkedList<>(l), 0, l.size() - 1),
				"Quick-Sort ", type, caseType);
	}
	
	private static void measureWorstQuickSortLinkedListTime(LinkedList<Integer> list, String type, String caseType) {
        Collections.sort(list, Collections.reverseOrder());
		measureSortingPerformance(new ArrayList<>(list), 
				l -> QuickSortLinkedList.quickSort(new LinkedList<>(l), 0, l.size() - 1),
				"Quick-Sort ", type, caseType);
	}

	private static void measureAvgQuickSortArrayListTimeForStrings(List<String> list, String type, String caseType) {
        Collections.sort(list, Collections.reverseOrder());
		measureSortingPerformance(list, l -> QuickSortArrayList.quickSort(l, 0, l.size() - 1),
				"Quick-Sort ", type, caseType);
	}
	
	private static void measureWorstQuickSortArrayListTimeForStrings(List<String> list, String type, String caseType) {
        Collections.sort(list, Collections.reverseOrder());
		measureSortingPerformance(list, l -> QuickSortArrayList.quickSort(l, 0, l.size() - 1),
				"Quick-Sort ", type, caseType);
	}

	private static void measureBucketSortArrayListTimeAverage(List<Integer> list, String type, String caseType) {
		measureSortingPerformance(list, BucketSortArrayList::bucketSortIntegers, 
				"Bucket-Sort ", type, caseType);
	}

	private static void measureBucketSortArrayListTimeWorst(List<Integer> list, String type, String caseType) {
		measureSortingPerformance(list, BucketSortArrayList::bucketSortIntegersWorstCase, 
				"Bucket-Sort ", type, caseType);
	}

	private static void measureBucketSortArrayListTimeForStringsAverage(List<String> list, String type, String caseType) {
		measureSortingPerformance(list, BucketSortArrayList::bucketSortStrings,
				"Bucket-Sort ", type, caseType);
	}

	private static void measureBucketSortArrayListTimeForStringsWorst(List<String> list, String type, String caseType) {
		measureSortingPerformance(list, BucketSortArrayList::bucketSortStringsWorstCase,
				"Bucket-Sort ", type, caseType);
	}

	private static void measureBucketSortLinkedListTimeAverage(LinkedList<Integer> list, String type, String caseType) {
		measureSortingPerformance(new ArrayList<>(list), 
				l -> BucketSortLinkedList.bucketSort(new LinkedList<>(l)),
				"Bucket-Sort", type, caseType);
	}
	private static void measureBucketSortLinkedListTimeWorst(LinkedList<Integer> list, String type, String caseType) {
		measureSortingPerformance(new ArrayList<>(list), 
				l -> BucketSortLinkedList.bucketSortWorstCase(new LinkedList<>(l)),
				"Bucket-Sort", type, caseType);
	}
	private static void measureWorstTimSortArrayWords(List<String> list, String type, String caseType) {
		Collections.sort(list, Collections.reverseOrder());
		measureSortingPerformance(list, l -> TimSortArray.timSort(l, l.size()),
				"Tim-Sort ", type, caseType);
	}

	private static void measureAvgTimSortArrayWords(List<String> list, String type, String caseType) {
		measureSortingPerformance(list, l -> TimSortArray.timSort(l, l.size()),
				"Tim-Sort ", type, caseType);
	} 
	
	private static void measureWorstTimSortArrayInt(List<Integer> list, String type, String caseType) {
		Collections.sort(list, Collections.reverseOrder());
		measureSortingPerformance(list, l -> TimSortArray.timSort(l, l.size()),
				"Tim-Sort ", type, caseType);
	}

	private static void measureAvgTimSortArrayInt(List<Integer> list, String type, String caseType) {
		measureSortingPerformance(list, l -> TimSortArray.timSort(l, l.size()),
				"Tim-Sort ", type, caseType);
	}

	private static void measureWorstTimSortLinkedInt(LinkedList<Integer> list, String type, String caseType) {
		Collections.sort(list, Collections.reverseOrder());
		measureSortingPerformance(new ArrayList<>(list), 
				l -> TimSortLinked.timSort(new LinkedList<>(l), l.size()),
				"Tim-Sort", type, caseType);
	}
	
	private static void measureAvgTimSortLinkedInt(LinkedList<Integer> list, String type, String caseType) {
		measureSortingPerformance(new ArrayList<>(list), 
				l -> TimSortLinked.timSort(new LinkedList<>(l), l.size()),
				"Tim-Sort", type, caseType);
	}

	private static void measureWorstHeapSortArrayWords(List<String> list, String type, String caseType) {
		Collections.sort(list, Collections.reverseOrder());
		measureSortingPerformance(list, HeapArray::sortStrings,
				"Heap-Sort ", type, caseType);
	}

	private static void measureAvgHeapSortArrayWords(List<String> list, String type, String caseType) {
		measureSortingPerformance(list, HeapArray::sortStrings,
				"Heap-Sort ", type, caseType);
	}
	
	private static void measureAvgHeapSortArrayInt(List<Integer> list, String type, String caseType) {
		measureSortingPerformance(list, HeapArray::sortIntegers,
				"Heap-Sort ", type, caseType);
	}

	private static void measureWorstHeapSortArrayInt(List<Integer> list, String type, String caseType) {
		Collections.sort(list, Collections.reverseOrder());
		measureSortingPerformance(list, HeapArray::sortIntegers,
				"Heap-Sort ", type, caseType);
	}
	
	private static void measureWorstHeapSortLinkedInt(LinkedList<Integer> list, String type, String caseType) {
		Collections.sort(list, Collections.reverseOrder());
		measureSortingPerformance(new ArrayList<>(list), 
				l -> HeapLinked.sort(new LinkedList<>(l)),
				"Heap-Sort", type, caseType);
	}

	private static void measureAvgHeapSortLinkedInt(LinkedList<Integer> list, String type, String caseType) {
		measureSortingPerformance(new ArrayList<>(list), 
				l -> HeapLinked.sort(new LinkedList<>(l)),
				"Heap-Sort", type, caseType);
	}

	private static <T> void measureSortingPerformance(List<T> list, SortingAlgorithm<T> algorithm, String algorithmName, String type, String caseType) {

		// Measure runtime
		long startTime = System.nanoTime();
		algorithm.sort(list);
		long endTime = System.nanoTime();

		// Calculate time and memory used
		long timeTaken = endTime - startTime;

		// Print results
		System.out.println(algorithmName + " (" + type + ") " + caseType + " Time: " + timeTaken + " ns");
	}
}

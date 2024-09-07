package test2;

import java.util.Arrays;
import java.util.Random;

// HeapSort Implementation
class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    
    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}

// QuickSort Implementation
class QuickSort {
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

// TimSort Implementation
class TimSort {
    private static final int RUN = 32;

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min(i + RUN - 1, n - 1));
        }
        mergeSort(arr);
    }

    private void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private void mergeSort(int[] arr) {
        int n = arr.length;
        for (int size = RUN; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = Math.min(left + size - 1, n - 1);
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge(arr, left, mid, right);
            }
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}

// BucketSort Implementation
class BucketSort {
    public void sort(int[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        int max = Arrays.stream(arr).max().orElseThrow();
        int min = Arrays.stream(arr).min().orElseThrow();
        int bucketRange = (max - min) / n + 1;
        int bucketCount = (max - min) / bucketRange + 1;

        int[][] buckets = new int[bucketCount][];
        int[] bucketSizes = new int[bucketCount];

        for (int i = 0; i < n; i++) {
            int bucketIndex = (arr[i] - min) / bucketRange;
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new int[n];
            }
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = arr[i];
        }

        int k = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (buckets[i] != null) {
                Arrays.sort(buckets[i], 0, bucketSizes[i]);
                for (int j = 0; j < bucketSizes[i]; j++) {
                    arr[k++] = buckets[i][j];
                }
            }
        }
    }
}

// Testing All Sorts
public class SortingTest {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000}; // Different sizes for testing

        for (int size : sizes) {
            System.out.println("Array Size: " + size);

            // Generate arrays for testing
            int[] sortedArray = generateSortedArray(size);
            int[] reversedArray = generateReversedArray(size);
            int[] randomArray = generateRandomArray(size);

            // HeapSort
            testSort(new HeapSort(), sortedArray.clone(), "HeapSort", "Best Case");
            testSort(new HeapSort(), randomArray.clone(), "HeapSort", "Average Case");
            testSort(new HeapSort(), reversedArray.clone(), "HeapSort", "Worst Case");

            // QuickSort
            testSort(new QuickSort(), sortedArray.clone(), "QuickSort", "Best Case");
            testSort(new QuickSort(), randomArray.clone(), "QuickSort", "Average Case");
            testSort(new QuickSort(), reversedArray.clone(), "QuickSort", "Worst Case");

            // TimSort
            testSort(new TimSort(), sortedArray.clone(), "TimSort", "Best Case");
            testSort(new TimSort(), randomArray.clone(), "TimSort", "Average Case");
            testSort(new TimSort(), reversedArray.clone(), "TimSort", "Worst Case");

            // BucketSort
            testSort(new BucketSort(), sortedArray.clone(), "BucketSort", "Best Case");
            testSort(new BucketSort(), randomArray.clone(), "BucketSort", "Average Case");
            testSort(new BucketSort(), reversedArray.clone(), "BucketSort", "Worst Case");
        }
    }

    public static void testSort(Object sorter, int[] arr, String algorithm, String caseType) {
        long startTime = System.nanoTime();
        if (sorter instanceof HeapSort) {
            ((HeapSort) sorter).sort(arr);
        } else if (sorter instanceof QuickSort) {
            ((QuickSort) sorter).sort(arr, 0, arr.length - 1);
        } else if (sorter instanceof TimSort) {
            ((TimSort) sorter).sort(arr);
        } else if (sorter instanceof BucketSort) {
            ((BucketSort) sorter).sort(arr);
        }
        long endTime = System.nanoTime();
        System.out.println(algorithm + " " + caseType + " Time: " + (endTime - startTime) + " ns");
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] generateReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i - 1;
        }
        return array;
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000);
        }
        return array;
    }
}


package test2;

import java.util.*;

public class TimSortArray {
	static int MIN_MERGE = 32;

    public static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // This function sorts a list from left index to right index which is of size at most RUN
    public static <T extends Comparable<T>> void insertionSort(List<T> list, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T temp = list.get(i);
            int j = i - 1;
            while (j >= left && list.get(j).compareTo(temp) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, temp);
        }
    }

    // Merge function merges the sorted runs
    public static <T extends Comparable<T>> void merge(List<T> list, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        List<T> left = new ArrayList<>(len1);
        List<T> right = new ArrayList<>(len2);

        for (int x = 0; x < len1; x++) {
            left.add(list.get(l + x));
        }
        for (int x = 0; x < len2; x++) {
            right.add(list.get(m + 1 + x));
        }

        int i = 0, j = 0, k = l;

        while (i < len1 && j < len2) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < len1) {
            list.set(k++, left.get(i++));
        }

        while (j < len2) {
            list.set(k++, right.get(j++));
        }
    }

    // Iterative Timsort function to sort the list[0...n-1] (similar to merge sort)
    public static <T extends Comparable<T>> void timSort(List<T> list, int n) {
        int minRun = minRunLength(MIN_MERGE);

        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i += minRun) {
            insertionSort(list, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        // Start merging from size RUN. Merge to form sizes 64, 128, 256, and so on...
        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right)
                    merge(list, left, mid, right);
            }
        }
    }
}

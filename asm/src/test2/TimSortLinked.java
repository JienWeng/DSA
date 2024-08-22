package test2;
import java.util.*;

public class TimSortLinked {

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

    public static void insertionSort(LinkedList<Integer> arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr.get(i);
            int j = i - 1;
            while (j >= left && arr.get(j) > temp) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, temp);
        }
    }

    public static void merge(LinkedList<Integer> arr, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        for (int x = 0; x < len1; x++) {
            left.add(arr.get(l + x));
        }
        for (int x = 0; x < len2; x++) {
            right.add(arr.get(m + 1 + x));
        }

        int i = 0, j = 0, k = l;

        while (i < len1 && j < len2) {
            if (left.get(i) <= right.get(j)) {
                arr.set(k, left.get(i));
                i++;
            } else {
                arr.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr.set(k, left.get(i));
            k++;
            i++;
        }

        while (j < len2) {
            arr.set(k, right.get(j));
            k++;
            j++;
        }
    }

    public static void timSort(LinkedList<Integer> arr, int n) {
        int minRun = minRunLength(MIN_MERGE);

        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    
}
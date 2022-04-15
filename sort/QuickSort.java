package sort;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);

    }

    public static void quickSort(int arr[], int left, int rigth) {
        int l = left;
        int r = rigth;
        int pivot = arr[(l + r) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort(arr, left, r);

        }
        if (l < rigth) {
            quickSort(arr, l, rigth);
        }

    }
}

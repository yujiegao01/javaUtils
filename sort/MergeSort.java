package sort;

public class MergeSort {

    public static void mergaSort(int[] arr, int left, int right, int temp[]) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergaSort(arr, left, mid, temp);
            mergaSort(arr, mid + 1, right, temp);
            merge(arr, left, right, mid, temp);
        }
    }

    public static void merge(int arr[], int left, int right, int mid, int temp[]) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[j] >= arr[i]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[j] = arr[j];
            j++;
            t++;
        }

        t = 0;
        int tempLeft = left;
        while (left <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }

    }
}

package search;

public class BinarySearch {

    public static int search(int arr[], int searchVal) {

        return binarySearch(arr, 0, arr.length - 1, searchVal);
    }

    public static int binarySearch(int arr[], int left, int right, int searchVal) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (searchVal > arr[mid]) {
            return binarySearch(arr, mid + 1, right, searchVal);
        } else if (searchVal < arr[mid]) {
            return binarySearch(arr, left, mid - 1, searchVal);
        } else {
            return mid;
        }
    }

}
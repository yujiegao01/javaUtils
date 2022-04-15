package sort;

public class RadixSort {
    public static void sort(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];

            }

        }
        int maxLength = max + "".length();

        int bucketElement[] = new int[10];
        int bucket[][] = new int[10][arr.length];
        for (int i = 1, n = 1; i <= maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElement[digitOfElement]] = arr[j];
                bucketElement[digitOfElement]++;

            }
            int index = 0;
            for (int k = 0; k < 10; k++) {
                if (bucketElement[0] != 0) {
                    for (int l = 0; l < bucketElement[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }

                }

                bucketElement[k] = 0;
            }

        }

    }

}

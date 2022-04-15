package sort;

public class ShellSort {
    public static void sort(int arr[]) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertIndex = i;
                int insertVal = arr[i];

                while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertVal;

            }

        }
    }

}

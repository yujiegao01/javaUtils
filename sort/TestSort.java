package sort;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

public class TestSort {

    @Test
    public void test1() {
        int arr[] = { 1, 99, 0, 97, 98, 99 };

        Date fromDate2 = new Date();
        long from2 = fromDate2.getTime();

        // BubbleSort.sort(arr);
        // SelectSort.sort(arr);
        // InsertSort.sort(arr);
        QuickSort.sort(arr);
        Date toDate2 = new Date();
        long to2 = toDate2.getTime();
        int second = (int) ((to2 - from2) / (1000));
        if (second <= 0) {
            System.out.println("排序使用的 毫秒 速：" + (to2 - from2));
        } else {
            System.out.println("排序使用的 秒 速：" + second);

        }

        assertTrue(isSort(arr, 0, arr.length));
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test2() {
        int arr[] = new int[80000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        Date fromDate2 = new Date();
        long from2 = fromDate2.getTime();

        // BubbleSort.sort(arr);
        // SelectSort.sort(arr);
        // InsertSort.sort(arr);
        // ShellSort.sort(arr);
        // QuickTest.sort(arr);
        QuickSort.sort(arr);
        Date toDate2 = new Date();
        long to2 = toDate2.getTime();
        int second = (int) ((to2 - from2) / (1000));
        if (second <= 0) {
            System.out.println("排序使用的 毫秒 速：" + (to2 - from2));
        } else {
            System.out.println("排序使用的 秒 速：" + second);
        }

        assertTrue(isSort(arr, 20, 170));
    }

    public static boolean isSort(int[] array, int start, int end) {
        for (int i = start; i < end - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

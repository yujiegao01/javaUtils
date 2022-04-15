package search;

import java.util.Arrays;

import org.junit.Test;

public class TestSearch {
    @Test
    public void test1() {
        int arr[] = { 1, 2, 30, 40, 40 };
        int resultArr[] = new int[arr.length];

        System.out.println(BinarySearch.search(arr, 40));

    }

}

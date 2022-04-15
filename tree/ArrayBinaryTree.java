
package tree;

public class ArrayBinaryTree {

    public static void preOrder(int arr[], int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组是空的！");
            return;
        }

        System.out.print(arr[index] + " ");
        if (2 * index + 1 < arr.length) {
            preOrder(arr, 2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preOrder(arr, index * 2 + 2);
        }

    }

    public static void infixOrder(int arr[], int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组是空的！");
            return;
        }

        if (2 * index + 1 < arr.length) {
            infixOrder(arr, 2 * index + 1);
        }
        System.out.print(arr[index] + " ");
        if (2 * index + 2 < arr.length) {
            infixOrder(arr, index * 2 + 2);
        }

    }

    public static void postOrder(int arr[], int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("数组是空的！");
            return;
        }

        if (2 * index + 1 < arr.length) {
            postOrder(arr, 2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            postOrder(arr, index * 2 + 2);
        }
        System.out.print(arr[index] + " ");

    }

}
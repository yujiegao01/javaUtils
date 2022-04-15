package tree;

import java.util.ArrayList;

import org.junit.Test;

public class TestTree {

    @Test
    public void binarySortTest() {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.add(new BinarySortTree.Node(5));
        binarySortTree.add(new BinarySortTree.Node(4));
        binarySortTree.add(new BinarySortTree.Node(3));
        binarySortTree.add(new BinarySortTree.Node(3));
        binarySortTree.add(new BinarySortTree.Node(2));
        binarySortTree.add(new BinarySortTree.Node(1));
        binarySortTree.infixOrder();
        System.out.println();
        binarySortTree.delNode(3);
        binarySortTree.infixOrder();

    }

    @Test
    public void test3() {
        ArrayList arrayList = new ArrayList<>();
        arrayList.get(8);
    }

    @Test
    public void test2() {

        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = HuffmanTree.createHuffmanTree(arr);
        HuffmanTree.postOrder(root);

    }

    @Test
    public void test1() {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.print("前序遍历： ");
        ArrayBinaryTree.preOrder(arr, 0);
        System.out.println();
        System.out.print("中序遍历： ");
        ArrayBinaryTree.infixOrder(arr, 0);
        System.out.println();
        System.out.print("后序遍历： ");
        ArrayBinaryTree.postOrder(arr, 0);
    }

}

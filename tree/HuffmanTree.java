package tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class HuffmanTree {
    public static Node createHuffmanTree(int arr[]) {
        ArrayList<Node> nodeList = new ArrayList<Node>();
        for (int i : arr) {
            nodeList.add(new Node(i));
        }

        while (nodeList.size() > 1) {
            Collections.sort(nodeList);
            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            nodeList.add(parent);
        }
        return nodeList.get(0);
    }

    public static void postOrder(Node root) {
        if (root != null) {
            root.postOrder();
        }
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;

    }

    public void preOrder() {

    }

    public void infixOrder() {

    }

    public void postOrder() {
        if (left != null) {
            left.postOrder();
        }
        if (right != null) {
            right.postOrder();
        }
        System.out.print(value + "  ");
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    @Override
    public int compareTo(Node o) {

        return this.value - o.value;
    }

}

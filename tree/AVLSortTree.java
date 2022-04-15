package tree;

public class AVLSortTree {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int val) {
            this.value = val;
        }

        public void leftRotate() {
            Node newNode = new Node(value);
            newNode.left = left;
            newNode.right = right.left;
            value = right.value;
            right = right.right;
            left = newNode;

        }

        public void rightRotate() {
            Node newNode = new Node(value);
            newNode.right = right;
            newNode.left = left.right;
            value = left.value;
            left = left.left;
            right = newNode;
        }

        public void add(Node node) {
            if (node.value < value) {
                if (left == null) {
                    left = node;
                } else {
                    left.add(node);
                }

            } else {
                if (right == null) {
                    right = node;
                } else {
                    right.add(node);
                }
            }
            if (rightHeight() - leftHeight() > 1) {
                if (right != null && right.leftHeight() > right.rightHeight()) {
                    right.rightRotate();
                }
                leftRotate();

                return;
            }

            if (leftHeight() - rightHeight() > 1) {
                if (left != null && left.rightHeight() > left.leftHeight()) {
                    left.leftRotate();
                }
                rightRotate();

            }

        }

        public int rightHeight() {
            if (right == null) {
                return 0;

            }
            return right.height();
        }

        public int leftHeight() {
            if (left == null) {
                return 0;
            }
            return left.height();
        }

        public int height() {
            return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
        }
    }

}

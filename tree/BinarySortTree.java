package tree;

public class BinarySortTree {

    Node root;

    public void delNode(int value) {
        Node node = root.search(value);
        Node parentNode = root.searchParent(value);
        if (node == null) {
            return;
        }
        if (parentNode == null && node.left == null && node.right == null) {
            root = null;
            return;
        } else if (parentNode == null && node.left != null && node.right != null) {
            int min = delRightTreeMin(node.right);
            node.value = min;
            return;
        } else if (parentNode == null) {
            if (node.left != null) {
                root = node.left;
            } else {
                root = node.right;
            }
            return;
        }
        if (node.left == null && node.right == null) {
            if (parentNode.left != null && parentNode.left.value == value) {
                parentNode.left = null;
            } else if (parentNode.right != null && parentNode.right.value == value) {
                parentNode.right = null;
            }
        } else if (node.left != null && node.right != null) {
            int min = delRightTreeMin(node.right);
            node.value = min;
        } else {
            if (parentNode.left != null && parentNode.left.value == value) {
                if (node.left != null) {
                    parentNode.left = node.left;
                } else {
                    parentNode.left = node.right;
                }
            } else {
                if (node.left != null) {
                    parentNode.right = node.left;
                } else {
                    parentNode.right = node.right;
                }

            }

        }

    }

    public int delRightTreeMin(Node node) {
        Node tempNode = node;
        while (tempNode.left != null) {
            tempNode = tempNode.left;
        }
        delNode(tempNode.value);
        return tempNode.value;

    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node searchParent(int val) {
            if ((left != null && left.value == val) || (right != null && right.value == val)) {
                return this;
            } else {
                if (val < this.value && left != null) {
                    return left.searchParent(val);
                } else if (val >= this.value && right != null) {
                    return right.searchParent(val);
                } else {
                    return null;
                }
            }

        }

        public Node search(int val) {
            if (this.value == val) {
                return this;

            }
            if (this.value > val && left != null) {
                return this.left.search(val);
            } else if (this.value <= val && right != null) {
                return this.right.search(val);
            }
            return null;

        }

        public void del() {

        }

        public void add(Node node) {
            if (node == null) {
                return;
            }
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
        }

        public void infixOrder() {
            if (left != null) {
                left.infixOrder();
            }
            System.out.print(value + " ");
            if (right != null) {
                right.infixOrder();
            }
        }

    }

}

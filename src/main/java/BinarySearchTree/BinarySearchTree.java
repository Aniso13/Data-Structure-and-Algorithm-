package BinarySearchTree;



public class BinarySearchTree {
     Node root;
    class Node {
        int value;
        Node left;
        Node right;
        private Node(int value) {
            this.value = value;
        }
    }
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node current = root;
        while (true) {
            if (newNode.value == current.value) return false;
            if (value < current.value) {
                if (current.left == null) {
                    current.left = newNode;
                    return true;
                }
                current = current.left;
            }
            else {
                if (current.right == null) {
                    current.right = newNode;
                    return true;
                }
                current = current.right;
            }
        }
    }

    public boolean search(int value) {
        Node current = root;
        while (current != null) {
            if (current.value == value) return true;
            if (value < current.value) current = current.left;
            else current = current.right;
        }
        return false;
    }
    public void printTree() {
        printTree(root);
    }
    private void printTree(Node node) {
        if (node == null) return;
        printTree(node.left);
        System.out.print(node.value + " ");
        printTree(node.right);
    }
    public int getHeight() {
        return getHeight(root);
    }
    private int getHeight(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    public int getSize() {
        return getSize(root);
    }
    private int getSize(Node node) {
        if (node == null) return 0;
        return 1 + getSize(node.left) + getSize(node.right);
    }
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
}

public class BinarySearchTree {

    // Node class to represent each node in the tree
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    // Root of the binary search tree
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a value into the binary search tree
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // Recursive method to insert a value in the BST
    private Node insertRecursive(Node root, int value) {
        // Base case: if the tree is empty, return a new node
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Otherwise, recur down the tree
        if (value < root.value) {
            root.left = insertRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursive(root.right, value);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Search for a value in the BST
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    // Recursive method to search for a value in the BST
    private boolean searchRecursive(Node root, int value) {
        // Base case: root is null or the value is present at the root
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }

        // Value is greater than the root's value, search in the right subtree
        if (value > root.value) {
            return searchRecursive(root.right, value);
        }

        // Value is smaller than the root's value, search in the left subtree
        return searchRecursive(root.left, value);
    }

    // In-order traversal of the tree (left, root, right)
    public void inorderTraversal() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);  // Visit left subtree
            System.out.print(root.value + " ");  // Visit root
            inorderRecursive(root.right);  // Visit right subtree
        }
    }

    // Main method to test the BST
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values into the binary search tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Perform in-order traversal
        System.out.println("In-order traversal of BST:");
        bst.inorderTraversal();  // Expected: 20 30 40 50 60 70 80

        // Search for a value in the BST
        System.out.println("\n\nSearching for 40 in the BST: " + bst.search(40));  // Expected: true
        System.out.println("Searching for 90 in the BST: " + bst.search(90));  // Expected: false
    }
}
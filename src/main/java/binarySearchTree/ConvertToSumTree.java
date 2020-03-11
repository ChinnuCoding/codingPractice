package binarySearchTree;



public class ConvertToSumTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

        // Function to print pre-order traversal of given tree
        public static void preorder(Node root)
        {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Recursive function to in-place convert the given binary tree to its
        // sum tree by traversing the tree in post-order manner
        public static int convertToSumTree(Node root)
        {
            // base case: tree is empty
            if (root == null) {
                return 0;
            }

            // recursively convert left and right subtree first before
            // processing the root node
            int left = convertToSumTree(root.left);
            int right = convertToSumTree(root.right);

            // stores current value of root node
            int old = root.data;

            // update root to sum of left and right subtree
            root.data = left + right;

            // return the updated value plus old value (sum of tree rooted at root node)
            return root.data + old;
        }

        // main function
        public static void main(String[] args)
        {
            Node root = null;
            root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.right = new Node(4);
            root.right.left = new Node(5);
            root.right.right = new Node(6);
            root.right.left.left = new Node(7);
            root.right.left.right = new Node(8);

            convertToSumTree(root);
            preorder(root);
        }


}

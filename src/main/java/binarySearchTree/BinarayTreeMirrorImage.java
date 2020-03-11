package binarySearchTree;

// Data structure to store a Binary Tree BinaryTreeNode
class BinaryTreeNode {
    int data;
    BinaryTreeNode left = null, right = null;

    BinaryTreeNode(int data) {
        this.data = data;
    }
}

class BinarayTreeMirrorImage {
    // Function to perform preorder traversal of the binary tree
    public static void preorder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Utility function to swap left subtree with right subtree
    public static void swap(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // Function to convert given binary Tree to its mirror
    public static void convertToMirror(BinaryTreeNode root) {
        // base case: if tree is empty
        if (root == null) {
            return;
        }

        // convert left subtree
        convertToMirror(root.left);

        // convert right subtree
        convertToMirror(root.right);

        // swap left subtree with right subtree
        swap(root);
    }

    // main function
    public static void main(String[] args) {
	    /* Construct below tree
	          1
	        /   \
	       /     \
	      2       3
	     / \     / \
	    4   5   6   7   */

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        convertToMirror(root);
        preorder(root);
    }
}


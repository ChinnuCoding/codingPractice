package binarySearchTree;

public class IsValidBST {

    /**
     * Another way to check with is valid binarySearchTree or not is by getting inorder traversal of the tree and if it's in sorted
     * order then it's binarySearchTree.
     */

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Function to determine if given Binary Tree is a binarySearchTree or not by keeping a
    // valid range (starting from [MIN_VALUE, MAX_VALUE]) and keep shrinking
    // it down for each node as we go down recursively
    public static boolean isBST(Node node, int minKey, int maxKey)
    {
        // base case
        if (node == null) {
            return true;
        }

        // if node's value fall outside valid range
        if (node.data < minKey || node.data > maxKey) {
            return false;
        }

        // recursively check left and right subtrees with updated range
        return isBST(node.left, minKey, node.data) &&
                isBST(node.right, node.data, maxKey);
    }

    // Function to determine if given Binary Tree is a binarySearchTree or not
    public static void isBST(Node root)
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("This is a binarySearchTree.");
        } else {
            System.out.println("This is NOT a binarySearchTree!");
        }
    }


    // Function to perform inorder traversal of the given binary tree and
    // check if it is a binarySearchTree or not. Here prev is previous processed node
    public static boolean isBST(Node root, Node prev)
    {
        // base case: empty tree is a binarySearchTree
        if (root == null) {
            return true;
        }

        // check if left subtree is binarySearchTree or not
        boolean left = isBST(root.left, prev);

        // value of current node should be more than that of previous node
        if (root.data <= prev.data) {
            return false;
        }

        // update previous node data and check if right subtree is binarySearchTree or not
        prev.data = root.data;

        return left && isBST(root.right, prev);
    }

    // Function to determine if given Binary Tree is a binarySearchTree or not
    public static void isBSTPreOrderTraversal(Node node)
    {
        // pointer to store previous processed node in inorder traversal
        Node prev = new Node(Integer.MIN_VALUE);

        // check if nodes are nodes are processed in sorted order
        if (isBST(node, prev)) {
            System.out.println("This is a binarySearchTree.");
        } else {
            System.out.println("This is NOT a binarySearchTree!");
        }
    }
}

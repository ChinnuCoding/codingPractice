package binaryTree;


import java.util.concurrent.atomic.AtomicInteger;



class FindDiffOddLevelNEvenLevel {

    // Data structure to store a Binary Tree node
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }

    // Helper function
    public static void findDiff(Node root, AtomicInteger diff, int level)
    {
        // base case
        if (root == null) {
            return;
        }

        // if current level is odd
        if (level % 2 == 1) {
            diff.set(diff.get() + root.data);
        }
        // if current level is even
        else {
            diff.set(diff.get() - root.data);
        }

        // recur for left subtree and right subtree
        findDiff(root.left, diff, level + 1);
        findDiff(root.right, diff, level + 1);
    }

    // Function to calculate the difference between sum of all nodes present
    // at odd levels and sum of all nodes present at even level
    public static int findDiff(Node root)
    {
        // Using AtomicBoolean as Integer is passed by value in Java
        AtomicInteger diff = new AtomicInteger(0);
        findDiff(root, diff, 1);

        return diff.get();
    }

    // main function
    public static void main(String[] args)
    {
	    /* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		     /      /  \
		    /      /    \
		   4      5      6
		         / \
		        /   \
		       7     8
	    */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.print(findDiff(root));
    }
}
package binarySearchTree;



// Data structure to store a Binary Tree node
class MaxPathSumNode
{
    int data;
    MaxPathSumNode left = null, right = null;

    MaxPathSumNode(int data) {
        this.data = data;
    }
}


public class MaxPathSumNPath {

        // Function to print root-to-leaf path having given sum in a binary tree
        public static boolean printPath (MaxPathSumNode root, int sum)
        {
            // base case
            if (sum == 0) {
                return true;
            }

            // base case
            if (root == null) {
                return false;
            }

            // recur for left and right subtree with reduced sum
            boolean left = printPath(root.left, sum - root.data);
            boolean right = printPath(root.right, sum - root.data);

            // print current node if it lies on path having given sum
            if (left || right) {
                System.out.print(root.data + " ");
            }

            return left || right;
        }

        // Function to calculate maximum root-to-leaf sum in a binary tree
        public static int rootToLeafSum(MaxPathSumNode root)
        {
            // base case: tree is empty
            if (root == null) {
                return 0;
            }

            // calculate maximum node-to-leaf sum for left child
            int left = rootToLeafSum(root.left);

            // calculate maximum node-to-leaf sum for right child
            int right = rootToLeafSum(root.right);

            // consider maximum sum child
            return (left > right ? left : right) + root.data;
        }

        // Function to print maximum sum root-to-leaf path in a given binary tree
        public static void findMaxSumPath(MaxPathSumNode root)
        {
            int sum = rootToLeafSum(root);
            System.out.println("Maximum sum is " + sum);
            System.out.println("Maximum sum path is: ");

            printPath(root, sum);
        }

        // main function
        public static void main(String[] args)
        {
            MaxPathSumNode root = null;
	    /* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		     / \     / \
		    8   4   5   6
		       /   / \   \
		     10   7   9   5
	    */

            root = new MaxPathSumNode(1);
            root.left = new MaxPathSumNode(2);
            root.right = new MaxPathSumNode(3);
            root.left.left = new MaxPathSumNode(8);
            root.left.right = new MaxPathSumNode(4);
            root.right.left = new MaxPathSumNode(5);
            root.right.right = new MaxPathSumNode(6);
            root.left.right.left = new MaxPathSumNode(10);
            root.right.left.left = new MaxPathSumNode(7);
            root.right.left.right = new MaxPathSumNode(9);
            root.right.right.right  = new MaxPathSumNode(5);

            findMaxSumPath(root);
        }


}

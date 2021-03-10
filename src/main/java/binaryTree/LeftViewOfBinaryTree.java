package binaryTree;

// Java program to print left view of binary tree

import java.util.LinkedList;
import java.util.Queue;

/* Class containing left and right child of current
node and key value*/
class Node {
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

/* Class to print the left view */
class LeftViewOfBinaryTree {
    Node root;
    static int max_level = 0;

    // recursive function to print left view
    void leftViewUtil(Node node, int level)
    {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // A wrapper over leftViewUtil()
    void leftView()
    {

        System.out.println("\nLeft view using recursion");
        leftViewUtil(root, 1);
    }

    // function to print right view of binary tree
    static void printRightViewUsingQueue(Node root)
    {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("Left view using QUEUE");

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();

            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();

                // Print the left most element at
                // the level
                if (i == 1)
                    System.out.print(temp.data + " ");

                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);

                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }


    public static void main(String args[])
    {
        LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        printRightViewUsingQueue(tree.root);

        tree.leftView();
    }
}
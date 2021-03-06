package binarySearchTree;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;

    Node(int key) {
        this.key = key;
    }
}

class Main {

    // Iterative function to print left view of given binary tree
    public static void leftView(Node root)
    {
        // return if tree is empty
        if (root == null) {
            return;
        }

        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        // pointer to store current node
        Node curr;

        // run till queue is not empty
        while (!queue.isEmpty())
        {
            // calculate number of nodes in current level
            int size = queue.size();
            int i = 0;

            // process every node of current level and enqueue their
            // non-empty left and right child to queue
            while (i++ < size) {
                curr = queue.poll();

                // if this is first node of current level, print it
                if (i == 1) {
                    System.out.print(curr.key + " ");
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    // traverse nodes in pre-order fashion
    public static void leftViewUsingMap(Node root, int level, Map<Integer, Integer> map)
    {
        // base case
        if (root == null) {
            return;
        }

        // if level is visited for the first time, insert the current node
        // and level information into the map
        if (!map.containsKey(level)) {
            map.put(level, root.key);
        }

        leftViewUsingMap(root.left, level + 1, map);
        leftViewUsingMap(root.right, level + 1, map);
    }

    // Function to print left view of given binary tree
    public static void leftViewUsingMap(Node root)
    {
        // create an empty HashMap to store first node for each level
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // traverse the tree and fill map
        leftViewUsingMap(root, 1, map);

        // iterate through the HashMap in sorted order of its keys
        // and print the left view
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    // main function
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        leftView(root);
    }
}
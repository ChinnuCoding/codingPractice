package binaryTree;


import java.util.LinkedList;
import java.util.Queue;

// Recursive Java program for level
  /* Class containing left and right child of current
   node and key value*/
class BinaryTreeNode
{
    int data;
    BinaryTreeNode left, right;
    public BinaryTreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}

// order traversal of Binary Tree
class BinaryTree
{


    // Root of the Binary Tree
    BinaryTreeNode root;

    public BinaryTree()
    {
        root = null;
    }

    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(BinaryTreeNode root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel (BinaryTreeNode root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    /* Given a binary tree. Print
    its nodes in level order
    using array for implementing queue  */
    void printLevelOrderUsingQueue()
    {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/
            util/linkedlist_poll.htm */
            BinaryTreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }


    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root= new BinaryTreeNode(1);
        tree.root.left= new BinaryTreeNode(2);
        tree.root.right= new BinaryTreeNode(3);
        tree.root.left.left= new BinaryTreeNode(4);
        tree.root.left.right= new BinaryTreeNode(5);

        System.out.print("\n Level order traversal of binary tree is : ");
                tree.printLevelOrder();

        System.out.print("\n Level order traversal using Queue : ");
                tree.printLevelOrderUsingQueue();
    }
}
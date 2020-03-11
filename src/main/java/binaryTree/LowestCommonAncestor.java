package binaryTree;

public class LowestCommonAncestor {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node findLeastCommonAncestor(Node root, int leftNode, int rightNode) {

        if(root == null) {
            return null;
        }

        if(root.data == leftNode || root.data == rightNode) {
            return root;
        }

        Node leftCommonAncestor = findLeastCommonAncestor(root.left, leftNode, rightNode);
        Node rightCommonAncestor = findLeastCommonAncestor(root.right, leftNode, rightNode);

        if(leftCommonAncestor != null && rightCommonAncestor != null) {
            return root;
        }

        if(leftCommonAncestor == null && rightCommonAncestor == null) {
            return null;
        }

        return leftCommonAncestor != null ? leftCommonAncestor : rightCommonAncestor;

    }



}

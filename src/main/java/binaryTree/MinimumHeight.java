package binaryTree;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class MinimumHeight {

    static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left ==null) return 1+minDepth(root.right);
        if(root.right ==null) return 1+minDepth(root.left);
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }

}

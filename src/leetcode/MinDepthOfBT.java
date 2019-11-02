package leetcode;

public class MinDepthOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MinDepthOfBT minDepthOfBT = new MinDepthOfBT();
        int result = minDepthOfBT.minDepth(root);
        System.out.println(result);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) {
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}

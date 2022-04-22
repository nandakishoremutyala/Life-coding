package leetcode;

public class MinDepthOfBinaryTree {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return min;
    }

    public void dfs(TreeNode root, int level) {
        System.out.println("Level: " + level + " Min: " + min);
        if (root.left == null && root.right == null) {
            min = Math.min(min, level);
        }

        if (root.left != null) {
            dfs(root.left, level + 1);
        }
        if (root.right != null) {
            dfs(root.right, level + 1);
        }
    }
}

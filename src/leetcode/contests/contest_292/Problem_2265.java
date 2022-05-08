package leetcode.contests.contest_292;

import leetcode.TreeNode;

public class Problem_2265 {
    public static void main(String[] args) {
        Problem_2265 p = new Problem_2265();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        int res= p.averageOfSubtree(root);
        System.out.println(res);
    }
    private static int result;
    public int averageOfSubtree(TreeNode root) {
        result=0;
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] scl = dfs(root.left);
        int[] scr = dfs(root.right);
        int sum = scl[0] + scr[0] + root.val;
        int count = scl[1] + scr[1] + 1;
        if (sum / count == root.val) {
            result++;
        }
        return new int[]{sum, count};
    }
}

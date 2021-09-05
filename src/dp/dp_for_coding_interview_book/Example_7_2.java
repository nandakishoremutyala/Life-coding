package dp.dp_for_coding_interview_book;

import leetcode.TreeNode;

public class Example_7_2 {
    static TreeNode root = new TreeNode(2);
    public static void main(String[] args) {
        root.left = new TreeNode(4);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);

        root.right.right = new TreeNode(2);

        updateSum(root);
        System.out.println(root);
    }

    private static void updateSum(TreeNode root) {
        if (root == null) return;
        updateSum(root.left);
        updateSum(root.right);
        int l = root.left == null ? 0 : root.left.val;
        int r = root.right == null ? 0 : root.right.val;
        root.val+=l+r;
        System.out.println(root.val);
    }
}

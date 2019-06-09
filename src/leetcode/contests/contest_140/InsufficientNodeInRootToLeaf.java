package leetcode.contests.contest_140;

import leetcode.TreeNode;

public class InsufficientNodeInRootToLeaf {
    static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(-99);
        root.right.left = new TreeNode(-99);
        root.right.right = new TreeNode(7);


        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(-99);
        root.left.right.right = new TreeNode(-99);

        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(-99);
        root.right.right.right = new TreeNode(14);
        compute(root);
    }

    private static void compute(TreeNode root) {
        helper(root, 1, 0);
        System.out.println(root);
        makeValueNull(root);
        System.out.println(root);

    }

    private static void makeValueNull(TreeNode root) {
        if(root==null)return;
        if(root.val==Integer.MIN_VALUE)
            nullify(root);
        else{
            makeValueNull(root.left);
            makeValueNull(root.right);
        }

    }

    private static void nullify(TreeNode root) {
        if(root==null)return;
        if(root.left==null && root.right==null)
            root=null;
        else{
            nullify(root.left);
            nullify(root.right);
            //nullify(root);
        }
    }

    private static void helper(TreeNode root, int limit, int sum) {
        if (root == null) return;
        if ((root.left == null && root.right == null)) {
            sum += root.val;
            if (sum < limit)
                root.val = Integer.MIN_VALUE;
        }  else {

            helper(root.left, limit, sum + root.val);
            helper(root.right, limit, sum + root.val);
            if ((root.left.val == Integer.MIN_VALUE && root.right.val == Integer.MIN_VALUE)) {
                root.val = Integer.MIN_VALUE;
            }
        }
    }
}

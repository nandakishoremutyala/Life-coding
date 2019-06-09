package leetcode.contests.contest_140;

import leetcode.TreeNode;

import java.util.HashSet;

public class InsufficientNodeInRootToLeaf {
    static HashSet<TreeNode> toBeDeleted = new HashSet<>();
    static int limit = 1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

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
        sufficientSubset(root, limit);
    }

    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null)
            return root;
        editTree(root, limit);
        if (toBeDeleted.contains(root))
            root = null;
        return root;
    }

    private static void editTree(TreeNode root, int limit) {
        //1. if root is null, nothing to do
        if (root == null) return;
        //2. We have to traverse upto the leaf, use recursion
        editTree(root.left, limit - root.val);
        editTree(root.right, limit - root.val);
        //3. find the leaf
        boolean isLeaf = root.left == null && root.right == null;

        if (!isLeaf) {
            //5. if left child is in the deleted list, make it null
            if (toBeDeleted.contains(root.left)) {
                toBeDeleted.remove(root.left);
                root.left = null;
            }
            //6. if right child is in the deleted list, make it null
            if (toBeDeleted.contains(root.right)) {
                toBeDeleted.remove(root.right);
                root.right = null;
            }
            //7. if both child are null for the parent, make it in the delete list
            if (root.left == null && root.right == null)
                toBeDeleted.add(root);
        }
        //4. if it is leaf, check the limit
        // if root value is smaller than limit, add it to be deleted
        else if (root.val < limit)
            toBeDeleted.add(root);

    }
}

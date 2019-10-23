package data_structure.trees;

import leetcode.TreeNode;

public class ValidateBST {
    public static void main(String[] args) {
        ValidateBST validateBST=new ValidateBST();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(1);
        System.out.println(validateBST.isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        return helper(root,null, null);
    }

    private boolean helper(TreeNode root, TreeNode l, TreeNode r){
        // Base condition
        if (root == null)
            return true;

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (l != null && root.val <= l.val)
            return false;

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (r != null && root.val >= r.val)
            return false;

        // check recursively for every node.
        return helper(root.left, l, root) &&
                helper(root.right, root, r);
    }
}

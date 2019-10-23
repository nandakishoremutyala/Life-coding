package data_structure.trees;

import leetcode.TreeNode;

import java.util.*;

public class BinaryTreeFromInorderAndPostOrder {
    Map<Integer, Integer> map = new HashMap<>();
    int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length-1;

        int idx = 0;
        for(int val : inorder) {
            map.put(val, idx++);
        }
        return createTree(0, inorder.length-1, inorder, postorder);
    }

    public TreeNode createTree(int left, int right, int[] inorder, int[] postorder) {
        if(left > right) {
            return null;
        }

        int rootVal = postorder[postorderIndex--];
        int inorderIndex = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.right = createTree(inorderIndex+1, right, inorder, postorder);
        root.left = createTree(left, inorderIndex-1, inorder, postorder);

        return root;
    }
}

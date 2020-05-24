package leetcode.contests.contest_190;

import leetcode.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PseudoPalindromicPathsInBT {

    @Test
    public void firstTest(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(1);
        pseudoPalindromicPaths(root);
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        findPaths(root, sb,
                paths);
        int count=0;
        for(String str:paths) {
           if( canFormPalindrome(str))
               count++;
        }

        return count;

    }

    private void findPaths(TreeNode root,
                           StringBuilder stringBuilder,
                           ArrayList<String> result) {
        if (root.left == null && root.right == null) {
            //stringBuilder.append(root.val);
            result.add(stringBuilder.toString());

        }
        if (root.left != null){
            stringBuilder.append(root.left.val);
            findPaths(root.left, stringBuilder, result);
        }

        if (root.right != null){
            stringBuilder.append(root.right.val);
            findPaths(root.right, stringBuilder, result);
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }

    static boolean canFormPalindrome(String str) {

        // Create a list
        List<Character> list = new ArrayList<Character>();

        // For each character in input strings,
        // remove character if list contains
        // else add character to list
        for (int i = 0; i < str.length(); i++) {
            if (list.contains(str.charAt(i)))
                list.remove((Character) str.charAt(i));
            else
                list.add(str.charAt(i));
        }

        // if character length is even list is expected to be empty
        // or if character length is odd list size is expected to be 1
        if (str.length() % 2 == 0 && list.isEmpty() // if string length is even
                || (str.length() % 2 == 1 && list.size() == 1)) // if string length is odd
            return true;
        else
            return false;

    }
}

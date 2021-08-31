package dailycodings;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DailyCoding_983 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);

        List<List<Integer>> result=new ArrayList<>();
        allPaths(result,root, new ArrayList<>());
        System.out.println(result);
    }

    private static void allPaths(List<List<Integer>> result, TreeNode root, ArrayList<Integer> temp) {
        temp.add(root.val);
        if(root.left==null && root.right==null){
            result.add(new ArrayList<>(temp));
        }
        if(root.left!=null){
            allPaths(result,root.left,temp);
            temp.remove(temp.size()-1);
        }

        if(root.right!=null){
            allPaths(result,root.right,temp);
            temp.remove(temp.size()-1);
        }

    }
}

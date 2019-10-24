package data_structure.graph.dfs;

import leetcode.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaximumTreePathSum {
    MaximumTreePathSum maximumTreePathSum;
    TreeNode root;
    int max;
    @BeforeEach
    public void init(){
        maximumTreePathSum=new MaximumTreePathSum();
        max=Integer.MIN_VALUE;
    }
    @Test
    public void firstTest(){
        root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        int result=maxPathSum(root);
        System.out.println(result);
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if(root==null)return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        int sum = root.val + Math.max(left, 0) + Math.max(right, 0);
        max = Math.max(sum, max);
        sum = root.val + Math.max(0, Math.max(left, right));
        return sum;
    }
}

package leetcode.contests.contest_150;

import leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MaximumLevelSumOfBT {
    MaximumLevelSumOfBT maximumLevelSumOfBT;
    TreeNode root = new TreeNode(1);
    static Map<Integer, Integer> level;
    static int max = Integer.MIN_VALUE;
    static int maxLevel=0;

    @BeforeEach
    public void init() {
        buildtree(root);
        maximumLevelSumOfBT = new MaximumLevelSumOfBT();
    }

    private void buildtree(TreeNode root) {
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        //root.right.right.right = new TreeNode(-32127);
    }

    @Test
    public void firstTest() {
        int max= maximumLevelSumOfBT.maxLevelSum(root);
        Assertions.assertEquals(2,max);
    }

    public int maxLevelSum(TreeNode root) {
        level = new HashMap<>();
        computeLevel(root, 0);
        System.out.println(level);
        for (Map.Entry<Integer,Integer> entry : level.entrySet()) {
            int val = entry.getValue();
            if(val>=max){
                max=val;
                maxLevel=entry.getKey();
            }
        }
        return maxLevel+1;
    }

    private void computeLevel(TreeNode root,
                              int curLevel) {
        if (root == null)
            return;
        if (level.containsKey(curLevel)) {
            int nVal = level.get(curLevel) + root.val;
            level.put(curLevel, nVal);
        } else
            level.put(curLevel, root.val);
        computeLevel(root.left, curLevel + 1);
        computeLevel(root.right, curLevel + 1);
    }
}

package leetcode.contests.contest_150;

import leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBT {
    MaximumLevelSumOfBT maximumLevelSumOfBT;
    TreeNode root = new TreeNode(1);

    @BeforeEach
    public void init() {
        buildTree(root);
        maximumLevelSumOfBT = new MaximumLevelSumOfBT();
    }

    private void buildTree(TreeNode root) {
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
    }

    @Test
    public void firstTest() {
        int max = maximumLevelSumOfBT.maxLevelSum(root);
        Assertions.assertEquals(2, max);
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int maxlevel = 1, maxSum = root.val, level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSum = 0, size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                levelSum += node.val;
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxlevel = level;
            }
            level++;
        }
        return maxlevel;
    }
}

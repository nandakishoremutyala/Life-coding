package leetcode.contests.contest_172;

import leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteLeavesWithGivenValue {
    DeleteLeavesWithGivenValue deleteLeavesWithGivenValue;

    @BeforeEach
    public void init() {
        deleteLeavesWithGivenValue = new DeleteLeavesWithGivenValue();
    }

    @Test
    public void firstTest() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        TreeNode resultHead= deleteLeavesWithGivenValue.removeLeafNodes(root,2);
        Assertions.assertEquals(resultHead.val,1);
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return helper(root, target);
    }

    private TreeNode helper(TreeNode root, int target) {
        if (root == null) return null;
        if (root.left == null && root.right == null && root.val == target) return null;
        root.left = helper(root.left, target);
        root.right = helper(root.right, target);
        if(root.left==null && root.right==null && root.val==target)
            root=null;
        return root;
    }
}

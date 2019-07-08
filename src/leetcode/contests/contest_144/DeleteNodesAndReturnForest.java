package leetcode.contests.contest_144;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int de : to_delete) {
            set.add(de);
        }
        //put to-delete number in hashset for O(1) lookup
        dfs(root, set, result, true);
        return result;
    }

    private void dfs(TreeNode root,
                     Set<Integer> del,
                     List<TreeNode> result, boolean isRoot) {
        //if current root does not contain in the del and it is root, then add to the result
        if (!del.contains(root.val) && isRoot)
            result.add(root);

        isRoot = del.contains(root.val);
        //if the parent node is deleted, then child is the root
        if (root.left != null) {
            dfs(root.left, del, result, isRoot);
            if (del.contains(root.left.val))
                root.left = null;
        }
        if (root.right != null) {
            dfs(root.right, del, result, isRoot);
            if (del.contains(root.right.val))
                root.right = null;
        }
    }
}

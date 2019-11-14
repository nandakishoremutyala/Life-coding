package data_structure.trees;

import java.util.*;

public class BTLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());
        int level = 0;
        helper(root, level, map);
        System.out.println(map);

        //Collections.sort(map,Collections.reverseOrder());
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet())
            result.add(e.getValue());
        return result;
    }

    private void helper(TreeNode root, int level, Map<Integer, List<Integer>> m) {
        if (root == null) return;
        m.compute(level, (k, v) -> v == null ? new ArrayList<Integer>() : v).add(root.val);
        helper(root.left, level + 1, m);
        helper(root.right, level + 1, m);
    }
}

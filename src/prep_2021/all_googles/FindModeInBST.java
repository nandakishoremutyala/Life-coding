package prep_2021.all_googles;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindModeInBST {
    Map<Integer, Integer> count = new HashMap<>();

    public int[] findMode(TreeNode root) {
        dfs(root, count);

        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> top = new TreeMap<>();

        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int k = e.getKey();
            int v = e.getValue();
            top.compute(v, (key, val) -> val == null ? new ArrayList<>() : val).add(k);
        }

        Map.Entry<Integer, ArrayList<Integer>> e = top.lastEntry();

        int[] res = new int[e.getValue().size()];
        int pos = 0;
        for (Integer i : e.getValue())
            res[pos++] = i;
        return res;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left, map);
        dfs(root.right, map);
    }
}

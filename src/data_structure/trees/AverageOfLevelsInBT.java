package data_structure.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AverageOfLevelsInBT {
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        int level = 0;
        helper(root, level, map);
        System.out.println(map);

        //Collections.sort(map,Collections.reverseOrder());
        List<Double> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            Double average = e.getValue().stream().mapToInt(val -> val).average().orElse(0.0);
            result.add(average);
        }
        return result;
    }

    private void helper(TreeNode root, int level, Map<Integer, List<Integer>> m) {
        if (root == null) return;
        m.compute(level, (k, v) -> v == null ? new ArrayList<Integer>() : v).add(root.val);
        helper(root.left, level + 1, m);
        helper(root.right, level + 1, m);
    }
}

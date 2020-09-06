package leetcode.contests.contest_198;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class NumberOfNodesInSubtree {
    NumberOfNodesInSubtree numberOfNodesInSubtree;
    static int[] result;

    @BeforeEach
    public void init() {
        numberOfNodesInSubtree = new NumberOfNodesInSubtree();
    }

    @Test
    public void firstTest() {
        numberOfNodesInSubtree.countSubTrees(7,
                new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd");
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        result = new int[n];
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int src = e[0];
            int dest = e[1];
            tree[src].add(dest);
        }
        TreeMap<Character, Integer> res = iterate(0, tree, labels, new TreeMap<Character, Integer>());
        MasterPrinter.printArray(result);
        return result;

    }

    private TreeMap<Character, Integer> iterate(int start, ArrayList<Integer>[] tree, String labels, TreeMap<Character, Integer> map) {
        if (tree[start].size() == 0) {
            TreeMap<Character,Integer> tMap=new TreeMap<>();
            tMap.put(labels.charAt(start),1);
            result[start] = 1;
            return tMap;
        }

        for (int i = 0; i < tree[start].size(); i++) {
            TreeMap<Character, Integer> t = iterate(tree[start].get(i), tree, labels, map);
            map = merge(map, t, start, labels.charAt(start));
        }
        map.compute(labels.charAt(start), (K, V) -> V == null ? 1 : V + 1);
        result[start] = map.get(labels.charAt(start));
        return map;
    }

    private TreeMap<Character, Integer> merge(TreeMap<Character, Integer> left, TreeMap<Character, Integer> right, int start, char c) {
        for (Map.Entry<Character, Integer> e : right.entrySet()) {
            left.compute(e.getKey(), (K, V) -> V == null ? e.getValue() : V + e.getValue());
        }
        return left;
    }
}

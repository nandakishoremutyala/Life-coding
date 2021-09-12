package leetcode.contests.contest_258;

import java.util.ArrayList;
import java.util.List;

public class MissingGeneticValue {
    public static void main(String[] args) {

    }

    class GNode {
        int val;
        int root;
        List<GNode> childs;

        public GNode(int val, int root) {
            this.val = val;
            this.root = root;
            this.childs = new ArrayList<>();
        }
    }

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        ArrayList<Integer>[] gTree = new ArrayList[5];
        return null;
    }
}

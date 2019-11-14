package data_structure.trees;

import java.util.PriorityQueue;

public class KthSmallestElementInBST {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        int last = -1;
        while (!pq.isEmpty() && k > 0) {
            last = pq.poll();
            k--;
        }

        return last;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        pq.add(root.val);
        helper(root.right);
    }
}

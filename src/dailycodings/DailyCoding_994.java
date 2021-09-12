package dailycodings;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DailyCoding_994 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (tree.size() <= level) {
                    tree.add(level, new ArrayList<>());
                }
                tree.get(level).add(node.val);
                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
        }
        print(tree);

    }

    private static void print(List<List<Integer>> tree) {
        for (List<Integer> list : tree) {
            for (int i : list) {
                System.out.print(i + "-");
            }
            System.out.println("");
        }
    }
}

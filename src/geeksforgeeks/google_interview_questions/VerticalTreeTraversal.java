package geeksforgeeks.google_interview_questions;

import others.MasterPrinter;

import java.util.ArrayList;

public class VerticalTreeTraversal {

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static ArrayList<int[]> temp = new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);

        root.right.right=new Node(6);

        dfs(root, 0, 0);
        temp.sort((x, y) -> {
            if (x[0] < y[0]) return -1;
            else if (x[0] == y[0]) {
                return x[1] - y[1];
            } else return 1;
        });
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] in : temp) {
            result.add(in[2]);
        }

        verticalOrder(root);
        MasterPrinter.printList(result);
        /**
         *  2     2        1
         * [0 1][0 2][1 3][0 4] [1 5]
         * a^b^c=a^c^b
         * */
    }

    static ArrayList<Integer> verticalOrder(Node root) {
        dfs(root, 0, 0);
        temp.sort((x, y) -> {
            if (x[0] < y[0]) return -1;
            else if (x[0] == y[0]) {
                return x[1] - y[1];
            } else return 1;
        });
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] in : temp) {
            result.add(in[2]);
        }
        return result;
    }

    public static void dfs(Node root, int x, int y) {
        if (root == null) return;
        temp.add(new int[]{x, y, root.data});
        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }
}



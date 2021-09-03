package data_structure.graph;

import java.util.LinkedList;
import java.util.Stack;

public class HamiltonianCycle {
    /* static int[][] graph = new int[][]{
             {0, 1, 0, 1, 0}, //0
             {1, 0, 1, 1, 1}, //1
             {0, 1, 0, 0, 1}, //2
             {1, 1, 0, 0, 1}, // 3
             {0, 1, 1, 1, 0}
     };*/
    static int graph[][] = {{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
    };

    static int start = 0;
    static int N=5;

    // graph[i][j] means i and j has a connections or path
    public static void main(String[] args) {
        LinkedList<Integer> path = new LinkedList<>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        doBackTrack(path, stack);
    }

    private static void doBackTrack(LinkedList<Integer> path, Stack<Integer> stack) {
        if (path.size() == 5 && graph[path.getFirst()][path.getLast()] != 1) {
            System.out.println("No found");
            return;
        }

        int curr = stack.pop();
        if (!path.contains(curr)) {
            path.addLast(curr);
        }
        if (path.size() == N && graph[path.getFirst()][path.getLast()] == 1) {
            path.addLast(start);
            printPath(path);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (graph[curr][i] == 1 && !path.contains(i)) {
                stack.push(i);
                doBackTrack(path, stack);
                path.removeLast();
            }
        }

    }

    private static void printPath(LinkedList<Integer> path) {
        for (int data : path) {
            System.out.print(data + "-");
        }
        System.out.println("*********");
    }
}

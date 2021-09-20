package dailycodings;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * This problem was asked by Microsoft.
 *
 * The transitive closure of a graph is a measure of which vertices are reachable from other vertices. It can be represented as a matrix M, where M[i][j] == 1 if there is a path between vertices i and j, and otherwise 0.
 *
 * For example, suppose we are given the following graph in adjacency list form:
 *
 * graph = [
 *     [0, 1, 3],
 *     [1, 2],
 *     [2],
 *     [3]
 * ]
 * The transitive closure of this graph would be:
 *
 * [1, 1, 1, 1]
 * [0, 1, 1, 0]
 * [0, 0, 1, 0]
 * [0, 0, 0, 1]
 * Given a graph, find its transitive closure.
 * */
public class DailyCoding_1003 {
    public static void main(String[] args) {
        int N=4;
        List<Integer>[] graph=new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(0);
        graph[0].add(1);
        graph[0].add(3);

        graph[1].add(1);
        graph[1].add(2);

        graph[2].add(2);

        graph[3].add(3);

        findTransitiveClosure(graph,N);
    }

    private static void findTransitiveClosure(List<Integer>[] graph, int n) {
        int[][] matrix=new int[n][n];
        for (int i = 0; i <n ; i++) {
            List<Integer> adj=graph[i];
            for(int data:adj){
                matrix[i][data]=1;
            }
        }
        MasterPrinter.printMatrix(matrix);
        runFloydWarshall(matrix,n);
    }

    private static void runFloydWarshall(int[][] matrix, int n) {
        for(int k=0;k<n;k++){
            for (int i = 0; i <n ; i++) {// i is src
                for (int j = 0; j <n ; j++) { // j is destination
                    if(matrix[i][j]==1) continue;
                    if(matrix[i][k]==1 && matrix[k][j]==1){
                        matrix[i][j]=1;
                    }
                }
            }
        }
        MasterPrinter.printMatrix(matrix);
    }
}

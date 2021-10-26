package leetcode.contests.contest_264;

import java.util.*;

public class CountNodesWithHighestScore {
    public static void main(String[] args) {
        CountNodesWithHighestScore cnhs = new CountNodesWithHighestScore();
        int[] in = new int[]{-1,3,3,5,7,6,0,0};
        //int[] in = new int[]{-1, 2, 0};
        int res = cnhs.countHighestScoreNodes(in);
        System.out.println(res);
    }

    public int countHighestScoreNodes(int[] parents) {
        ArrayList<Integer>[] graph = new ArrayList[parents.length];
        buildGraph(graph, parents);
        System.out.println(graph);
        Map<Integer, Integer> nodeCount = new HashMap<>();
        count(graph, nodeCount, 0);
        System.out.println(nodeCount);

        int max = 0;
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        for (int i = 0; i < parents.length; i++) {
            if (i == 0) {
                if (graph[i].size() == 1) {
                    int count = nodeCount.get(graph[i].get(0));
                    pq.compute(count, (k, v) -> v == null ? 1 : v + 1);
                }else if(graph[i].size()==2){
                    int leftCount = nodeCount.get(graph[i].get(0));
                    int rightCount = nodeCount.get(graph[i].get(1));
                    int count=leftCount*rightCount;
                    pq.compute(count, (k, v) -> v == null ? 1 : v + 1);
                }else{
                    return 0;
                }
            } else {
                int c = graph[i].size();
                if (c == 0) {
                    int count = nodeCount.get(0) - 1;
                    pq.compute(count, (k, v) -> v == null ? 1 : v + 1);
                } else if (c == 1) {
                    int bottomCount = nodeCount.get(graph[i].get(0));
                    int topCount = nodeCount.get(0) - 1 - bottomCount;
                    int count = bottomCount * topCount;
                    pq.compute(count, (k, v) -> v == null ? 1 : v + 1);
                } else {
                    int leftCount = nodeCount.get(graph[i].get(0));
                    int rightCount = nodeCount.get(graph[i].get(1));
                    int rest = nodeCount.get(0) - nodeCount.get(i);
                    int count = leftCount * rest * rightCount;
                    pq.compute(count, (k, v) -> v == null ? 1 : v + 1);
                }
            }
        }
        System.out.println(pq.lastEntry().getValue());
        return pq.lastEntry().getValue();
    }

    private void count(ArrayList<Integer>[] graph, Map<Integer, Integer> nodeCount, int root) {
        if (graph[root].size() == 0) {
            nodeCount.put(root, 1);
            return;
        }
        for (int child : graph[root]) {
            count(graph, nodeCount, child);
            nodeCount.put(root, nodeCount.getOrDefault(root, 0) + nodeCount.get(child));
        }
        nodeCount.put(root, nodeCount.getOrDefault(root, 1) + 1);

    }

    private void buildGraph(ArrayList<Integer>[] graph, int[] parents) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < parents.length; i++) {
            int parent = parents[i];
            if (parent == -1)
                continue;
            graph[parent].add(i);
        }

    }
}

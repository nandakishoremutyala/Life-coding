package leetcode.contests.contest_258;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class MissingGeneticValue {
    static List<Integer>[] graph;

    public static void main(String[] args) {
        int[] parents=new int[]{-1,2,3,0,2,4,1};
        int[] nums=new int[]{2,3,4,5,6,7,8};
        graph=new ArrayList[parents.length];
        buildGraph(parents, nums, graph);
        MasterPrinter.printAdjacencyListGraph(graph);
        int start=0;
        int[] result=new int[parents.length];
        dfs(graph, start,nums, result);
        MasterPrinter.printArray(result);
    }

    private static TreeSet<Integer> dfs(List<Integer>[] graph, int root, int[] nums, int[] result) {
        if(graph.length<=root) return null;
        if(graph[root].size()==0){
            result[root]=(nums[root]!=1)?1:nums[root]+1;
            TreeSet<Integer> set=new TreeSet<>();
            set.add(nums[root]);
            return set;
        }
        TreeSet<Integer> set=new TreeSet<>();

        for(int i=0;i<graph[root].size();i++){
            Integer child=graph[root].get(i);
            TreeSet<Integer> temp=dfs(graph,child,nums,result);
            set.addAll(temp);
            set.add(nums[child]);
        }
        set.add(nums[root]);
        result[root]=findMissing(set);
        return set;
    }

    private static int findMissing(TreeSet<Integer> set) {
        if(set.first()>1)return 1;
        int looking=1;
        for(Integer data:set){
            System.out.println(data);
            if(data==looking) {
                looking+=1;
            }else
                return looking;
        }
        return looking;
    }

    private static void buildGraph(int[] parents, int[] nums, List<Integer>[] graph) {

        for (int i = 0; i < parents.length; i++) {
            graph[i]=new ArrayList<>();
        }

        for (int node = 1; node < parents.length ; node++) {
            int parent=parents[node];
            graph[parent].add(node);
        }
    }

}

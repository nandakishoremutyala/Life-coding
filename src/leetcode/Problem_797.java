package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 

Constraints:

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
All the elements of graph[i] are unique.
The input graph is guaranteed to be a DAG.
*/

class Problem_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();
        
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            g.add(new ArrayList<>());
        }
        
        for(int i=0;i<graph.length;i++ ){
            int[] childs= graph[i];
            for(int c:childs){
                g.get(i).add(c);
            }
        }
        List<Integer> start=new ArrayList<Integer>();
        start.add(0);
        
        dfs(g, 0,result, start);
        return result;
        
    }
    
    private void dfs(List<List<Integer>> g, int src,List<List<Integer>> result, List<Integer> temp){
        System.out.println("src: "+src);
        if(src==g.size()-1){
            ArrayList<Integer> r=new ArrayList<>(temp);
            //r.addAll(temp);
            result.add(r);
        }
        
        for(int c:g.get(src)){
            temp.add(c);
            dfs(g,c,result,temp);
            temp.remove(temp.size()-1);
        }
        
    }
}

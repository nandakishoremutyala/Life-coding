package leetcode.contests.contest_240;

import java.util.ArrayList;
import java.util.List;

public class LargestColorInDirectedGraph {
    class ColorNode{
        char c;
        int id;
        List<ColorNode> list;
        ColorNode(char c, int id){
            this.list=new ArrayList<>();
            this.c=c;
            this.id=id;
        }
    }
    ArrayList<ColorNode>[] graph;
    void buildGraph(String colors, int[][] edges){
        graph= new ArrayList[colors.length()];
        for(int[] e:edges){
            int start=e[0];
            int end=e[1];
            if(graph[start]==null){
                graph[start]=new ArrayList<>();
            }
            graph[start].add(new ColorNode(colors.charAt(start),start));
        }
    }
}

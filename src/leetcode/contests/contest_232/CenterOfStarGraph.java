package leetcode.contests.contest_232;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CenterOfStarGraph {
    CenterOfStarGraph centerOfStarGraph;
    @BeforeEach
    public void init(){
        centerOfStarGraph=new CenterOfStarGraph();
    }
    @Test
    public void firstTest(){
        int res=centerOfStarGraph.findCenter(new int[][]{
                {1,2},{2,3},{4,2}
        });
        System.out.println(res);
    }

    public int findCenter(int[][] edges) {
        int[] candidate=edges[0];
        int a=candidate[0];
        int b=candidate[1];
        int res=-1;
        for(int i=1;i<edges.length;i++){
            int[] e=edges[i];
            int x=e[0];
            int y=e[1];
            if(x==a || y==a){
                res=a;
                break;
            }
            if(x==b || y==b) {
                res = b;
                break;
            }
        }
        return res;

    }
}

package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaintHouse {
    PaintHouse paintHouse;
    @BeforeEach
    public void init(){
        paintHouse=new PaintHouse();
    }
    @Test
    public void firstTest(){
        int res= paintHouse.minCost(new int[][]{
                {17,2,17},
                {16,16,5},
                {14,3,19}
        });
        System.out.println(res);
    }

    public int minCost(int[][] costs) {
        int n=costs.length;
        int k=3;
        int[][] nCost=new int[costs.length][costs[0].length];

        for (int i = 0; i <k ; i++) {
            nCost[0][i]=costs[0][i];
        }
        for(int house=1;house<n;house++){
            for(int color=0;color<k;color++){
                nCost[house][color]= costs[house][color]+findMin(nCost,house-1,color);
            }
        }

        int min=Integer.MAX_VALUE;

        for (int c = 0; c <k ; c++) {
            min=Math.min(nCost[n-1][c],min);
        }
        return min;
    }

    private int findMin(int[][] costs,int house, int color){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<costs[house].length;i++){
            if(i==color) continue;
            min=Math.min(min,costs[house][i]);
        }
        return min;
    }

    private void print(int[][] costs){
        for(int i=0;i<costs.length;i++){
            for(int j=0;j<costs[0].length;j++){
                System.out.print(costs[i][j]+"-");
            }
        }
        System.out.println("");
    }
}

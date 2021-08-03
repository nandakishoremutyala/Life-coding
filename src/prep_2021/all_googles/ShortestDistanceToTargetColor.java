package prep_2021.all_googles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToTargetColor {
    ShortestDistanceToTargetColor shortestDistanceToTargetColor;

    @BeforeEach
    public void init() {
        shortestDistanceToTargetColor = new ShortestDistanceToTargetColor();
    }

    @Test
    public void firstTest() {
        shortestDistanceToTargetColor.shortestDistanceColor(
                new int[]{1,1,2,1,3,2,2,3,3},
                new int[][]{
                        {1,3},{2,2},{6,1}
                }
        );
    }

    @Test
    public void secondTest() {
        shortestDistanceToTargetColor.shortestDistanceColor(
                new int[]{1,2},
                new int[][]{
                        {0,3}
                }
        );
    }

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        int[][] tempLeft = new int[n][3];
        int[][] tempRight = new int[n][3];

        for (int i = 0; i < n; i++) {
            tempLeft[i] = new int[]{-1, -1, -1};
            tempRight[i] = new int[]{-1, -1, -1};
        }
        updatefromLeft(colors, n, tempLeft);
        updateFromRight(colors, n, tempRight);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] q=queries[i];
            int color=q[1]-1;
            int index=q[0];
            int l=tempLeft[index][color];
            int r=tempRight[index][color];
            int rr=-1;
            if(l!=-1 && r!=-1)
                rr=Math.min(l,r);
            else if(l==-1 || r==-1)
                rr=Math.max(l,r);

            result.add(i,rr);
        }
        return result;
    }

    private void updatefromLeft(int[] colors, int n, int[][] tempLeft) {
        for (int i = 0; i < n; i++) {
            int val = colors[i]-1;
            int[] t;
            if (i == 0) {
                t = new int[]{-1, -1, -1};
                t[val] = 0;
                tempLeft[i] = t;
            } else {
                int[] tmp = tempLeft[i - 1];
                int c1=tmp[0];
                int c2=tmp[1];
                int c3=tmp[2];
                if (c1 != -1) {
                    c1+= 1;
                }
                if (c2 != -1) {
                    c2+=1;
                }
                if (c3 != -1) {
                    c3 += 1;
                }
                if(val==0){
                    c1=0;
                }else if(val==1){
                    c2=0;
                }else{
                    c3=0;
                }
                tempLeft[i] = new int[]{c1,c2,c3};
            }
        }
    }

    private void updateFromRight(int[] colors, int n, int[][] tempRight) {
        for (int i = n-1; i >=0; i--) {
            int val = colors[i]-1;
            int[] t;
            if (i == n-1) {
                t = new int[]{-1, -1, -1};
                t[val] = 0;
                tempRight[i] = t;
            } else {
                int[] tmp = tempRight[i + 1];
                int c1=tmp[0];
                int c2=tmp[1];
                int c3=tmp[2];
                if (c1 != -1) {
                    c1+= 1;
                }
                if (c2 != -1) {
                    c2+=1;
                }
                if (c3 != -1) {
                    c3 += 1;
                }
                if(val==0){
                    c1=0;
                }else if(val==1){
                    c2=0;
                }else{
                    c3=0;
                }
                tempRight[i] = new int[]{c1,c2,c3};
            }
        }
    }
}

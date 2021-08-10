package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxValueOfEquation {

    MaxValueOfEquation maxValueOfEquation;
    @BeforeEach
    public void init(){
        maxValueOfEquation=new MaxValueOfEquation();
    }
    @Test
    public void firstTest(){
        maxValueOfEquation.findMaxValueOfEquation(new int[][]{
                {1,3},{2,0},{5,10},{6,-10}
        },1);
    }
    public int findMaxValueOfEquation(int[][] points, int k) {
        int end;
        int max=Integer.MIN_VALUE;
        end=1;
        for(int i=0;i<points.length-1;i++){
            int[] point=points[i];
            if(end<=i) end=i+1;
            while(end<points.length && Math.abs(point[0]-points[end][0])<=k){
                int val=points[end][1]+point[1]+Math.abs(point[0]-points[end][0]);
                max=Math.max(val,max);
                end++;
            }
        }
        return max;
    }
}

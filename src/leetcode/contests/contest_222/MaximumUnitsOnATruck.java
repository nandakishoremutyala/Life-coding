package leetcode.contests.contest_222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaximumUnitsOnATruck {
    MaximumUnitsOnATruck maximumUnitsOnATruck;
    @BeforeEach
    public void init(){
        maximumUnitsOnATruck=new MaximumUnitsOnATruck();
    }
    @Test
    public void firstTest(){
        int val= maximumUnitsOnATruck.maximumUnits(new int[][]{{1,3},{2,2},{3,1}},4);
        Assertions.assertEquals(8,val);
    }

    @Test
    public void secondTest(){
        int val= maximumUnitsOnATruck.maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}},10);
        Assertions.assertEquals(91,val);
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[1]));
        Collections.reverse(Arrays.asList(boxTypes));
        int max=0;
        for(int[] x:boxTypes){
            int box=x[0];
            int units=x[1];
            if(box<=truckSize){
                max+=(box*units);
                truckSize-=box;
            }else{
                max+=(truckSize*units);
                truckSize=0;
            }
        }
        return max;
    }
}

package leetcode.contests.contest_229;

import java.util.HashSet;
import java.util.Set;

public class MinOperationToMoveBoxes {
    public int[] minOperations(String boxes) {

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < boxes.length(); i++) {
            if(boxes.charAt(i)=='1')
                set.add(i);
        }

        int[] result=new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int min=0;
            for(Integer num:set){
                if(num!=i){
                    min+=Math.abs(i-num);
                }
            }
            result[i]=min;
        }
        return result;
    }
}

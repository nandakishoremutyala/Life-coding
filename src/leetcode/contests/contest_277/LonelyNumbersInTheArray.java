package leetcode.contests.contest_277;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyNumbersInTheArray {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> result=new ArrayList<>();

        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.compute(num,(k,v)->v==null?1:v+1);
        }
        for(int num:nums){
            if(map.get(num)>1)
                continue;
            if(!map.containsKey(num-1) && !map.containsKey(num+1)){
                result.add(num);
            }
        }
        return result;
    }
}

package leetcode.contests.contest_217;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MinMovesToMakeArrayComplementary {
    MinMovesToMakeArrayComplementary minMovesToMakeArrayComplementary;

    @BeforeEach
    public void init() {
        minMovesToMakeArrayComplementary = new MinMovesToMakeArrayComplementary();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{1, 2,4, 3};
        int limit = 4;
        int res = minMovesToMakeArrayComplementary.minMoves(input, limit);
        Assertions.assertEquals(1,res);
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{37,2,9,49,58,57,48,17};
        int limit = 58;
        int res = minMovesToMakeArrayComplementary.minMoves(input, limit);
        Assertions.assertEquals(1,res);
    }

    public int minMoves(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            int sum = nums[i] + nums[len - i - 1];
            map.compute(sum, (k, v) -> v == null ? 1 : v + 1);
        }

        LinkedHashMap<Integer,Integer> sortedMap=map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);
        int size=sortedMap.size();
        Iterator<Map.Entry<Integer,Integer>> it=sortedMap.entrySet().iterator();
        while (size>1){
           it.next();
           size--;
        }
        int target=it.next().getKey();
        int change=0;
        for (int i = 0; i < len / 2; i++) {
            int sum = nums[i] + nums[len - i - 1];
            if(sum!=target){
                int x=nums[i];
                int y=nums[len-i-1];
                if((x+y)!=target){
                    if(x==target && y==target){
                        change+=2;
                    }else if((Math.max(x,y)+limit)>=target){
                        change+=1;
                    }else{
                        change+=2;
                    }
                }
            }

        }
        return change;
    }
}

package leetcode.contests.contest_222;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountGoodMeals {
    CountGoodMeals countGoodMeals;

    @BeforeEach
    public void init() {
        countGoodMeals = new CountGoodMeals();
    }

    @Test
    public void firstTest() {
        int res = countGoodMeals.countPairs(new int[]{1, 1, 1, 3, 3, 3, 7});
        System.out.println(res);
    }

    public int countPairs(int[] deliciousness) {
        Map<Integer,Integer> map=new HashMap<>();
        int answer=0,MOD=1000000007;
        for(int num:deliciousness){
            int sum=1;
            for (int i = 0; i <22 ; i++) {
                if(num<=sum && map.containsKey((sum-num))){
                    answer+=map.get(sum-num);
                    answer %= MOD;
                }
                sum=sum*2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return answer;
    }

}

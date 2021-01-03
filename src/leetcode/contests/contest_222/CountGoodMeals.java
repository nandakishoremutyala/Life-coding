package leetcode.contests.contest_222;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountGoodMeals {
    CountGoodMeals countGoodMeals;
    @BeforeEach
    public void init(){
        countGoodMeals=new CountGoodMeals();
    }
    @Test
    public void firstTest(){
        int res= countGoodMeals.countPairs(new int[]{1,1,1,3,3,3,7});
        System.out.println(res);
    }
    public int countPairs(int[] deliciousness) {
        int pairs = 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <deliciousness.length ; i++) {
            map.compute(deliciousness[i],(k,v)->v==null?1:v+1);
        }
        int[] set=new int[map.size()];
        int k=0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            set[k]=e.getKey();
            k++;
        }
        if(map.size()==1){
            if(map.get(set[0])>1){
                if(countSetBits(set[0]*2)==1){
                    pairs+=own(set[0],map);
                }
            }
        }
        for (int i = 0; i < set.length - 1; i++) {
            if(map.get(set[i])>1){
                if(countSetBits(set[i]*2)==1){
                    pairs+=own(set[i],map);
                }
            }
            for (int j = i + 1; j < set.length; j++) {
                int sum = set[i] + set[j];
                    if ((countSetBits(sum)) == 1) {
                        pairs += couple(set[i],set[j],map);
                    }
                }

            }
        return pairs;
        }

    private int couple(int i, int j, HashMap<Integer, Integer> map) {
        int x=map.get(i);
        int y=map.get(j);
        return x*y;
    }

    private int own(int i, HashMap<Integer, Integer> map) {
        int count=map.get(i)-1;
        return (count*(count+1))/2;
    }

    static int countSetBits(int n)
        {
            int count = 0;
            while (n > 0) {
                count += n & 1;
                n >>= 1;
            }
            return count;
        }
}

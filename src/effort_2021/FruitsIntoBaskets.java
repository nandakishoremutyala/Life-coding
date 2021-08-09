package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    FruitsIntoBaskets fruitsIntoBaskets;
    @BeforeEach
    public void init(){
        fruitsIntoBaskets=new FruitsIntoBaskets();
    }

    @Test
    public void firstTest(){
        fruitsIntoBaskets.totalFruit(new int[]{1,2,1});
    }
    @Test
    public void secondTest(){
        int res= fruitsIntoBaskets.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
        System.out.println(res);
    }

    public int totalFruit(int[] fruits) {

        Map<Integer,Integer> map=new HashMap<>();

        int start=0;
        int end=0;
        int maxLen=0;

        while(start<=end && end<fruits.length){
            int fruit=fruits[end];

            map.put(fruit,map.getOrDefault(fruit,0)+1);
            if(map.size()<=2)
                maxLen=Math.max(maxLen,(end-start+1));
            while(map.size()>2){
                int f=fruits[start];
                map.put(f,map.get(f)-1);
                if(map.get(f)==0)
                    map.remove(f);
                start++;
            }
            end++;
        }
        return maxLen;
    }
}

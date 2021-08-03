package prep_2021.all_googles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinctElements {
    SubArrayWithKDistinctElements subArrayWithKDistinctElements;
    @BeforeEach
    public void init(){
        subArrayWithKDistinctElements=new SubArrayWithKDistinctElements();
    }
    @Test
    public void firstTest(){
        int result= subArrayWithKDistinctElements.subarraysWithKDistinct(new int[]{1,2,1,2,3},2);
        System.out.println(result);
    }
    public int subarraysWithKDistinct(int[] A, int K) {
        int res=0;
        int start=0;
        int distinct=0;
        int prefix=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int right=0; right <A.length ; right++) {
            int rightNum = A[right];

            // 1. If this number does not exist, it is a distinct number
            if(!map.containsKey(rightNum) || map.get(rightNum)==0){
                distinct++;
            }

            // 2. increase the counter
            map.put(rightNum,map.getOrDefault(rightNum,0)+1);

            // 3. now reduce the distinct, but we have to keep moving the start point until distinct will be really K
            if(distinct>K){
                int startNum=A[start];
                prefix=0;
                start++;
                map.put(startNum,map.get(startNum)-1);
                distinct--;
            }
            // 4. whenever right pointer meets a duplicate, we move left pointer right away
            while (map.get(A[start])>1){
                int startNum=A[start];
                start++;
                map.put(startNum,map.get(startNum)-1);
                prefix++;
            }
            if (distinct == K) {
                res += prefix + 1;
            }
        }

        return res;
    }
}

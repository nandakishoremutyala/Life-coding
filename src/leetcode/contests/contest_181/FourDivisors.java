package leetcode.contests.contest_181;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FourDivisors {
    FourDivisors fourDivisors;
    @BeforeEach
    public void init(){
        fourDivisors = new FourDivisors();
    }

    @Test
    public void firstTest(){
        int[] nums = new int[]{21,4,7};
        int result = fourDivisors.sumFourDivisors(nums);
        Assertions.assertEquals(32,result);
    }


    @Test
    public void secondTest(){
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        int result = fourDivisors.sumFourDivisors(nums);
        Assertions.assertEquals(45,result);
    }

    public int sumFourDivisors(int[] nums) {
        int sum=0;
        int max=4;
        HashMap<Integer,List<Integer>> cache = new HashMap<>();
        List<Integer> allDivisors= new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            List<Integer> divisors = new ArrayList<>();
            divisors.add(1);
            divisors.add(nums[i]);
            int num = nums[i];
            if(cache.containsKey(num)){
                if(cache.get(num).size()==max)
                    allDivisors.addAll(cache.get(num));
            }else{
                findDivisor(divisors,num);
                if(divisors.size()==max){
                    allDivisors.addAll(divisors);
                    cache.put(num,divisors);
                }
            }
        }
        sum= allDivisors.stream().mapToInt(i->i).sum();
        return sum;
    }

    private void findDivisor(List<Integer> divisors, int num) {
        for (int i = 2; i <=num/2 ; i++) {
            if(num%i==0)divisors.add(i);
            if(divisors.size()>4) break;
        }
    }
}

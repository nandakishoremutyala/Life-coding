package leetcode.contests.contest_280;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EvenOddSorting {
    EvenOddSorting evenOddSorting;
    @BeforeEach
    public void init(){
        evenOddSorting=new EvenOddSorting();
    }
    @Test
    public void firstTest(){
        evenOddSorting.sortEvenOdd(new int[]{4,1,2,3});
    }
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odd=new ArrayList<>();
        List<Integer> even=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                even.add(nums[i]);
            }else{
                odd.add(nums[i]);
            }
        }
        Collections.sort(even);
        Collections.sort(odd,Collections.reverseOrder());

        int i=0;int j=0;int index=0;
        while(i<odd.size() || j<even.size()){
            if(j<even.size()){
                nums[index++]=even.get(j);
                j++;
            }
            if(i<odd.size()){
                nums[index++]=odd.get(i);
                i++;
            }

        }
        return nums;
    }
}

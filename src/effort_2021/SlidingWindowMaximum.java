package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class SlidingWindowMaximum {
    SlidingWindowMaximum slidingWindowMaximum;

    @BeforeEach
    public void init() {
        slidingWindowMaximum = new SlidingWindowMaximum();
    }

    @Test
    public void firstTest() {
        int[] result= slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i:result)
            System.out.println(i);
    }

    @Test
    public void secondTest() {
        int[] result= slidingWindowMaximum.maxSlidingWindow(new int[]{1}, 1);
        for (int i:result)
            System.out.println(i);
    }

    @Test
    public void thirdTest() {
        int[] result= slidingWindowMaximum.maxSlidingWindow(new int[]{1,-1}, 1);
        for (int i:result)
            System.out.println(i);
    }

    @Test
    public void fourthTest() {
        int[] result= slidingWindowMaximum.maxSlidingWindow(new int[]{9,11}, 2);
        for (int i:result)
            System.out.println(i);
    }


    @Test
    public void fifthTest() {
        int[] result= slidingWindowMaximum.maxSlidingWindow(new int[]{4,-2}, 2);
        for (int i:result)
            System.out.println(i);
    }

    @Test
    public void sixthTest() {
        int[] result= slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        for (int i:result)
            System.out.println(i);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] result = new int[nums.length - k + 1];
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num,0)+1);
            if (i >= k-1) {
                Map.Entry<Integer, Integer> e = map.lastEntry();
                result[pos++] = e.getKey();
                int toBeDeleted = nums[i+1 - k];
                if(map.get(toBeDeleted)==1)
                    map.remove(toBeDeleted);
                else{
                    map.put(toBeDeleted,map.get(toBeDeleted)-1);
                }
            }
        }
        return result;
    }
}

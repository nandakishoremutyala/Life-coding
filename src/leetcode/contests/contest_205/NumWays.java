package leetcode.contests.contest_205;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class NumWays {
    public int numTriplets(int[] nums1, int[] nums2) {
        if(nums1.length==1||nums2.length==1)return 0;
        int result=0;
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();

        for (int i = 0; i <nums1.length ; i++) {
            int val=nums1[i]*nums1[i];
            map1.compute(val,(k,v)->v==null?1:v+1);
        }

        for (int i = 0; i <nums2.length ; i++) {
            int val=nums2[i]*nums2[i];
            map2.compute(val,(k,v)->v==null?1:v+1);
        }

        for (int j = 0; j < nums2.length-1; j++) {
            for (int k = j+1; k <nums2.length ; k++) {
                if(map1.containsKey(nums2[j]*nums2[k])){
                    result+=map1.get(nums2[j]*nums2[k]);
                }
            }
        }

        for (int j = 0; j < nums1.length-1; j++) {
            for (int k = j+1; k <nums1.length ; k++) {
                if(map2.containsKey(nums1[j]*nums1[k])){
                    result+=map2.get(nums1[j]*nums1[k]);
                }
            }
        }

        return result;
    }
}

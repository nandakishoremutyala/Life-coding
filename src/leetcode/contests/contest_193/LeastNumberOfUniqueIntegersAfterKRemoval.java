package leetcode.contests.contest_193;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemoval {
    LeastNumberOfUniqueIntegersAfterKRemoval l;
    @BeforeEach
    public void init(){
        l=new LeastNumberOfUniqueIntegersAfterKRemoval();
    }

    @Test
    public void firstTest(){
        int[] input=new int[]{5,5,4};
        int k=1;
        l.findLeastNumOfUniqueInts(input,k);
    }


    @Test
    public void secondTest(){
        int[] input=new int[]{4,3,1,1,3,3,2};
        int k=3;
        int res= l.findLeastNumOfUniqueInts(input,k);
        System.out.println(res);
    }

    @Test
    public void thirdTest(){
        int[] input=new int[]{2,4,1,8,3,5,1,3};
        int k=3;
        int res= l.findLeastNumOfUniqueInts(input,k);
        System.out.println(res);
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        TreeMap<Integer, ArrayList<Integer>> rMap=new TreeMap<>();
        for ( int i: arr) {
            map.compute(i,(key,val)->val==null?1:val+1);
        }

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int key=e.getKey();
            int val=e.getValue();
            rMap.compute(val,(kk,vv)->vv==null?new ArrayList<Integer>():vv).add(key);
        }

        while (k>0){
            int fkey= rMap.firstEntry().getKey();
            if(k<fkey) break;
            List<Integer> fValue=rMap.firstEntry().getValue();

            for(int n:fValue){
                if(fkey<=k){
                    map.remove(n);
                    k-=fkey;
                }
            }
            rMap.remove(fkey);
            if(k<fkey) break;
        }
        return map.size();
    }
}

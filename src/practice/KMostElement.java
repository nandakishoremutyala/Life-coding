package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class KMostElement {
    KMostElement kMostElement;
    @BeforeEach
    public void init(){
        kMostElement=new KMostElement();
    }
    @Test
    public void firstTest(){
        Set<Integer> sets= kMostElement.mostKFrequent(new int[]{1,1,2,2,3},2);
        Assertions.assertEquals(2,sets.size());
    }

    public Set<Integer> mostKFrequent(int[] in,int k){
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(2, (e1, e2) -> {
            if(e1.getValue()>e2.getValue())
                return -1;
            else if(e1.getValue()<e2.getValue())
                return 1;
            else return 0;
        });
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> sets=new HashSet<>();
        for (int i=0;i<in.length;i++){
            map.compute(in[i],(key,val)->val==null?1:val+1);
        }
        Iterator<Map.Entry<Integer, Integer>> it=map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,Integer> e=it.next();
            if(e.getValue()==k)
                sets.add(e.getKey());
            pq.add(e);
        }
        System.out.println(pq);
        for (int i = 0; i <k ; i++) {
            sets.add(pq.peek().getKey());
        }
        return sets;
    }
}

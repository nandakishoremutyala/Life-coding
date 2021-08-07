package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RearrangeStringKDistanceApart {
    RearrangeStringKDistanceApart rearrangeStringKDistanceApart;

    @BeforeEach
    public void init() {
        rearrangeStringKDistanceApart = new RearrangeStringKDistanceApart();
    }

    @Test
    public void firstTest() {
        rearrangeStringKDistanceApart.rearrangeString("aabbcc",3);
    }

    @Test
    public void secondTest() {
        String result =rearrangeStringKDistanceApart.rearrangeString("aaabc",3);
        System.out.println(result);
    }

    @Test
    public void thirdTest() {
        String result =rearrangeStringKDistanceApart.rearrangeString("aaadbbcc",2);
        System.out.println(result);
    }

    Map<Character, Integer> map = new HashMap<>();

    public String rearrangeString(String s, int k) {
        StringBuilder rearranged = new StringBuilder();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap= new PriorityQueue<>((e1,e2)-> e2.getValue()-e1.getValue());
        maxHeap.addAll(map.entrySet());


        Queue<Map.Entry<Character,Integer>> waitQueue = new LinkedList<>();

        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> curr=  maxHeap.poll();

            char c=curr.getKey();
            rearranged.append(c);
            curr.setValue(curr.getValue()-1);
            waitQueue.add(curr);


            if(waitQueue.size()<k){
                continue;
            }
            Map.Entry<Character,Integer> entry= waitQueue.poll();
            if(entry.getValue()>0){
                maxHeap.add(entry);
            }
        }
        return rearranged.length() == s.length() ? rearranged.toString() : "";
    }
}

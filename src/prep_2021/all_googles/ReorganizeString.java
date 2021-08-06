package prep_2021.all_googles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ReorganizeString {
    ReorganizeString reorganizeString;
    @BeforeEach
    public void init(){
        reorganizeString=new ReorganizeString();
    }
    @Test
    public void firstTest(){
        reorganizeString.reorganizeString("aab");
    }
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((p,q)-> q.getValue()-p.getValue());
        pq.addAll(map.entrySet());
        Queue<Map.Entry<Character,Integer>> queue = new LinkedList<>();

        StringBuilder rString = new StringBuilder();
        while (!pq.isEmpty()){
            Map.Entry<Character,Integer> e=pq.poll();
            rString.append(e.getKey());
            e.setValue(e.getValue()-1);
            queue.add(e);
            if(queue.size()<=1)
                continue;
            Map.Entry<Character,Integer> entry=queue.poll();
            if(entry.getValue()>0){
                pq.add(entry);
            }
        }
        return rString.toString().length()==s.length()?rString.toString():"";
    }
}

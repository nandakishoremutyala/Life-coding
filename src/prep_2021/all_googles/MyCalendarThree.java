package prep_2021.all_googles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

public class MyCalendarThree {
    TreeMap<Integer,Integer> map;
    MyCalendarThree myCalendarThree;
    public MyCalendarThree() {
        map=new TreeMap<>();
    }
    @BeforeEach
    public void init(){
        myCalendarThree=new MyCalendarThree();
    }

    @Test
    public void firstTest(){
        myCalendarThree.book(10,20);
    }

    public int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);

        int active=0;
        int k=0;

        for(int i:map.values()){
            k=Math.max(k,active+=i);
        }
        return k;
    }
}

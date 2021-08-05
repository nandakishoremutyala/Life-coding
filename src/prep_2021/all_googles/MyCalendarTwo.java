package prep_2021.all_googles;

import java.util.TreeMap;

public class MyCalendarTwo {
    TreeMap<Integer,Integer> map;

    public MyCalendarTwo() {
        map=new TreeMap<Integer,Integer>();
    }

    public boolean book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);

        int active=0;
        int total=0;
        for(int val:map.values()){
            total=Math.max(total,active+=val);
            if(total>=3)
            {
                map.put(start,map.getOrDefault(start,0)-1);
                map.put(end,map.getOrDefault(end,0)+1);
                return false;
            }
        }
        return true;
    }
}

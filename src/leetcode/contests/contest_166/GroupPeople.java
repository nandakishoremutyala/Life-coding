package leetcode.contests.contest_166;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.*;

public class GroupPeople {
    GroupPeople groupPeople;

    @BeforeEach
    public void init() {
        groupPeople = new GroupPeople();
    }

    @Test
    public void whenTwoGroupHasMaxPeople() {
        int[] input = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> result = groupPeople.groupThePeople(input);
        MasterPrinter.printList(result);
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        if (groupSizes.length == 0) return null;
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<groupSizes.length;i++) {
            int val=groupSizes[i];
            if(map.containsKey(val)){
                List<Integer> data=map.get(val);
                if(data.size()==val){
                    result.add(data);
                    map.remove(val);
                    map.compute(val,(k,v)->v==null?new ArrayList<Integer>():v).add(i);
                }else data.add(i);
            }else{
                map.compute(val,(k,v)->v==null?new ArrayList<Integer>():v).add(i);
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            if(entry.getValue()!=null)
                result.add(entry.getValue());
        }
        return result;
    }
}

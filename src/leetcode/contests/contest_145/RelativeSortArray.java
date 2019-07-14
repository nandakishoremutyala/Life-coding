package leetcode.contests.contest_145;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RelativeSortArray {
    RelativeSortArray mRelativeSortArray;

    @BeforeEach
    public void init() {
        mRelativeSortArray = new RelativeSortArray();
    }

    @Test
    public void firstTest() {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] actual = mRelativeSortArray.relativeSortArray(arr1, arr2);
        Assertions.assertArrayEquals(new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}, actual);

    }


    @Test
    public void secondTest() {
        int[] arr1 = new int[]{28,6,22,8,44,17};
        int[] arr2 = new int[]{22,28,8,6};
        int[] actual = mRelativeSortArray.relativeSortArray(arr1, arr2);
        Assertions.assertArrayEquals(new int[]{ 22,28,8,6,17,44}, actual);

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr1.length==0)return arr2;
        if(arr2.length==0) return arr1;
        int[] result = new int[arr1.length];
        LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], new ArrayList<>());
        }

        for (int i = 0; i < arr1.length; i++) {
            int data = arr1[i];
            if (map.containsKey(data))
                map.get(data).add(data);
            else {
                map.computeIfAbsent(data, val -> new ArrayList<>()).add(data);
            }
        }
        int start = 0;
        ArrayList<Integer> first=new ArrayList<>();
        ArrayList<Integer> second=new ArrayList<>();
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ArrayList<Integer>> element = it.next();
            ArrayList<Integer> list = element.getValue();
            if(start>=arr2.length){
                second.addAll(list);
            }else{
                first.addAll(list);
            }
            start++;
        }
        Collections.sort(second);

        first.addAll(second);
        int k=0;
        for (Integer i:first) {
            result[k++]=i;

        }

        return result;
    }
}

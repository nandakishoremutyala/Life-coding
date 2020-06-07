package leetcode.contests.contest_192;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KStrongestValueInArray {
    KStrongestValueInArray kStrongestValueInArray;

    @BeforeEach
    public void init() {
        kStrongestValueInArray = new KStrongestValueInArray();
    }

    @Test
    public void firstTest() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 2;
        int[] actual = kStrongestValueInArray.getStrongest(arr, k);
        MasterPrinter.printArray(actual);
    }

    @Test
    public void secondTest() {
        int[] arr = new int[]{1, 1, 3, 5, 5};
        int k = 2;
        int[] actual = kStrongestValueInArray.getStrongest(arr, k);
        MasterPrinter.printArray(actual);
    }

    @Test
    public void thirdTest() {
        int[] arr = new int[]{6,7,11,7,6,8};
        int k = 5;
        int[] actual = kStrongestValueInArray.getStrongest(arr, k);
        MasterPrinter.printArray(actual);
    }

    @Test
    public void fourthTest() {
        int[] arr = new int[]{6,-3,7,2,11};
        int k = 3;
        int[] actual = kStrongestValueInArray.getStrongest(arr, k);
        MasterPrinter.printArray(actual);
    }

    @Test
    public void fifthTest() {
        int[] arr = new int[]{-7,22,17,3};
        int k = 2;
        int[] actual = kStrongestValueInArray.getStrongest(arr, k);
        MasterPrinter.printArray(actual);
    }

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int median = 0;
        if (n % 2 != 0) {
            median = arr[n / 2];
        } else {
            median = ((arr[n / 2 - 1] + arr[n / 2])) / 2;
        }

        System.out.println(median);

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(arr[i] - median);
            map.compute(diff, (key, value) -> value == null ? new ArrayList<>() : value).add(arr[i]);
        }
        System.out.println(map);
        int[] res = new int[k];
        int it = 0;
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> itr = map.entrySet().iterator();


        while (it < res.length) {
            if (itr.hasNext()) {
                Map.Entry<Integer, ArrayList<Integer>> e = itr.next();
                List<Integer> data = e.getValue();
                Collections.sort(data,Collections.reverseOrder());
                for (int i = 0; i < data.size(); i++) {
                    if (it < k) {
                        res[it] = data.get(i);
                        it++;
                    }
                    else
                        break;
                }
                //map.remove(e.getKey());
            }
        }
        return res;
    }
}

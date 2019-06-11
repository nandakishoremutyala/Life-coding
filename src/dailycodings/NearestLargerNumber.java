package dailycodings;

import java.util.TreeMap;

public class NearestLargerNumber {
    public static void main(String[] args) {
        System.out.println(findNearestLargetNumer(new int[]{4, 1, 3, 5, 6}, 0));
    }

    private static int findNearestLargetNumer(int[] arr, int index) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int valAtIndex = arr[index];
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int key = map.higherKey(valAtIndex);
        return map.get(key);
    }
}

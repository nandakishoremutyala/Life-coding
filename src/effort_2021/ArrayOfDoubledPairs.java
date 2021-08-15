package effort_2021;


import java.util.Arrays;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {
    public static void main(String[] args) {

        ArrayOfDoubledPairs arrayOfDoubledPairs = new ArrayOfDoubledPairs();
       // arrayOfDoubledPairs.canReorderDoubled(new int[]{4, -2, 2, -4});
        arrayOfDoubledPairs.canReorderDoubled(new int[]{-33,0});
    }

    public boolean canReorderDoubled(int[] arr) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(arr);
        for (int num : arr) {
            if(!map.containsKey(num)) continue;
            int doubleNum = num * 2;
            int halfNum=Integer.MAX_VALUE;
            if(num%2==0)
                halfNum=num/2;

            if (map.containsKey(doubleNum)) {
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0)
                    map.remove(num);

                if(!map.containsKey(doubleNum)) return false;
                map.put(doubleNum, map.get(doubleNum) - 1);
                if (map.get(doubleNum) == 0)
                    map.remove(doubleNum);

            } else if(map.containsKey(halfNum)){
                if(halfNum!= Integer.MAX_VALUE){
                    map.put(num, map.get(num) - 1);
                    if (map.get(num) == 0)
                        map.remove(num);
                    if(!map.containsKey(halfNum)) return false;

                    map.put(halfNum, map.get(halfNum) - 1);
                    if (map.get(halfNum) == 0)
                        map.remove(halfNum);
                }
            }
        }
        if (map.isEmpty()) return true;
        return false;
    }
}

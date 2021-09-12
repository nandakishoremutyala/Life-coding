package leetcode.contests.contest_258;

import java.util.HashMap;
import java.util.Map;

public class InterchangeableRectangles {
    public static void main(String[] args) {
        InterchangeableRectangles interchangeableRectangles=new InterchangeableRectangles();
        long result= interchangeableRectangles.interchangeableRectangles(new int[][]{{4,8},{3,6},{10,20},{15,30}});
        System.out.println(result);
    }
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double,Integer> counter=new HashMap<>();
        long count=0L;
        for (int i = 0; i < rectangles.length; i++) {
            int[] rect=rectangles[i];
            double ratio = rect[0]/(double)rect[1];
            if(!counter.containsKey(ratio))
                counter.put(ratio,1);
            else{
                int val=counter.get(ratio);
                count+=val;
                counter.put(ratio,counter.get(ratio)+1);
            }
        }
        return count;
    }
}

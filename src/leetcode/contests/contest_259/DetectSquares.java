package leetcode.contests.contest_259;

import javafx.util.Pair;

import java.util.*;

public class DetectSquares {
    public static void main(String[] args) {
        DetectSquares detectingSquares=new DetectSquares();
        detectingSquares.add(new int[]{3,10});
        detectingSquares.add(new int[]{11,2});
        detectingSquares.add(new int[]{3,2});
        detectingSquares.count(new int[]{11, 10});
    }
    Map<Pair,Integer> counter;
    Set<int[]> set;
    public DetectSquares() {
        counter=new HashMap<>();
        set =new HashSet<>();
    }
    public void add(int[] point) {
        Pair pair=new Pair(point[0],point[1]);
        counter.put(pair,counter.getOrDefault(pair,0)+1);
        set.add(point);
    }

    public int count(int[] point) {
        int total=0;
        int px=point[0];
        int py=point[1];

        for(int[] p:set){
            if(p[0]==px || p[1]==py || Math.abs((px-p[0]))!=Math.abs(py-p[1])){
                continue;
            }
            else {
                System.out.println(px+","+p[1]);
                System.out.println(p[0]+","+py);
                total += counter.getOrDefault(new Pair(px, p[1]), 0) * counter.getOrDefault(new Pair(p[0], py), 0);
            }
        }
        return total;
    }
}

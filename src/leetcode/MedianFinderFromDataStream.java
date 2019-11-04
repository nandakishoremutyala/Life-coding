package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//[null,null,6.00000,null,8.00000,null,10.00000,null,6.00000,null,2.00000,null,4.00000,null,6.00000,null,5.50000,null,5.00000,null,2.50000,null,0.00000]

public class MedianFinderFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder=new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
    static class MedianFinder {

        /** initialize your data structure here. */
        List<Integer> list;
        public MedianFinder() {
            list=new ArrayList<Integer>();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            Collections.sort(list);
            int size=list.size();
            int mid=size/2;
            if(size%2==0){
                return (double) (list.get(mid)+list.get(mid-1))/2;
            }else{
                return list.get(mid);
            }
        }
    }
}

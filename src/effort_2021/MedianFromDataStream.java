package effort_2021;

import java.util.PriorityQueue;

public class MedianFromDataStream {

    public static void main(String[] args) {
        MedianFromDataStream medianFromDataStream=new MedianFromDataStream();
        medianFromDataStream.addNum(1);
        medianFromDataStream.addNum(2);
        System.out.println(medianFromDataStream.findMedian());
        medianFromDataStream.addNum(3);
        System.out.println(medianFromDataStream.findMedian());
    }
    /** initialize your data structure here. */
    PriorityQueue<Integer> lo;// max heap
    PriorityQueue<Integer> hi;
    public MedianFromDataStream() {
        lo=new PriorityQueue<Integer>((p,q)->q-p);
        hi=new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.peek());
        lo.poll();

        if(lo.size()<hi.size()){
            lo.add(hi.peek());
            hi.poll();
        }
    }

    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : ((double) lo.peek() + hi.peek()) /2;
    }
}

package leetcode.contests.contest_233;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfOrderInBacklog {
    NumberOfOrderInBacklog numberOfOrderInBacklog;
    class Order{
        int price,quantity,type;
        Order(int p, int q, int t){
            this.price=p;
            this.quantity=q;
            this.type=t;
        }
    }

    @BeforeEach
    public void init() {
        numberOfOrderInBacklog = new NumberOfOrderInBacklog();
    }

    @Test
    public void firstTest() {
        numberOfOrderInBacklog.getNumberOfBacklogOrders(new int[][]{
                {10,5,0},{15,2,1},{25,1,1},{30,4,0}
        });

    }

    public void getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyQ = new PriorityQueue<>(orders.length, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<int[]> sellQ = new PriorityQueue<>(orders.length);

        for (int[] order : orders) {
            if (order[2] == 0) {
                if (sellQ.isEmpty())
                    buyQ.add(order);
                else {
                    while (!sellQ.isEmpty() && sellQ.peek()[0] <= order[0]) {
                        int[] sPoll = sellQ.poll();
                        if (sPoll[1] - order[1] == 0) {
                            break;
                        }else if(sPoll[1] - order[1] > 0){
                            int rem=sPoll[1] - order[1];
                            int[] newOrder=new int[]{sPoll[0],rem,1};
                            sellQ.add(newOrder);
                            break;
                        }else{
                            int rem=order[1] - sPoll[1];
                            order=new int[]{order[0],rem,0};
                        }
                    }
                    buyQ.add(order);

                }
            }else{
                if (buyQ.isEmpty())
                    sellQ.add(order);
                else {
                    while (!buyQ.isEmpty() && buyQ.peek()[0] >= order[0]) {
                        int[] bPoll = buyQ.poll();
                        if (bPoll[1] - order[1] == 0) {
                            break;
                        }else if(bPoll[1] - order[1] > 0){
                            int rem=bPoll[1] - order[1];
                            int[] newOrder=new int[]{bPoll[0],rem,1};
                            buyQ.add(newOrder);
                            break;
                        }else{
                            int rem=order[1] - bPoll[1];
                            order=new int[]{order[0],rem,0};
                        }
                    }
                    sellQ.add(order);

                }
            }

        }
    }
}

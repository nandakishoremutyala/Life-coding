package leetcode.contests.contest_256;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinNumberOfWorkSession {
    MinNumberOfWorkSession minNumberOfWorkSession;

    @BeforeEach
    public void init(){
        minNumberOfWorkSession=new MinNumberOfWorkSession();
    }

    @Test
    public void firstTest(){
        int res= minNumberOfWorkSession.minSessions(new int[]{1,2,3},3);
        Assertions.assertEquals(res,2);
    }

    @Test
    public void secondTest(){
        int res= minNumberOfWorkSession.minSessions(new int[]{3,1,3,1,1},8);
        Assertions.assertEquals(res,2);
    }

    @Test
    public void thirdTest(){
        int res= minNumberOfWorkSession.minSessions(new int[]{1,2,3,4,5},15);
        Assertions.assertEquals(res,1);
    }

    @Test
    public void fourthTest(){
        int res= minNumberOfWorkSession.minSessions(new int[]{2,3,3,4,4,4,5,6,7,10},
        12);
        Assertions.assertEquals(res,4);
    }
    @Test
    public void fifthTest(){
        int res= minNumberOfWorkSession.minSessions(new int[]{7,4,3,8,10},15);
        Assertions.assertEquals(res,3);
    }
    public int minSessions(int[] tasks, int sessionTime) {
        PriorityQueue<Integer> maxQ=new PriorityQueue<>((a,b)->b-a);
        for(int num:tasks){
            maxQ.add(num);
        }
        int total=0;
        int count=0;
        while (!maxQ.isEmpty()){
            int cur=maxQ.poll();
            if(total+cur>sessionTime){
                List<Integer> list=new ArrayList<>();
                list.add(cur);
                while(!maxQ.isEmpty()){
                    int temp=maxQ.poll();
                    if(total+temp>sessionTime){
                        list.add(temp);
                    }else{
                        total+=temp;
                    }
                }
                maxQ.addAll(list);
                count++;

                total=0;
            }else if(total+cur==sessionTime){
                count++;
                total=0;
            }else{
                total+=cur;
            }
        }
        if(total>0) count+=1;
        return count;
    }
}

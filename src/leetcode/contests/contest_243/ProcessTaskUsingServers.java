package leetcode.contests.contest_243;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ProcessTaskUsingServers {
    ProcessTaskUsingServers processTaskUsingServers;
    @BeforeEach
    public void init(){
        processTaskUsingServers=new ProcessTaskUsingServers();
    }
    @Test
    public void firstTest(){
        processTaskUsingServers.assignTasks(new int[]{3,3,2},new int[]{1,2,3,2,1,2});
    }
    static class Server{
        int pos;
        int weight;

        public Server(int pos, int weight) {
            this.pos = pos;
            this.weight = weight;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        HashMap<String,Integer> busyServer=new HashMap<>();
        PriorityQueue<Server> pq=new PriorityQueue<Server>(servers.length, Comparator.comparingInt(s -> s.weight));
        int index=0;
        for (int i:servers) {
            pq.add(new Server(index++,i));
        }

        int[] ans=new int[tasks.length];
        for (int task = 0; task <tasks.length ; task++) {
            int head=0;
            while (head<servers.length){
                Server s=pq.poll();
                String id=s.pos +"-"+String.valueOf(s.weight);
                if(!busyServer.containsKey(id)){
                    busyServer.put(id,task+tasks[task]);
                    ans[task]=s.pos;
                    break;
                }else{
                    int endTime=busyServer.get(id);
                    if(endTime<=task){
                        busyServer.put(id,task+tasks[task]);
                        ans[task]=s.pos;
                        break;
                    }
                }
                head++;
            }
        }

        return null;
    }
}

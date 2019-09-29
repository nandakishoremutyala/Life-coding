package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LastStoneWeight {
    public static void main(String[] args) {
         int result=getSmallestStone();
        System.out.println(result);
    }

    private static int getSmallestStone() {
        int[] stones=new int[]{2,7,4,1,8,1};
        ArrayList<Integer> pq=new ArrayList<>();

        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }

        while(!pq.isEmpty()){
            int posX=getRandom(pq.size());
            int x = pq.get(posX);
            pq.remove(posX);
            int y;
            int posY;
            if(pq.size()==0)
                return x;
            else{
                posY=getRandom(pq.size());
                y=pq.get(posY);
                pq.remove(posY);
            }
            if(x!=y){
                pq.add(Math.abs(y-x));
            }
        }
        return 0;
    }

    public static int getRandom(int range){
        Random random=new Random();
        return random.nextInt(range);
    }
}

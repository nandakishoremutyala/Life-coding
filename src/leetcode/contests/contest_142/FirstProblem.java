package leetcode.contests.contest_142;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class FirstProblem {
    FirstProblem firstProblem;

    @BeforeEach
    public void init() {
        firstProblem = new FirstProblem();
    }

    @Test
    public void firstTest(){
        firstProblem.sampleStats(new int[]{0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }

    @Test
    public void secondTest(){
        double[] result= firstProblem.sampleStats(new int[]{
                0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
        });
        Assertions.assertArrayEquals(new double[]{1.0,4.0,2.18182,2.0,1.0},result);

    }
    public double[] sampleStats(int[] count) {
        double min=0;
        int minPosition=0;
        while (count[minPosition]==0){
            minPosition++;
        }
        min=(double) minPosition;
        System.out.println("Min: "+ min);

        double max=0;
        int maxPosition=255;
        while (count[maxPosition]==0){
            maxPosition--;
        }
        max=(double) maxPosition;
        System.out.println("Min: "+ max);



        double mean =0.0;

        ArrayList<Integer> elements=new ArrayList<>();
        double mod=count[0];
        double modResult=0;
        for (int i = minPosition; i <=maxPosition ; i++) {
            if(count[i]!=0){
                int rep=count[i];
                for (int j = 0; j <rep ; j++) {
                    elements.add(i);
                }
            }
            if(count[i]>=mod){
                mod=count[i];
                modResult=i;
            }

        }


        Collections.sort(elements);

        double sum=elements.stream().mapToDouble(a -> (double)a).sum();
        mean=sum/elements.size();

        double median=0;
        int size=elements.size();
        if(elements.size()%2!=0){
            median=elements.get(size/2);
        }else {
            int half=size/2;
            int x=elements.get(half);
            int y=elements.get(half-1);
            median=(double) (x+y)/2;
        }

        return new double[]{Math.round (min * 100000.0) / 100000.0,
                Math.round (max * 100000.0) / 100000.0,
                Math.round (mean * 100000.0) / 100000.0,
                Math.round (median * 100000.0) / 100000.0,
                Math.round (modResult * 100000.0) / 100000.0};

    }
}

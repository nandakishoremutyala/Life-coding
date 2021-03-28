package leetcode.contests.contest_232;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumAveragePassRatio {
    MaximumAveragePassRatio maximumAveragePassRatio;
    @BeforeEach
    public void init(){
        maximumAveragePassRatio=new MaximumAveragePassRatio();
    }

    @Test
    public void firstTest(){
        double res=maximumAveragePassRatio.maxAverageRatio(new int[][]{
                {1,2},{2,2},{3,5}
        },2);
        System.out.println(res);
    }

        public double maxAverageRatio(int[][] classes, int extraStudents) {
            double[] avg=new double[classes.length];
            double total=0;
            for(int i=0;i<classes.length;i++){
                avg[i]=(double)classes[i][0]/(double) classes[i][1];
                total+=avg[i];
            }

            double newTotal=0;
            double res=total/classes.length;
            for(int i=0;i<classes.length;i++){
                newTotal=total-avg[i];
                int x=classes[i][0]+extraStudents;
                int y=classes[i][1]+extraStudents;
                double average=(double) x/(double) y;
                newTotal+=average;
                res=Math.max(res,(double) newTotal/(double) classes.length);
            }
            return res;
    };
}

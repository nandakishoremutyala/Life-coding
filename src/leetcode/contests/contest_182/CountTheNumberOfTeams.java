package leetcode.contests.contest_182;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.ArrayList;
import java.util.List;

public class CountTheNumberOfTeams {
    CountTheNumberOfTeams countTheNumberOfTeams;
    @BeforeEach
    public void init(){
        countTheNumberOfTeams=new CountTheNumberOfTeams();
    }
    @Test
    public void firstTest(){
        int[] input= new int[]{2,5,3,4,1};
        int actual =countTheNumberOfTeams.numTeams(input);
        Assertions.assertEquals(3,actual);
    }
    public int numTeams(int[] rating) {
        int[] ascending =new int[rating.length];
        int[] descending =new int[rating.length];

        for (int i = rating.length-1; i>=0 ; i--) {
            if(i==rating.length-1){
               /* List<Integer> as = new ArrayList<>();
                as.add(rating.length-1,0);*/
                ascending[i]=1;

                /*List<Integer> de = new ArrayList<>();
                de.add(rating.length-1,0);*/
                descending[i]=1;
            }else{
                int big= findBig(rating, i);
                int small= findSmall(rating, i);

                if(big!=-1){
                    int total = ascending[big]+1;
                    ascending[i]=total;
                }else{
                    ascending[i]=1;
                }

                if(small!=-1){
                    int total = descending[small]+1;
                    descending[i]=total;
                }else{
                    descending[i]=1;
                }
            }



        }
        MasterPrinter.printArray(ascending);
        MasterPrinter.printArray(descending);

        return 0;
    }

    private int findBig(int[] rating, int start) {
        int num =rating[start];
        for(int i=start+1;i<rating.length;i++){
            if(rating[i]>num) return i;
        }
        return -1;
    }

    private int findSmall(int[] rating, int start) {
        int num =rating[start];
        start+=1;
        int val=-1;
        for(int i=start;i<rating.length;i++){
            if(rating[i]<num) {
                val=i;
                break;
            }
        }
        return val;
    }
}

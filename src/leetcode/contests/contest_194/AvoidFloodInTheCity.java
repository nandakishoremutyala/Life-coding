package leetcode.contests.contest_194;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class AvoidFloodInTheCity {
    AvoidFloodInTheCity avoidFloodInTheCity;
    @BeforeEach
    public void init(){
        avoidFloodInTheCity=new AvoidFloodInTheCity();
    }

    @Test
    public void firstTest(){
       int[] result=  avoidFloodInTheCity.avoidFlood(new int[]{1,2,3,4});
        MasterPrinter.printArray(result);

    }

    @Test
    public void secondTest(){
        int[] result=  avoidFloodInTheCity.avoidFlood(new int[]{1,2,0,0,2,1});
        MasterPrinter.printArray(result);

    }


    public int[] avoidFlood(int[] rains) {

        int max = Arrays.stream(rains)
                .max()
                .getAsInt();
        max=Math.max(max,rains.length);
        TreeSet<Integer> full=new TreeSet<>();
        ArrayList<Integer> lakes=new ArrayList<>(max);
        for (int i = 0; i <max ; i++) {
            lakes.add(i,0);
        }

        for (int i = 0; i <rains.length ; i++) {
            int rain=rains[i];
            if(rain>0){ //it will be rain today over the lake number 'rain'
                lakes.set(rain-1,-1); //full
                full.add(rain);
            }else if(rain==0){ // make a lake empty
                // what is next day? if it rains empty that lake, if that lake is empty go ahead with full lake
                if(i+1<rains.length){
                    int nextDay=rains[i+1];
                    if(nextDay>0){
                        if(full.contains(nextDay)){
                            lakes.set(nextDay,0);
                            full.remove(nextDay);
                        }else{
                            int x= full.first();
                            lakes.set(x,0);
                        }
                    }else{
                        int x= full.first();
                        lakes.set(x-1,x);

                        full.remove(x);
                    }
                }
            }

        }

        int[] result=new int[lakes.size()];
        for (int i = 0; i <lakes.size() ; i++) {
            result[i]=lakes.get(i);
        }
        return result;
    }
}

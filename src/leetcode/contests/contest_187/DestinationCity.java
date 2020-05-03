package leetcode.contests.contest_187;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.*;

public class DestinationCity {
    DestinationCity destinationCity;

    @BeforeEach
    public void init(){
        destinationCity=new DestinationCity();
    }

    @Test
    public void firstTest(){
        List<List<String>> paths=new ArrayList<>();
        paths.add(Arrays.asList("London","New York"));
        paths.add(Arrays.asList("New York", "Lima"));
        paths.add(Arrays.asList("Lima","Sao Paulo"));

        String dest= destinationCity.destCity(paths);
        Assertions.assertEquals(dest,"Sao Paulo");
    }

    public String destCity(List<List<String>> paths) {
        Map<String,List<String>> cityMap=new HashMap<>();
        for(List<String> cities:paths){
            String a = cities.get(0);
            String b= cities.get(1);

            cityMap.compute(a,(k,v)->v==null?new ArrayList<String>():v).add(b);
            cityMap.compute(b,(k,v)->v==null?new ArrayList<String>():v);
        }

        System.out.println(cityMap);

        String result="";
        for(Map.Entry<String,List<String>> e:cityMap.entrySet()){
            if(e.getValue().size()==0) {
                result=e.getKey();
                break;
            }
        }

        return result;
    }
}

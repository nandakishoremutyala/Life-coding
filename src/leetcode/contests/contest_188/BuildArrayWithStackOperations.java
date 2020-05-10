package leetcode.contests.contest_188;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOperations {
    BuildArrayWithStackOperations buildArrayWithStackOperations;
    @BeforeEach
    public void init(){
        buildArrayWithStackOperations=new BuildArrayWithStackOperations();
    }
    @Test
    public void firstTest(){
        List<String> result = buildArrayWithStackOperations.buildArray(new int[]{1,3},3);
        MasterPrinter.printList(result);
    }

    @Test
    public void secondTest(){
        List<String> result = buildArrayWithStackOperations.buildArray(new int[]{1,2,3},3);
        MasterPrinter.printList(result);
    }

    @Test
    public void thirdTest(){
        List<String> result = buildArrayWithStackOperations.buildArray(new int[]{1,2},4);
        MasterPrinter.printList(result);
    }

    @Test
    public void fourthTest(){
        List<String> result = buildArrayWithStackOperations.buildArray(new int[]{2,3,4},4);
        MasterPrinter.printList(result);
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> result=new ArrayList<>();
        int p=0;
        for (int i = 1; i <=n ; i++) {
            if(target[p]==i){
                result.add("Push");
                p++;
            }else{
                result.add("Push");
                result.add("Pop");
            }
            if(p==target.length) break;
        }

        return result;
    }
}

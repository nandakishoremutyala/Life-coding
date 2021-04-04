package leetcode.contests.contest_235;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.*;

public class FindingUsersActiveMinutes {
    FindingUsersActiveMinutes findingUsersActiveMinutes;
    @BeforeEach
    public void init(){
        findingUsersActiveMinutes=new FindingUsersActiveMinutes();
    }
    @Test
    public void firstTest(){
        findingUsersActiveMinutes.findingUsersActiveMinutes(new int[][]{
                {1,1},{2,2},{2,3}
        },4);
    }

    @Test
    public void secondTest(){
        findingUsersActiveMinutes.findingUsersActiveMinutes(new int[][]{
                {0,5},{1,2},{0,2},{0,5},{1,3}
        },4);
    }
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> minToUserMap = new HashMap<>();
        HashMap<Integer, Integer> userToUAM = new HashMap<>();
        for (int[] log : logs) {
            int uId = log[0];
            int min = log[1];
            minToUserMap.compute(min,(key,v)->v==null?new HashSet<>():v).add(uId);
        }

        for(Map.Entry<Integer,HashSet<Integer>> e:minToUserMap.entrySet()){
            //int min=e.getKey();
            HashSet<Integer> set=e.getValue();

            for(int d:set){
                userToUAM.compute(d,(kk,vv)->vv==null?1:vv+1);
            }
        }
        System.out.println(minToUserMap);
        System.out.println(userToUAM);
        int[] res=new int[k];
        Arrays.fill(res,0);
        for(Map.Entry<Integer,Integer>e:userToUAM.entrySet()){
            //int userId=e.getKey();
            int uam=e.getValue();
            res[uam-1]+=1;
        }
        MasterPrinter.printArray(res);
        return res;
    }
}

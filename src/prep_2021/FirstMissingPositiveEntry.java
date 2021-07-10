package prep_2021;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FirstMissingPositiveEntry {
    public static void main(String[] args) {
        System.out.println(positiveEntry(new int[]{3,5,4,-1,5,1,-1}));
    }
    static int positiveEntry(int[] nums){
        Set<Integer> set=new HashSet<Integer>();
        int lookingFor=Integer.MAX_VALUE;
        int max=-1;
        for(int n:nums){
            if(n>=0)
                lookingFor=Math.min(n,lookingFor);
            max=Math.max(max,n);
        }
        lookingFor+=1;
        for(int n:nums){
            if(n==lookingFor){
                lookingFor+=1;
            }
            else{
                set.add(n);
            }
        }

        while(lookingFor<=max){
            if(set.contains(lookingFor))
                lookingFor+=1;
            else
                break;
        }
        return lookingFor;
    }
}

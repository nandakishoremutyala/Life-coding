package leetcode.contests.contest_197;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubStringsWithOnes {


    public static void main(String[] args) {
        NumberOfSubStringsWithOnes nosw= new NumberOfSubStringsWithOnes();
        int result = nosw.numSub("101");
        System.out.println(result);

        total=0;

        int res = nosw.numSub("0110111");
        System.out.println(res);
    }

/*


    totalNumberOf1s-targetLength+1;
    try for each length;

    1->6
    2-> 6-2+1=5
    3-> 6-3+1=4
    4-> 2+1=3
    5=1+1=2
    6-> 1*/


    static int total=0;
    int MOD=1000000007;
    public int numSub(String s) {
        int total=0;
        int count=0;
        for(int j=0;j<s.length();j++){
            char c=s.charAt(j);
            if(c=='0'){
                if(count!=0){
                    long temp=(count*(count+1))/2;
                    total+=temp%MOD;
                }
                count=0;
            }else if(c=='1' && j==s.length()-1){
                count++;
                long temp=(count*(count+1))/2;
                total+=temp%MOD;
            }
            else if(c=='1'){
                count+=1;
            }

        }
        total=total%MOD;
        return total;
    }
}

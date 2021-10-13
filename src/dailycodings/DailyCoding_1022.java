package dailycodings;

import java.util.Arrays;
/**
 * Problem statement:
 *
 *
 * */
public class DailyCoding_1022 {
    public static void main(String[] args) {
        int arr[] = {6, 1, 3, 3, 3, 6, 6};
        int res = findMissingNumber(arr);
        System.out.println(res);
        System.out.println(findMissingNumber(new int[]{13, 19, 13, 13}));
        System.out.println(findMissingNumber(new int[]{11, 5, 5, 5, 6, 11, 11}));
    }

    private static int findMissingNumber(int[] arr) {
        int[] bitCount=new int[31];
        for(int  num:arr){
            int placeHolder=1<< 31;
            int n= num | placeHolder;
            String binaryString = Integer.toBinaryString(n).substring(1);
            int msb=0;
            for(char c:binaryString.toCharArray()){
                if(c=='1')
                    bitCount[msb++]+=1;
                else
                    bitCount[msb++]+=0;
            }
            System.out.println(binaryString);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<31;i++){
            sb.append(bitCount[i]%3);
        }
        return Integer.parseInt(sb.toString(),2);
    }
}

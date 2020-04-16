package dailycodings;

import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.Arrays;

/**
 * This problem was asked by Lyft.
 *
 * Given a list of integers and a number K, return which contiguous elements of the list sum to K.
 *
 * For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4], since 2 + 3 + 4 = 9.
 * */
public class DailyCoding_513 {

    public static void main(String[] args) {
        int[] input= new int[]{1, 2, 3, 4, 5};
        Arrays.sort(input);

        int start=0;
        int tail=0;
        int sum=0;
        int target=9;
        while (start<=tail && tail<input.length){
            if(sum<target){
                sum+=input[tail];
                tail++;
            }
            if(sum>target){
                sum-=input[start];
                start++;
            }
            if(sum==target)
                break;
        }

        System.out.println(start);
        MasterPrinter.printArray(Arrays.copyOfRange(input,start,tail));
    }

}

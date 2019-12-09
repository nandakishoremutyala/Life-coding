package leetcode.contests.contest_166;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    SubtractTheProductAndSumOfDigitsOfAnInteger sub;
    @BeforeEach
    public void init(){
        sub=new SubtractTheProductAndSumOfDigitsOfAnInteger();
    }

    @Test
    public void test_when_input_234(){
        int result= sub.subtractProductAndSum(234);
        Assertions.assertEquals(15,result);
    }

    @Test
    public void test_when_input_4421(){
        int result= sub.subtractProductAndSum(4421);
        Assertions.assertEquals(21,result);
    }
    public int subtractProductAndSum(int n) {
        int sum=0;
        Long product=1L;
        while(n>=10){
            sum+=n%10;
            product*=n%10;
            n=n/10;
        }
        sum+=n;
        product*=n;
        return (int) (product-sum);
    }
}

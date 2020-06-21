package leetcode.contests.contest_194;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class XOROperationInArray {
    XOROperationInArray xorOperationInArray;
    @BeforeEach
    public void init(){
        xorOperationInArray=new XOROperationInArray();
    }
    @Test
    public void firstTest(){
        int res= xorOperationInArray.xorOperation(5,0);
        Assertions.assertEquals(8,res);
    }
    public int xorOperation(int n, int start) {
        int op=start;
        for (int i = 1; i <n ; i++) {
            int num = start+2*i;
            op=op^num;
        }
        return op;
    }
}

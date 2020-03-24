package interviewing_io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindingDuplicateIntegers {
    FindingDuplicateIntegers duplicateIntegers;

    @BeforeEach
    public void init(){
        duplicateIntegers=new FindingDuplicateIntegers();
    }
    @Test
    public void firstTest(){
        int result = duplicateIntegers.duplicate(new int[]{1,2,3,4,5,6,9,9});
        Assertions.assertEquals(9,result);
    }

    public int duplicate(int[] arr){
        int sum=0;
        int xorOutput=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
            xorOutput=xorOutput^arr[i];
        }
        System.out.println(sum);
        System.out.println(xorOutput);
    return 0;
    }
}

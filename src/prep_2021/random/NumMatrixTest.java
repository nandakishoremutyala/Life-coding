package prep_2021.random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumMatrixTest {
    NumMatrix numMatrix;
    @BeforeEach
    public void init(){
        numMatrix=new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
    }
    @Test
    public void firstTest(){
       int num= numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(num);
    }
}

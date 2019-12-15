package leetcode.contests.contest_167;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SequentialDigits {
    SequentialDigits sequentialDigits;
    @BeforeEach
    public void init() {
        this.sequentialDigits = new SequentialDigits();
    }

    @Test
    public void whenLowIs100HighIs300() {
        int low = 100;
        int high = 300;
        List<Integer> actual=sequentialDigits.sequentialDigits(low,high);
        System.out.println(actual);
    }

    @Test
    public void whenLowIs1000HighIs13000() {
        int low = 1000;
        int high = 13000;
        List<Integer> actual=sequentialDigits.sequentialDigits(low,high);
        System.out.println(actual);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        int minLength = Integer.toString(low).length();
        HashMap<Integer, Integer> map = new HashMap<>();
        initMap(map);

        int number = getNumber(map, minLength);
        result.add(number);
        while (number <= high) {
            int numLen=Integer.toString(number).length();
            number = number + getDiff(numLen);
            if(isNumberValid(number,high))
                result.add(number);
            else{
                number=getNumber(map,numLen+1);
                if(isNumberValid(number,high))
                    result.add(number);
            }
        }
        return result;
    }

    private int getDiff(int length) {
        int result=0;
        switch (length) {
            case 1:
                result= 1;
                break;
            case 2:
                result= 11;
                break;
            case 3:
                result= 111;
                break;
            case 4:
                result= 1111;
                break;
            case 5:
                result= 11111;
                break;
            case 6:
                result= 111111;
                break;
            case 7:
                result= 1111111;
                break;
            case 8:
                result= 11111111;
                break;
        }
        return result;
    }

    private boolean isNumberValid(int number,int high) {
        if(number>high)return false;
        String str = Integer.toString(number);
        return str.charAt(str.length() - 1) != '0';
    }

    private void initMap(HashMap<Integer, Integer> map) {
        map.put(1, 1);
        map.put(2, 12);
        map.put(3, 123);
        map.put(4, 1234);
        map.put(5, 12345);
        map.put(6, 123456);
        map.put(7, 1234567);
        map.put(8, 12345678);
        map.put(9, 123456789);
    }

    public int getNumber(HashMap<Integer, Integer> map, int len) {
        return map.get(len);
    }
}

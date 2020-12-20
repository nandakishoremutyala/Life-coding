package leetcode.contests.contest_220;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

public class ReformatPhoneNumber {
    ReformatPhoneNumber reformatPhoneNumber;

    @BeforeEach
    public void init() {
        reformatPhoneNumber = new ReformatPhoneNumber();
    }

    @Test
    public void firstTest() {
        String res= reformatPhoneNumber.reformatNumber("1-23-45 6");
        System.out.println(res);
    }

    @Test
    public void secondTest() {
        String res= reformatPhoneNumber.reformatNumber("123 4-567");
        System.out.println(res);
    }

    @Test
    public void thirdTest() {
        String res= reformatPhoneNumber.reformatNumber("123 4-5678");
        System.out.println(res);
    }
    public String reformatNumber(String number) {
        StringTokenizer tokenizer = new StringTokenizer(number, " ");
        StringBuffer sb = new StringBuffer();

        while (tokenizer.hasMoreElements()) {
            sb.append(tokenizer.nextElement());
        }

        String str = sb.toString().replaceAll("-", "");
        System.out.println(str);

        int len=str.length();
        int remLength=len;
        StringBuilder result=new StringBuilder();
        int beg=0;
        while (remLength>4){
            result.append(str.substring(beg,beg+3)).append("-");
            beg+=3;
            remLength-=3;
        }
        if(remLength==3){
            result.append(str.substring(beg));
        }else if(remLength==2){
            result.append(str.substring(beg));
        }else{
            result.append(str.substring(beg,beg+2)).append("-");
            beg+=2;
            result.append(str.substring(beg));
        }
        return result.toString();
    }

}

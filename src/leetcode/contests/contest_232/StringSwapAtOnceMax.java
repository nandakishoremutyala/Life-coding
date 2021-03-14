package leetcode.contests.contest_232;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringSwapAtOnceMax {
    StringSwapAtOnceMax stringSwapAtOnceMax;
    @BeforeEach
    public void init(){
        stringSwapAtOnceMax=new StringSwapAtOnceMax();
    }
    @Test
    public void testFirst(){
        boolean res= stringSwapAtOnceMax.areAlmostEqual("siyolsdcjthwsiplccjbuceoxmpjgrauocx",
                "siyolsdcjthwsiplccpbuceoxmjjgrauocx");
        System.out.println(res);
    }

    @Test
    public void testSecond(){
        boolean res= stringSwapAtOnceMax.areAlmostEqual(
                "ysmpagrkzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhqkxumonfgrczmjvbhwvhpnocz",
                "ysmpagrqzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhkkxumonfgrczmjvbhwvhpnocz");
        System.out.println(res);
    }
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2))) return false;

        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();

        for(int i=0;i<a.length;i++){
            char target=a[i];
            if(target!=b[i]){
                swap(i,target,b,a);
                break;
            };

        }
        if(!String.valueOf(a).equalsIgnoreCase(String.valueOf(b))) return false;
        return true;
    }
    public void swap(int pos, char t, char[] str,char[] org){
        int loc=-1;
        for(int i=pos;i<str.length;i++){
            if(str[i]==t){
                loc=i;
                if(str[pos]==org[i])
                    break;
            }
        }
        char temp=str[pos];
        str[pos]=str[loc];
        str[loc]=temp;

    }
}

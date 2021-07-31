package prep_2021.all_googles;

import java.util.Arrays;

public class StudentAttendanceRecordII {
    public static void main(String[] args) {
        int res= checkRecord(10);
        System.out.println(res);
    }
    static int count=0;
    public static int checkRecord(int n) {
        recursion(new StringBuilder("A0L0"),n,0);
        return count%1000000007;
    }

    private static void recursion(StringBuilder sb, int n, int ccount){
        if(sb.charAt(3)=='3'){
            return;
        }
        if(sb.charAt(1)=='2') return;

        System.out.println(sb.toString());
        if(ccount==n){
            count++;
            count=count%1000000007;
            return;
        }
        // handling A
        int c=Integer.parseInt(String.valueOf(sb.charAt(1)));
        sb.setCharAt(1, (char)(c+1+'0'));
        sb.setCharAt(3,(char)'0');
        recursion(sb,n,ccount+1);
        c=Integer.parseInt(String.valueOf(sb.charAt(1)));
        sb.setCharAt(1, (char)(c-1+'0'));
        //ccount-=1;

        int lc=Integer.parseInt(String.valueOf(sb.charAt(3)));
        sb.setCharAt(3, (char)(lc+1+'0'));
        recursion(sb,n,ccount+1);
        c=Integer.parseInt(String.valueOf(sb.charAt(3)));
        sb.setCharAt(3, (char)(c-1+'0'));
        //ccount-=1;

        // handling p
        sb.setCharAt(3,(char)'0');
        recursion(sb,n,ccount+1);

        //ccount-=1;
    }
}

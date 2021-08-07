package effort_2021;

public class StudentAttendanceRecordII {
    public static void main(String[] args) {
        int res= checkRecord(10);
        System.out.println(res);
        int result = checkRecordInDp(10);
        System.out.println(result);
    }

    private static int checkRecordInDp(int n) {
        long M=1000000007;
        long a0l0 = 1;
        long a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;

        for(int i=0;i<n;i++){
            long new_a0l0 = (a0l0 + a0l1 + a0l2) % M;
            long new_a0l1 = a0l0;
            long new_a0l2 = a0l1;
            long new_a1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M;
            long new_a1l1 = a1l0;
            long new_a1l2 = a1l1;
            a0l0 = new_a0l0;
            a0l1 = new_a0l1;
            a0l2 = new_a0l2;
            a1l0 = new_a1l0;
            a1l1 = new_a1l1;
            a1l2 = new_a1l2;
        }
        return (int)((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M);
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

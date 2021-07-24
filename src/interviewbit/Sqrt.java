package interviewbit;

public class Sqrt {
    public static void main(String[] args) {
        sqrt(2147483647);
    }
    public static int sqrt(int A) {
        if(A==1) return 1;
        long left=0;
        long right=A/2-1;
        long mid=A/2-1;
        while(mid*mid!=A){
            mid=left+(right-left)/2-1;
            if(mid*mid<A){
                left=mid+1;
            }else{
                right=mid;
            }
            if(mid*mid==A) {
                break;
            };
            System.out.println("printing"+mid);
        }
        System.out.println(mid);
        return (int)mid;
    }
}

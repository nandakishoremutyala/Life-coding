package prep_2021;

public class GCDWithoutMultiplicationDivision {
    public static void main(String[] args) {
        System.out.println(gcd(5,15));
        System.out.println(gcd(3,10));
    }

    static int gcd(int x, int y) {
        if (x > y) return gcd(y, x);
        else if(x==0)
            return y;
        else if ((x & 1) == 0 && (y & 1) == 0) { // both number is even
            return gcd(x>>1, y>>1) << 1;
        } else if ((x  & 1) == 0 && (y  & 1) != 0) {
            return gcd(x >> 1, y);
        } else if ((x  & 1) != 0 && (y  & 1) == 0) {
            return gcd(x, y >> 1);
        }
        return gcd(x,y-x);
    }
}

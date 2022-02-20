package leetcode.contests.contest_278;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindSubstringWithGivenHash {
    FindSubstringWithGivenHash findSubstringWithGivenHash;

    @BeforeEach
    public void init() {
        findSubstringWithGivenHash = new FindSubstringWithGivenHash();
    }

    @Test
    public void firstTest() {
        String result= findSubstringWithGivenHash.subStrHash("leetcode", 7, 20, 2, 0);
        System.out.println(result);
    }

    @Test
    public void secondTest() {
        String result= findSubstringWithGivenHash.subStrHash("xmmhdakfursinye",
                96,
                45,
                15,
                21);
        System.out.println(result);
    }

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        StringBuilder window = new StringBuilder(s.substring(0, k));
        // calculate first hash
        long sum = calculateHash(window, power, modulo);
        if(sum%modulo==hashValue) return window.toString();

        System.out.println(Integer.MAX_VALUE);
        for (int i = 1; i <s.length()-k ; i++) {
            int valFirstCharacter= s.charAt(i-1) - 96;
            sum-=valFirstCharacter;
            sum/=power;
            sum= (long) (sum+(s.charAt(i+k-1) - 96) * Math.pow(power,k-1));
            int hash= Math.toIntExact(sum % modulo);
            //System.out.println("Hash"+hash);
            if(hash==hashValue)return s.substring(i,i+k);
        }
        return "";
    }

    private int calculateHash(StringBuilder window, int p, int mod) {
        int sum = 0;
        for (int i = 0; i < window.length(); i++) {
            int val = window.charAt(i) - 96;
            System.out.println(val);
            sum += ((int) (val * Math.pow(p, i)));
            //sum=sum%mod;
        }
        return sum;
    }
}

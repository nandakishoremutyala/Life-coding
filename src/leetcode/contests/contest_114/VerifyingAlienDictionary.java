package leetcode.contests.contest_114;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {
    VerifyingAlienDictionary verifyingAlienDictionary;

    @BeforeEach
    public void init() {
        verifyingAlienDictionary = new VerifyingAlienDictionary();
    }

    @Test
    public void firstTest() {
        String[] words = new String[]{"hello", "leetcode"};
        String orders = "hlabcdefgijkmnopqrstuvwxyz";
        Assertions.assertEquals(true, verifyingAlienDictionary.isAlienSorted(words, orders));
    }

    @Test
    public void secondTest() {
        String[] words = new String[]{"word", "world", "row"};
        String orders = "worldabcefghijkmnpqstuvxyz";
        Assertions.assertEquals(false, verifyingAlienDictionary.isAlienSorted(words, orders));
    }

    @Test
    public void thirdTest() {
        String[] words = new String[]{"apple", "app"};
        String orders = "abcdefghijklmnopqrstuvwxyz";
        Assertions.assertEquals(false, verifyingAlienDictionary.isAlienSorted(words, orders));
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dictionary = new HashMap<>();
        int len = words.length;
        int pos = 0;
        for (char c : order.toCharArray()) {
            dictionary.put(c, pos);
            pos++;
        }

        for (int i = 1; i < len; i++) {
            String str1 = words[i - 1];
            String str2 = words[i];
            if (!isLexSorted(str1, str2, dictionary)) return false;
        }
        return true;
    }

    private boolean isLexSorted(String str1,
                                String str2,
                                Map<Character, Integer> dictionary) {
        int len1=str1.length();
        int len2=str2.length();
        int count=0;
        while (count<len1 && count<len2){
            if(str1.charAt(count)!=str2.charAt(count)){
                if(dictionary.get(str2.charAt(count))>
                        dictionary.get(str1.charAt(count))){
                    return true;
                }else{
                    return false;
                }
            }
            count++;
        }
        if(count>str2.length()-1)return false;
        return true;
    }
}

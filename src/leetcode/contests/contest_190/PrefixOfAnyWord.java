package leetcode.contests.contest_190;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrefixOfAnyWord {
    PrefixOfAnyWord prefixOfAnyWord;
    @BeforeEach
    public void init(){
        prefixOfAnyWord=new PrefixOfAnyWord();
    }

    @Test
    public void firstTest(){
        String input= "love errichto jonathan dumb";
        String search="dumb";

        int len= prefixOfAnyWord.isPrefixOfWord(input,search);
        System.out.println(len);
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        int result = -1;
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length()>=searchWord.length() && words[i].substring(0,searchWord.length()).equals(searchWord)) {
                result = i+1;
                break;
            }
        }
        return result;
    }
}

package leetcode.contests.contest_169;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VerbalArithmeticPuzzle {
    VerbalArithmeticPuzzle verbalArithmeticPuzzle;
    @BeforeEach
    public void init(){
        verbalArithmeticPuzzle=new VerbalArithmeticPuzzle();
    }
    @Test
    public void firstTest(){
        verbalArithmeticPuzzle.isSolvable(new String[]{"SEND","MORE"},"MONEY");
    }
    public boolean isSolvable(String[] words, String result) {
        Set<Character> uniqueCharacters=new HashSet<>();
        for(String str:words)
            findUniqueCharacters(uniqueCharacters,str);
        findUniqueCharacters(uniqueCharacters,result);

        HashMap<Object, Object> mapper=new HashMap<>();

        for(char c:uniqueCharacters){
            for (int i = 0; i <10 ; i++) {
                if(!mapper.containsKey(i)){
                    mapper.put(i,c);
                    break;
                }
            }
        }
        MasterPrinter.printMap(mapper);
        return false;
    }

    private void findUniqueCharacters(Set<Character> uniqueCharacters, String str) {
        for(char c:str.toCharArray())
            uniqueCharacters.add(c);
    }
}

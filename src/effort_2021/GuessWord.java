package effort_2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessWord {
    interface Master{
        int guess(String str);
    }
    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a.charAt(i) == b.charAt(i))
                matches ++;
        return matches;
    }
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0,x=0; i <10 && x<6 ; ++i) {
            String guess =  wordlist[new Random().nextInt(wordlist.length)];
            x=master.guess(guess);

            List<String> wordlist2 = new ArrayList<>();
            for(String s:wordlist){
                if(match(guess,s)==x)
                    wordlist2.add(s);
            }
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);        }
    }
}

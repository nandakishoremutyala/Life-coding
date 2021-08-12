package effort_2021;

import java.util.*;

public class BullsAndCows {
    public static void main(String[] args) {
        BullsAndCows bullsAndCows=new BullsAndCows();
        bullsAndCows.getHint("1123","0111");
    }
    public String getHint(String secret, String guess) {

        StringBuilder sbSecret=new StringBuilder(secret);
        StringBuilder sbGuess=new StringBuilder(guess);
        int bulls=0;
        for(int i=0;i<secret.length();i++){
            if(sbSecret.charAt(i)==sbGuess.charAt(i)){
                sbSecret.setCharAt(i,'#');
                sbGuess.setCharAt(i,'#');
                bulls++;
            }
        }
        HashMap<Character,Integer> sMap=new HashMap<>();
        for(char c:sbSecret.toString().toCharArray())
            sMap.put(c,sMap.getOrDefault(c,0)+1);

        HashMap<Character,Integer> gMap=new HashMap<>();
        for(char c:sbGuess.toString().toCharArray())
            gMap.put(c,gMap.getOrDefault(c,0)+1);
        int cows=0;

        for (Map.Entry<Character,Integer> e:gMap.entrySet()){
            char key=e.getKey();
            if(key!='#' && sMap.containsKey(key)){
                cows+=Math.min(gMap.get(key),sMap.get(key));
            }
        }

        System.out.println(bulls+"-"+cows);
        return new String(bulls+"A"+cows+"B");
    }
}

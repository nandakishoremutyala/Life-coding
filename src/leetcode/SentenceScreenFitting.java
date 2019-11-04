package leetcode;

public class SentenceScreenFitting {
    public static void main(String[] args) {
        SentenceScreenFitting sentenceScreenFitting=new SentenceScreenFitting();
       int total= sentenceScreenFitting.wordsTyping(new String[]{"hello", "world"},
                2,8);
        System.out.println(total);

        int total1= sentenceScreenFitting.wordsTyping(new String[]{"a", "bcd","e"},
                3,6);
        System.out.println(total1);

        int total2= sentenceScreenFitting.wordsTyping(new String[]{"I", "had","apple","pie"},
                4,5);
        System.out.println(total2);

        int total3= sentenceScreenFitting.wordsTyping(new String[]{"a", "b","c"},
                3,1);
        System.out.println(total3);
    }
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String sent = String.join(" ", sentence) + " ";
        int pos = 0, len = sent.length();
        for(int i=0; i<rows; i++) {
            pos += cols;
            while(pos >=0 && sent.charAt(pos%len)!=' '){
                pos--;
            }
            pos++;
        }
        return pos / len;
    }
}

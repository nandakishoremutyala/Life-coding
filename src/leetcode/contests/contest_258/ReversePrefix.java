package leetcode.contests.contest_258;

public class ReversePrefix {
    public static void main(String[] args) {
        String input= "abcdefd";
        char ch='d';
        ReversePrefix reversePrefix=new ReversePrefix();
        String result= reversePrefix.reversePrefix(input,ch);
        System.out.println(result);

        String res= reversePrefix.reversePrefix("abcd",'z');
        System.out.println(res);
    }
    public String reversePrefix(String word, char ch) {
        int found=-1;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                found=i;
                break;
            }
        }
        if(ch==-1) return word;

        StringBuilder sb=new StringBuilder();
        int temp=found;
        while (temp>=0){
            sb.append(word.charAt(temp));
            temp--;
        }
        found+=1;
        while (found<word.length()){
            sb.append(word.charAt(found));
            found++;
        }

        return sb.toString();

    }
}

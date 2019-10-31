package leetcode;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression sc=new StringCompression();
        int result = sc.compress(new char[]{'a','a','b','b','c','c','c'});
        System.out.println(result);
    }
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        char prev=chars[0];
        int count=1;
        for(int i=1;i<chars.length;i++){
            char c=chars[i];
            if(c==prev){
                count+=1;
            }else{
                sb.append(prev);
                sb.append(count);
                prev=c;
                count=1;
            }
        }

        sb.append(prev);
        sb.append(count);
        System.out.println(sb.toString());
        return sb.length();
    }
}

package others;

public class ReverseStringRecursion {
    public static void main(String args[]) {
        String hello = "hello";
        String result = reverse(hello, 0);
        System.out.println(result);
    }

    private static String reverse(String hello, int start) {
        System.out.println(start+": "+hello);
        if (hello.length()==1) return hello;
        StringBuilder sb = new StringBuilder("");
        sb.append(reverse(hello.substring(1), start + 1)).append(hello.charAt(0));
        return sb.toString();
    }
}
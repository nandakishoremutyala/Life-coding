package leetcode.contests.contest_261;

public class MinMovesToConvertString {
    public static void main(String[] args) {
        MinMovesToConvertString m = new MinMovesToConvertString();
     /*   int res= m.minimumMoves("XXX");
        System.out.println(res);
*/
        int res1 = m.minimumMoves("0X00X");
        System.out.println(res1);
    }

    public int minimumMoves(String s) {
        int total = 0;
        char[] arr = s.toCharArray();

        int i = 0;
        while (i < arr.length) {
            if (arr[i] == 'X') {
                boolean found = false;
                for (int j = i; j < i + 3; j++) {
                    if (j < arr.length && arr[j] == 'X') {
                        found = true;
                        arr[j] = '0';
                    }
                }
                if (found)
                    total += 1;
            }
           i++;
        }
        return total;
    }
}

package practice.backtracking;

public class PrintBinary {
    public static void main(String[] args) {
        PrintBinary printBinary = new PrintBinary();
        printBinary.printBinary(3, new StringBuilder(""));
    }

    private void printBinary(int digits, StringBuilder pre) {

        if (digits == 0) {
            System.out.println(pre.toString());
            return;
        } else {
            printBinary(digits - 1, pre.append(0));
            pre.deleteCharAt(pre.length()-1);
            printBinary(digits - 1, pre.append(1));
            pre.deleteCharAt(pre.length()-1);
        }
    }
}

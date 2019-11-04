package others;

import java.util.ArrayList;
import java.util.List;

public class MasterPrinter {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Hello");list.add("World");
        MasterPrinter.printList(list);
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }

    public static void printList(List<?> list){
        System.out.println("");
        for (Object o:list)
            System.out.print(o.toString());
    }
    public static void printArrayChars(char[][] chars){
        for (int i = 0; i <chars.length ; i++) {
            for (int j = 0; j <chars[0].length ; j++) {
                System.out.print(chars[i][j]+" ");
            }
            System.out.println("");
        }
    }
}

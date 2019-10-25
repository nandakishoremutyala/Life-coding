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
            System.out.println(arr[i]);
        }
    }

    public static void printList(List<?> list){
        for (Object o:list)
            System.out.println(o.toString());
    }
}

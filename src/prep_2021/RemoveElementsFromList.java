package prep_2021;

import others.MasterPrinter;

import java.util.Arrays;
import java.util.List;

public class RemoveElementsFromList {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(2,3,5,5,7,11,11,11,13);
        int k=5;
        removeElements(list,k);
    }

    private static void removeElements(List<Integer> list, int k) {
        int writeIndex=0;

        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i)!=k){
                list.set(writeIndex++,list.get(i));
            }
        }
        MasterPrinter.printList(list);
    }
}

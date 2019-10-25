package practice.backtracking;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result;
    public static void main(String[] args) {
        Subsets subsets=new Subsets();
        subsets.subsets(new int[]{1,2,3});
    }
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        int start=0;
        subsetHelper(nums,start,new ArrayList<>());
        return result;
    }

    private void subsetHelper(int[] nums, int start, ArrayList<Integer> list) {
        //System.out.println("list: ");
        MasterPrinter.printList(list);
        result.add(new ArrayList<>(list));
        if(start==3)
            return;
        else{
            for (int i=start;i<nums.length;i++){
                list.add(nums[i]);
                subsetHelper(nums,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
}

package data_structure.trees;

import java.util.HashSet;

public class TwoSumBSTS {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> setA=new HashSet<>();
        updateSet(setA,root1);

        return findElement(target,root2,setA);
    }

    private void updateSet(HashSet<Integer> set, TreeNode root){
        if(root==null)return;
        set.add(root.val);
        updateSet(set,root.left);
        updateSet(set,root.right);
    }

    private boolean findElement(int target, TreeNode root, HashSet<Integer> set){
        if(root==null)return false;
        if(set.contains(target-root.val)) return true;
        boolean res= findElement(target,root.left,set)||
                findElement(target, root.right,  set);
        return res;
    }
}

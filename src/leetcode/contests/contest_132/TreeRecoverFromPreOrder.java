package leetcode.contests.contest_132;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data_structure.trees.TreeNode;

public class TreeRecoverFromPreOrder {
    TreeRecoverFromPreOrder recoverFromPreOrder;

    @BeforeEach
    public void init() {
        recoverFromPreOrder = new TreeRecoverFromPreOrder();
    }

    @Test
    public void firstTestWithSmallDataset(){
        String input="1-2--3--4-5--6--7";
        recoverFromPreOrder.recoverFromPreorder(input);
    }
    public TreeNode recoverFromPreorder(String S) {
        TreeNode root=new TreeNode(0);
        helper(root,0,S.length(),0,S);
        return root;
    }

    private TreeNode helper(TreeNode root, int start, int end,int level,String input) {
        return null;
    }

    private int findPositionForRightChildAtLevel(int level,String in) {
        String str="";
        for (int i=0;i<level;i++)
            str+="-";
        return in.lastIndexOf(str);
    }

    private int findPositionForLeftChildAtLevel(int level,String in) {
        String str="";
        for (int i=0;i<level;i++)
            str+="-";
        return in.lastIndexOf(str);
    }
}

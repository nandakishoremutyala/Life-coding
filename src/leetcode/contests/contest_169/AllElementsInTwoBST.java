package leetcode.contests.contest_169;

import leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllElementsInTwoBST {
    AllElementsInTwoBST allElementsInTwoBST;
    @BeforeEach
    public void init(){
        this.allElementsInTwoBST=new AllElementsInTwoBST();
    }

    @Test
    public void firstTest(){
        TreeNode root1=new TreeNode(2);
        root1.left=new TreeNode(1);
        root1.right=new TreeNode(4);
        TreeNode root2=new TreeNode(1);
        root2.left=new TreeNode(0);
        root2.right=new TreeNode(3);
        List<Integer> res= allElementsInTwoBST.getAllElements(root1,root2);
        Assertions.assertEquals(res, Arrays.asList(0,1,1,2,3,4));
    }

    @Test
    public void secondTest(){
        TreeNode root1=new TreeNode(0);
        root1.left=new TreeNode(-10);
        root1.right=new TreeNode(10);
        TreeNode root2=null;
        List<Integer> res= allElementsInTwoBST.getAllElements(root1,root2);
        Assertions.assertEquals(Arrays.asList(-10,0,10),res);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result=new ArrayList<>();
        traverseTree(result,root1);
        traverseTree(result,root2);
        Collections.sort(result);
        return result;
    }

    private void traverseTree(List<Integer> result, TreeNode root) {
        if(root==null) return;
        result.add(root.val);
        traverseTree(result,root.left);
        traverseTree(result,root.right);
    }
}

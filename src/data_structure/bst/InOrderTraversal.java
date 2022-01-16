package data_structure.bst;

import leetcode.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InOrderTraversal {
    InOrderTraversal inOrderTraversal;
    @BeforeEach
    public void init(){
        inOrderTraversal=new InOrderTraversal();
    }
    @Test
    public void firstTest(){
        TreeNode root=new TreeNode(4);
        root.right=new TreeNode(5);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        inOrderTraversal.inOrderTraverse(root);
        System.out.println("");
        preOrderTraverse(root);
    }
    public void inOrderTraverse(TreeNode root){
        if(root==null) return;
        inOrderTraverse(root.left);
        System.out.print(root.val);
        inOrderTraverse(root.right);
    }

    /***
     * stack: 4 2 3
     * output: 1 2 3 4 5
     */

    public void preOrderTraverse(TreeNode root){
        if(root==null) return;
        System.out.print(root.val);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);

    }

}

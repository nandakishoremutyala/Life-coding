package data_structure.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArithMaticExpressionTree {
    class Node {
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    @Test
    public void init(){
        Node root=new Node('-');
        root.left=new Node('+');
        root.right=new Node('2');
        root.left.left=new Node('7');
        root.left.right=new Node('*');
        root.left.right.left=new Node('4');
        root.left.right.right=new Node('3');
        int result=aet(root);
        System.out.println(result);
    }

    private int aet(Node root) {
        if (root == null) return 0;
        if(root.left==null & root.right==null) return Integer.parseInt(String.valueOf(root.val));
        char val=root.val;

        if(!Character.isDigit(val)){
            int l=aet(root.left);
            int r=aet(root.right);
            System.out.println("left "+l);
            System.out.println("right "+r);

            return ops(val,l,r);
        }else return root.val;
    }
    private int ops(char o,int l, int r){
        if(o=='+')
            return l+r;
        if(o=='-')
            return l-r;
        if(o=='*')
            return l*r;
        if(o=='/')
            return l/r;
        return -1;
    }
}

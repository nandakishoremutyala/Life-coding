package prep_2021.geeksforgeeks.dp;

public class VertexCoverProblem {
    static class Node {
        int data;
        int vc;
        Node left, right;
    }


    static int vCover(Node root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        if(root.vc!=0) return root.vc;

        // root include
        int rootInclude = Math.min(1+vCover(root.left),1+vCover(root.right));

        // root exclude if root is excluded that means child must be included
        int rootExclude=0;
        if(root.left!=null){
            rootExclude+=1+vCover(root.left.left) + // including the child of left
                    vCover(root.left.right);
        }

        if(root.right!=null){
            rootExclude+=1+vCover(root.right.left) + // including child  of right
                    vCover(root.right.right);
        }

        root.vc=Math.min(rootInclude,rootExclude);
        return root.vc;
    }
}

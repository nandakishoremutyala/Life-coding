package leetcode.contests.contest_283;

import leetcode.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CreateBinaryTreeFromDesc {
    CreateBinaryTreeFromDesc createBinaryTreeFromDesc;
    @BeforeEach
    public void init(){
        createBinaryTreeFromDesc=new CreateBinaryTreeFromDesc();
    }

    @Test
    public void firstTest(){
        createBinaryTreeFromDesc.createBinaryTree(new int[][]{
                {20,15,1},
                {20,17,0},
                {50,20,1},
                {50,80,0},
                {80,19,1}
        });
    }
    public TreeNode createBinaryTree(int[][] desc) {
        Map<Integer, List<Integer>> childToParents = new HashMap<>();
        Map<Integer, List<Integer>> parentsToChild = new HashMap<>();

        for (int i = 0; i < desc.length; i++) {
            //
            int[] data = desc[i];
            int child = data[1];
            int parent = data[0];
            childToParents.compute(child, (k, v) -> v == null ? new ArrayList<>() : v).add(parent);
            childToParents.compute(parent, (k, v) -> v == null ? new ArrayList<>() : v);
            parentsToChild.compute(parent, (k, v) -> v == null ? new ArrayList<>() : v).add(i);
        }
        int p = 0;
        System.out.println(childToParents);
        for (Map.Entry<Integer, List<Integer>> e : childToParents.entrySet()) {
            if (e.getValue().size() == 0) {
                p = e.getKey();
            }
        }

        //System.out.println(p);

        Queue<TreeNode> queue = new LinkedList<>();
        //int[] pos=desc[parentsToChild.get(p).get(0)];
        TreeNode parentNode=new TreeNode(p);
        queue.add(parentNode);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.println(curr.val);
            if(parentsToChild.get(curr.val)==null) continue;
            for (int i = 0; i < parentsToChild.get(curr.val).size(); i++) {
                int[] c= desc[parentsToChild.get(curr.val).get(i)];
                if(c[2]==0){
                    TreeNode rNode=new TreeNode(c[1]);
                    curr.right=rNode;
                    queue.add(curr.right);
                }else {
                    TreeNode lNode=new TreeNode(c[1]);
                    curr.left=lNode;
                    queue.add(curr.left);
                }
            }

        }

        return parentNode;
    }
}

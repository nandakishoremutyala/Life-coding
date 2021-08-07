package effort_2021;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DuplicatesInBinaryTree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<String,Integer>(), res);
        return res;
    }

    private String postorder(TreeNode root, HashMap<String, Integer> map, List<TreeNode> res) {
        if(root==null)return "#";
        String serial=root.val+"#"
                +postorder(root.left,map,res)+"#"
                +postorder(root.right,map,res);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if(map.get(serial)==2)
            res.add(root);
        return serial;
    }
}

package data_structure.trees;

public class BtToString {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.right == null && t.left == null)
            return t.val + "";
        if (t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" +
                tree2str(t.left) + ")" + "(" +
                tree2str(t.right) + ")";
    }
}

package data_structure.trees;

public class StringToBinaryTree {
    //4(2(3)(1))(6(5))
    private int i = 0; // make i global

    public TreeNode str2tree(String s) {
        if (s.equals("")) return null;
        return dfs(s);
    }

    private TreeNode dfs(String s) {
        TreeNode root = null;
        if (s.charAt(i) != '(')
            root = new TreeNode(getIntVal(s));
        TreeNode leftNode = null, rightNode = null;
        if (i < s.length() && s.charAt(i) == '(') { // for the possible leftNode, if '(' met.
            i++;
            leftNode = dfs(s);
        }
        if (i < s.length() && s.charAt(i) == '(') { // for the possible rightNode, if '(' met.
            i++;
            rightNode = dfs(s);
        }
        root.left = leftNode;
        root.right = rightNode;
        i++;
        return root;
    }

    private int getIntVal(String s) {
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')')
                break;
            sb.append(s.charAt(i));
            i++;
        }
        int val = Integer.valueOf(sb.toString());
        return val;
    }
}

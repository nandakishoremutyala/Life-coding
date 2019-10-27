package data_structure.trees;

public class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean notFound = true;
        if (s == null && t == null) return !notFound;
        if (s == null || t == null) return notFound;

        String hayStack = serialize2(s);
        String needle = serialize2(t);
        return hayStack.indexOf(needle) >= 0;
    }

    private static String serialize2(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }

    private static void helper(TreeNode t, StringBuilder sb) {
        if (t == null) {
            sb.append("null,");
            return;
        }
        sb.append('\'');
        sb.append(t.val);
        sb.append("\',");
        helper(t.left, sb);
        helper(t.right, sb);
    }
}

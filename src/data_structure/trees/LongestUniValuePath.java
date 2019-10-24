package data_structure.trees;

public class LongestUniValuePath {
    int max=0;
    public static void main(String[] args) {
        LongestUniValuePath longestUniValuePath = new LongestUniValuePath();

        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(5);
        root.right.right=new TreeNode(5);
        int result = longestUniValuePath.longestUnivaluePath(root);
        System.out.println(result);

    }

    public int longestUnivaluePath(TreeNode root) {
        if(root==null)return 0;
        return helper(root, 1);
    }

    private int helper(TreeNode root, int i) {
        max=Math.max(max,i);
        if (root == null) return i;
        int left=0, right=0;
        if (root.left!=null && root.val == root.left.val)
            helper(root.left, i + 1);
        else{
            helper(root.left, 1);
        }
        System.out.println("left: "+left);
        if (root.right!=null && root.val == root.right.val)
           helper(root.right, i+1);
        else
            helper(root.right, 1);
        System.out.println("right: "+right);
        return max;
    }
}

package leetcode;

public class BinaryTreeCameras {
    public static void main(String[] args) {
        BinaryTreeCameras binaryTreeCameras = new BinaryTreeCameras();
        TreeNode root = new TreeNode(0);
        System.out.println(binaryTreeCameras.minCameraCover(root));
    }

    int count = 0;
    private int NOT_MONITORED = 0;
    private int MONITORED_NOCAM = 1;
    private int MONITORED_WITHCAM = 2;

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        int top= helper(root);
        return count+(top==NOT_MONITORED?1:0);
    }

    private int helper(TreeNode root) {
        if (root == null) return MONITORED_NOCAM;
        int left = helper(root.left);
        int right = helper(root.right);

        if (left == MONITORED_NOCAM && right == MONITORED_NOCAM)
            return NOT_MONITORED;
        else if (left == NOT_MONITORED || right == NOT_MONITORED) {
            count++;
            return MONITORED_WITHCAM;
        } else {
            return MONITORED_NOCAM;

        }
    }
}

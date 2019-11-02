package leetcode;

public class SortedLinkedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        int i = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            i++;
        }
        int[] num = new int[i];

        int j = 0;
        while (head != null) {
            num[j++] = head.val;
            head = head.next;
        }
        if (num.length == 0) {
            return null;
        }
        TreeNode root = helper(num, 0, num.length - 1);
        return root;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}

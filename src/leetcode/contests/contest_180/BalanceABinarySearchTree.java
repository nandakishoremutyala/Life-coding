package leetcode.contests.contest_180;

import leetcode.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BalanceABinarySearchTree {
    BalanceABinarySearchTree balanceABinarySearchTree;

    @BeforeEach
    public void init() {
        balanceABinarySearchTree = new BalanceABinarySearchTree();
    }

    @Test
    public void firstTest() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        balanceABinarySearchTree.balanceBST(root);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        buildList(data, root);
        Collections.sort(data);
        MasterPrinter.printList(data);

        int[] arr=new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arr[i]=data.get(i);
        }
        return sortedArrayToBST(arr,0,arr.length-1);
    }

    TreeNode sortedArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    private void buildList(List<Integer> data, TreeNode root) {
        if (root != null) {
            data.add(root.val);
            buildList(data, root.left);
            buildList(data, root.right);
        }
    }
}

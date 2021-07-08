package prep_2021;

public class BinaryTreeLock {
    private class BinaryTreeNode {
        boolean locked;
        BinaryTreeNode parent;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
    }

    public boolean is_locked(BinaryTreeNode node) {
        return node.locked;
    }

    public boolean lock(BinaryTreeNode node) {
        if (!checkLockPreCondition(node)) {
            return false;
        }
        node.locked = true;
        return true;
    }

    public boolean unlock(BinaryTreeNode node) {
        if (!checkLockPreCondition(node))
            return false;
        node.locked = false;
        return true;
    }

    private boolean checkLockPreCondition(BinaryTreeNode node) {
        boolean left = checkChildLockPrecondition(node.leftChild);
        if (!left) {
            return false;
        }

        boolean right = checkChildLockPrecondition(node.leftChild);
        if (!right) {
            return false;
        }

        BinaryTreeNode parentNode = node.parent;
        while (parentNode != null) {
            if (parentNode.locked)
                return false;
            parentNode = parentNode.parent;
        }

        return true;
    }

    private boolean checkChildLockPrecondition(BinaryTreeNode node) {
        if (node == null) return true;
        if (node.locked) return false;
        boolean left = checkLockPreCondition(node.leftChild);
        if (!left) return false;
        boolean right = checkLockPreCondition(node.leftChild);
        return right;
    }
}

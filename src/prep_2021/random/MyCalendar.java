package prep_2021.random;

public class MyCalendar {
    Node root;

    class Node {
        int start;
        int end;
        Node left, right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
        }
    }

    public MyCalendar() {
        root = null;
    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return true;
        }
        Node node= helper(root, start, end);
        if(node==null)return false;
        return true;
    }

    private Node helper(Node root, int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return root;
        }
        if (end <= root.start) {
            Node l = helper(root.left, start, end);
            if (l == null) return null;
            else {
                root.left = l;
                return root;
            }
        }else if(start>=root.end){
            Node r=helper(root.right,start,end);
            if(r==null)return null;
            else{
                root.right=r;
                return root;
            }
        }else
            return null;
    }
}

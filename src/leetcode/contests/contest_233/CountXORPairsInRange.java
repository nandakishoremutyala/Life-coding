package leetcode.contests.contest_233;

public class CountXORPairsInRange {
    public int countPairs(int[] nums, int low, int high) {

        Node root=new Node();
        int countPairs=0;
        for(int num:nums){
            countPairs += cntSmaller(root, num, high + 1) - cntSmaller(root, num, low);
            // Insert nums[i] into Trie
            insert(root, num);
        }
        return countPairs;
    }

    private int cntSmaller(Node root, int n, int K) {
        int countPairs=0;
        for (int i = 14; i >=0 && root!=null; i--) {
            int x=(n>>i) & 1;
            int y=(K>>i) & 1;

            if(y==1){
                if(root.child[x]!=null)
                    countPairs+= root.child[x].count;
                root=root.child[1-x];
            }else{
                root=root.child[x];
            }

        }
        return countPairs;

    }

    class Node {
        Node child[];
        int count;

        public Node() {
            this.child = new Node[2];
            this.count = 0;
        }
    }

    private void insert(Node root, int N) {
        // why 14?
        //One minor optimization would be to only check the last 15 bits of the numbers
        // since the problem has limitations on the largest value of nums[i] as 2e4
        for (int i = 14; i >= 0; i--) {
            int bit = (N >> i) & 1; // right shift and AND will give us the ith bit
            if (root.child[bit] == null) {
                root.child[bit] = new Node();
            }
            root.child[bit].count += 1;
            root = root.child[bit];
        }
    }
}

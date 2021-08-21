package prep_2021.geeksforgeeks;

import java.util.PriorityQueue;

public class HuffmanCoding {
    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charfreq = {5, 9, 12, 13, 16, 45};

        PriorityQueue<HuffNode> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (int i = 0; i < n; i++) {
            HuffNode huffNode = new HuffNode();
            huffNode.ch = charArray[i];
            huffNode.freq = charfreq[i];
            huffNode.left = null;
            huffNode.right = null;
            pq.add(huffNode);
        }
        HuffNode root = null;
        while (pq.size() > 1) {
            HuffNode x = pq.poll();
            HuffNode y = pq.poll();

            int val = x.freq + y.freq;
            char ch = '-';

            HuffNode parent = new HuffNode();
            parent.freq = val;
            parent.ch = ch;
            parent.left = x;
            parent.right = y;

            root = parent;
            pq.add(parent);
        }

        System.out.println(root.freq);

        printCode(root, new StringBuilder());
    }

    private static void printCode(HuffNode root, StringBuilder sb) {
        if (root.left
                == null
                && root.right
                == null
                && Character.isLetter(root.ch)) {
            // c is the character in the node
            System.out.println(root.ch + ":" + sb.toString());
            return;
        }

        printCode(root.left, sb.append('0'));
        sb.deleteCharAt(sb.length() - 1);
        printCode(root.right, sb.append('1'));
        sb.deleteCharAt(sb.length() - 1);
    }

    static class HuffNode {
        char ch;
        int freq;
        HuffNode left;
        HuffNode right;
    }
}

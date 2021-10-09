package data_compression;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffManEncoding {
    public static void main(String[] args) {
        HuffManEncoding he = new HuffManEncoding();
        he.HuffmanEncodingBuilder("Huffman encoding is a data compression algorithm");
    }

    HashMap<Character, String> huffmanCode = new HashMap<>();

    private void HuffmanEncodingBuilder(String s) {
        HashMap<Character, Integer> frequency = calculateCharacterFrequency(s);
        PriorityQueue<HuffManNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
        updateMinHeap(frequency, minHeap);
        // printMinHeap(minHeap);
        HuffManNode root = generateHuffmanTree(minHeap);
        generateHuffmanCode(root, new StringBuilder());
        printHuffmanCode(huffmanCode);
        System.out.println(minHeap.size());
        String encodedString = encode(huffmanCode, s);
        System.out.println(encodedString);
        int index = -1;
        System.out.println("\nDecoded string is: \n");
        while (index < encodedString.length() - 2) {
            index = decode(root, index, new StringBuilder(encodedString));
        }
    }

    private int decode(HuffManNode root, int index, StringBuilder sb) {
        if (root == null)
            return index;

        // found a leaf node
        if (root.left == null && root.right == null) {
            System.out.print(root.c);
            return index;
        }
        index++;

        if (sb.charAt(index) == '0')
            index = decode(root.left, index, sb);
        else
            index = decode(root.right, index, sb);

        return index;
    }

    private String encode(HashMap<Character, String> huffmanCode, String s) {
        StringBuilder encodedString = new StringBuilder();
        for (char ch : s.toCharArray()) {
            String binaryString = huffmanCode.get(ch);
            encodedString.append(binaryString);
        }
        return encodedString.toString();
    }

    private void printHuffmanCode(HashMap<Character, String> huffmanCode) {
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private void generateHuffmanCode(HuffManNode root, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.c, sb.toString());
        }
        generateHuffmanCode(root.left, sb.append("0"));
        sb.deleteCharAt(sb.length() - 1);
        generateHuffmanCode(root.right, sb.append("1"));
        sb.deleteCharAt(sb.length() - 1);
    }

    private HuffManNode generateHuffmanTree(PriorityQueue<HuffManNode> minHeap) {
        while (minHeap.size() != 1) {
            HuffManNode left = minHeap.poll();
            HuffManNode right = minHeap.poll();
            assert left != null;
            assert right != null;
            int res = left.frequency + right.frequency;
            HuffManNode root = new HuffManNode('*', res);
            root.left = left;
            root.right = right;
            minHeap.add(root);
        }
        return minHeap.peek();
    }

    private void printMinHeap(PriorityQueue<HuffManNode> minHeap) {
        while (!minHeap.isEmpty()) {
            HuffManNode node = minHeap.poll();
            System.out.println(node.c + "-" + node.frequency);
        }
    }

    private void updateMinHeap(HashMap<Character, Integer> frequency, PriorityQueue<HuffManNode> minHeap) {
        for (Map.Entry<Character, Integer> e : frequency.entrySet()) {
            minHeap.add(new HuffManNode(e.getKey(), e.getValue()));
        }
    }

    private HashMap<Character, Integer> calculateCharacterFrequency(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequency.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }
        return frequency;
    }

    class HuffManNode {
        char c;
        int frequency;
        HuffManNode left;
        HuffManNode right;

        public HuffManNode(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }
    }
}

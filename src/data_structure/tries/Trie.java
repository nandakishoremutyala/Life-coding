package data_structure.tries;

import java.util.HashMap;

public class Trie {
    Node root;

    public Trie() {
        this.root = new Node("");
    }

    class Node {
        String prefix;
        HashMap<String, Node> dict;
        boolean isWord;

        public Node(String c) {
            this.prefix = c;
            this.dict = new HashMap<>();
            this.isWord = false;
        }
    }

    private void insert(String word) {
        if (word == null) return;
        Node head = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!head.dict.containsKey(c)) {
                head.dict.put(head.prefix + c, new Node(head.prefix + c));
                head = head.dict.get(head.prefix + c);
                if (i == word.length() - 1) {
                    head.isWord = true;
                }
            } else {
                head = head.dict.get(head.prefix + c);
            }

        }


    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = new String[]{"cat", "ca", "dog", "cats"};
        for (String w : words) {
            trie.insert(w);
        }
        System.out.println(trie);
    }

}

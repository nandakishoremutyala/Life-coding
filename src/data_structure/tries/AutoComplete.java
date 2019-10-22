package data_structure.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutoComplete {
    Node root;

    public AutoComplete() {
        this.root = new Node("");
    }

    class Node {
        String prefix;
        HashMap<Character, Node> dict;
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
                head.dict.put(c, new Node(word.substring(0, i + 1)));
            }
            head = head.dict.get(c);
            if (i == word.length() - 1) head.isWord = true;
        }
    }

    public List<String> findAllTheWords(String word) {
        List<String> results=new ArrayList<>();
        Node head = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(head.dict.containsKey(c)){
                head=head.dict.get(c);
            }
            else {
                return results;
            }
        }

        findAllChildWords(head, results);
        return results;
    }

    private void findAllChildWords(Node head, List<String> results) {
        if (head.isWord) results.add(head.prefix);
        for (Character c : head.dict.keySet()) {
            findAllChildWords(head.dict.get(c), results);
        }
    }

    public static void main(String[] args) {
        AutoComplete trie = new AutoComplete();
        String[] words = new String[]{"cat", "ca", "dog", "cats"};
        for (String w : words) {
            trie.insert(w);
        }

        System.out.println(trie.findAllTheWords("ca"));
        System.out.println(trie);
    }

}

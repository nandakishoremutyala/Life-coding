package leetcode.contests.contest_164;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
    SearchSuggestionsSystem searchSuggestionsSystem;

    @BeforeEach
    public void init() {
        searchSuggestionsSystem = new SearchSuggestionsSystem();
    }

    @Test
    public void firstTest() {
        String[] input = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        searchSuggestionsSystem.suggestedProducts(input, searchWord);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie=new Trie();
        for (String str:products) {
            trie.addWord(str);
        }
        return null;
    }

    class Node {
        char c;
        Node[] children;
        boolean isWord;

        public Node(char c) {
            this.c = c;
            this.children = new Node[26];
            this.isWord = false;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node('#');
        }

        public void addWord(String word) {
            Node head = root;
            for (char c : word.toCharArray()) {
                if (head.children[c - 'a'] == null){
                    head.children[c - 'a'] = new Node(c);
                    head=head.children[c-'a'];
                }
                else {
                    head = head.children[c - 'a'];
                }
            }
            head.isWord = true;
        }
    }
}

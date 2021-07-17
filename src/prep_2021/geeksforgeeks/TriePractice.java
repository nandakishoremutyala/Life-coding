package prep_2021.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class TriePractice {
    static class TrieNode {
        Map<Character, TrieNode> map;
        char c;
        boolean isEnd;

        TrieNode(char c) {
            this.c = c;
            this.map = new HashMap<Character, TrieNode>();
            isEnd = false;
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode('#');
        }

        void add(String str) {
            TrieNode crawl = root;
            for (char c : str.toCharArray()) {
                if (crawl.map.get(c) == null) {
                    crawl.map.put(c, new TrieNode(c));
                    crawl = crawl.map.get(c);
                } else {
                    crawl = crawl.map.get(c);
                }
            }
            crawl.isEnd = true;
        }

        boolean search(String search) {
            TrieNode crawl = root;
            for (char c : search.toCharArray()) {
                if(crawl.map.containsKey(c)){
                    crawl=crawl.map.get(c);
                }else
                    return false;
            }
            if(crawl.isEnd)return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] data = new String[]{"apt", "apple", "bag"};
        for (String str : data) {
            trie.add(str);
        }
        System.out.println(trie);
        System.out.println(trie.search("ap"));
    }
}

package data_structure.graph.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
        String res = longestWordInDictionary.longestWord(new String[]
                {"a", "banana", "app", "appl", "ap", "apply", "apple"});
        System.out.println(res);
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for (String str : words) {
            trie.insert(str, ++index);
        }
        trie.words = words;
        return trie.dfs();
    }

    class Trie {
        Node root;
        String[] words;

        public Trie() {
            this.root = new Node('0');
        }

        class Node {
            char c;
            HashMap<Character, Node> childs = new HashMap<>();
            int end;

            Node(char c) {
                this.c = c;
            }
        }

        public void insert(String word, int index) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur.childs.putIfAbsent(c, new Node(c));
                cur = cur.childs.get(c);
            }
            cur.end = index;

        }

        public String dfs() {
            String ans = "";
            Stack<Node> stack = new Stack();
            stack.push(root);
            while (!stack.empty()) {
                Node node = stack.pop();
                if (node.end > 0 || node == root) {
                    if (node != root) {
                        String word = words[node.end - 1];
                       // System.out.println(word);
                        if (word.length() > ans.length() ||
                                word.length() == ans.length() && word.compareTo(ans) < 0) {
                            ans = word;
                        }
                    }
                    for (Node nei : node.childs.values()) {
                        stack.push(nei);
                    }
                }
            }
            return ans;
        }
    }
}

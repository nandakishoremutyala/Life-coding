package dailycodings;

import java.util.HashMap;

public class AutoComplete_DC_11 {
    public static void main(String[] args) {
        root = new Node('*', false);
        String dog = "dog";
        add(dog);
        add("doggy");
        System.out.println(root);
    }

    static Node root;

    private static class Node {
        char c;
        HashMap<Character, Node> map;
        boolean word = false;

        public Node(char c, boolean word) {
            this.map = new HashMap<>();
            this.c = c;
            this.word = word;
        }
    }

    public static void add(String word) {
        Node tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (i == word.length() - 1) {
                if (tempRoot.map.containsKey(c)) {
                    tempRoot = tempRoot.map.get(c);
                    tempRoot.word = true;
                } else {
                    tempRoot.map.put(c, new Node(c, true));
                    tempRoot = tempRoot.map.get(c);
                }
            } else {
                if (tempRoot.map.containsKey(c))
                    tempRoot = tempRoot.map.get(c);
                else {
                    tempRoot.map.put(c, new Node(c, false));
                    tempRoot = tempRoot.map.get(c);
                }

            }
        }
    }
}

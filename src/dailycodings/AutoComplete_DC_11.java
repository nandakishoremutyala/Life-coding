package dailycodings;

import java.util.*;

public class AutoComplete_DC_11 {
    public static void main(String[] args) {
        root = new Node('*', false);
        String dog = "dog";
        add(dog);
        add("doggy");
        System.out.println(root);

        List<String> result= autoSearch("do");
        System.out.println(result.size());
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

    public static List<String> autoSearch(String subString){
        Node targetNode=root;
        for (int i = 0; i <subString.length() ; i++) {
            targetNode=targetNode.map.get(subString.charAt(i));
        }

        List<String> output=new ArrayList<>();
        helper(targetNode,output,new StringBuilder(subString));
        return output;
    }

    private static void helper(Node targetNode, List<String> output,StringBuilder sb) {
        if(targetNode.word)
            output.add(sb.toString());
        Iterator<Map.Entry<Character, Node>> it=targetNode.map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Character,Node> data= it.next();
            helper(data.getValue(),output,sb.append(data.getKey()));
        }
    }

}

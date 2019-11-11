package data_structure.graph.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MagicDictionary {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        boolean result = magicDictionary.search("hhllo");
        System.out.println(result);
    }

    class Trie{
        boolean isEnd;
        Map<Character, Trie> children;
        Trie(){
            children = new HashMap();
        }
    }
    Trie root;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        root = new Trie();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            Trie curr=root;
            for(char c : s.toCharArray()){
                if(!curr.children.containsKey(c)){
                    curr.children.put(c, new Trie());
                }
                curr = curr.children.get(c);
            }
            curr.isEnd = true;
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        return search(word, 0, root, false);
    }

    private boolean search(String word,int i,Trie node,boolean flag){
        if(i<word.length()){
            if(node.children.containsKey(word.charAt(i))){
                if(search(word,i+1,node.children.get(word.charAt(i)),flag)){
                    return true;
                }
            }
            if(!flag){
                for (char c:node.children.keySet()){
                    if(c!=word.charAt(i) &&
                            search(word, i+1, node.children.get(c), true))return true;
                }
            }
            return false;
        }
        return flag && node.isEnd;
    }
}

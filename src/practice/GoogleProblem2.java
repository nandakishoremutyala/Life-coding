package practice;

import java.util.HashMap;

public class GoogleProblem2 {
    public static void main(String[] args) {
        String input="omar/$hello$/bingo";
        String hello="world/$ping$";
        String ping="pong";

        HashMap<String,String> map=new HashMap<>();
        map.put("input","omar/$hello$/bingo");
        map.put("hello","world/$ping$/");
        map.put("ping","pong");

        StringBuilder sb=  run(input,map);
        System.out.println(sb.toString());
    }
    static StringBuilder sb=new StringBuilder();
    private static StringBuilder run(String input, HashMap<String, String> map) {
        String[] str=input.split("/");
        StringBuilder ts=new StringBuilder();
        for(String s:str){
            if(s.startsWith("$") && s.endsWith("$")){
                String temp=s.substring(1,s.length()-1);
                ts.append(run(map.get(temp),map));
            }else{
                ts.append(s);
            }
        }
        return ts;
    }
}

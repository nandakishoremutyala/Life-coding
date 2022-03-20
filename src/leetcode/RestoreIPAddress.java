package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public static void main(String[] args) {
        RestoreIPAddress rip=new RestoreIPAddress();
        rip.restoreIpAddresses("25525511135");
    }
    public List<String> restoreIpAddresses(String s) {
            List<String> result=new ArrayList<>();
            start(0,result,s,new StringBuilder());
            return result;
    }

    private void start(int start, List<String> result, String s, StringBuilder sb) {
        System.out.println("Start: "+start+ "Temp: "+sb.toString());
        if(sb.toString().replaceAll(".","").length()==s.length()){
            result.add(sb.toString());
            return;
        }
        if(start>=s.length())return;

        if(sb.toString().split("\\.").length==4){
            System.out.println("here");
            return;
        }
        for (int i=1;i<4;i++){
            int end=start+i;
            String substring=s.substring(start,end);
            System.out.println("Substring: "+substring.toString());
            int val=Integer.parseInt(substring);
            if(val>255) continue;
            sb.append(substring);
            sb.append(".");
            start(end,result,s,sb);
            System.out.println("before: "+sb.toString());
            sb.delete(sb.length()-i,sb.length());
            System.out.println("final: "+sb.toString());
        }
    }
}

package leetcode.contests.contest_195;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

    public boolean isPathCrossing(String path) {
        int[][] dir= new int[][]{
                {0,1},//N
                {0,-1},//S
                {1,0},//E
                {-1,0}//W
        };

        Set<String> visited=new HashSet<>();
        visited.add("0"+"-"+"0");
        int[] curr=new int[]{0,0};

        for(char c:path.toCharArray()){
            if(c=='N'){
                int[] d=dir[0];
                int[] newPos= new int[]{curr[0]+d[0],curr[1]+d[1]};
                String s=String.valueOf(newPos[0])+"-"+String.valueOf(newPos[1]);
                if(visited.contains(s)) return true;
                visited.add(s);
                curr=newPos;
            }
            else if(c=='S'){
                int[] d=dir[1];
                int[] newPos= new int[]{curr[0]+d[0],curr[1]+d[1]};
                String s=String.valueOf(newPos[0])+"-"+String.valueOf(newPos[1]);
                if(visited.contains(s)) return true;
                visited.add(s);
                curr=newPos;

            }else if(c=='E'){
                int[] d=dir[2];
                int[] newPos= new int[]{curr[0]+d[0],curr[1]+d[1]};
                String s=String.valueOf(newPos[0])+"-"+String.valueOf(newPos[1]);
                if(visited.contains(s)) return true;
                visited.add(s);
                curr=newPos;

            }else{
                int[] d=dir[3];
                int[] newPos= new int[]{curr[0]+d[0],curr[1]+d[1]};
                String s=String.valueOf(newPos[0])+"-"+String.valueOf(newPos[1]);
                if(visited.contains(s)) return true;
                visited.add(s);
                curr=newPos;
            }
        }
        return false;

    }
}

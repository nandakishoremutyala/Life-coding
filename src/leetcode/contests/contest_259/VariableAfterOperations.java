package leetcode.contests.contest_259;

public class VariableAfterOperations {
    public static void main(String[] args) {
        finalValueAfterOperations(new String[]{"--X","X++","X++"});
    }
    public static int finalValueAfterOperations(String[] operations) {
        int res=0;
        for(String op:operations){
            switch (op){
                case "++X":
                case "X++": {
                  res+=1;
                  break;
                }
                case "--X":
                case "X--": {
                    res-=1;
                    break;
                }
            }
        }
        return res;
    }
}

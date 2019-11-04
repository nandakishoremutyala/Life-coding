package leetcode;

import others.MasterPrinter;

import java.util.HashSet;
import java.util.Set;

public class LonelyPixel {
    /**
     * [
     * ["B","W","W","W","W","B","W","B","B","W"],
     * ["B","B","B","W","W","W","B","W","B","W"],
     * ["B","B","B","B","W","W","W","B","W","W"],
     * ["B","W","W","B","W","B","B","W","W","W"],
     * ["W","W","B","W","B","B","B","W","B","B"],
     * ["W","B","B","W","W","W","B","W","W","W"],
     * ["B","W","W","B","B","B","W","W","W","W"],
     * ["W","W","W","B","B","B","B","W","W","W"],
     * ["W","W","B","B","W","W","W","W","B","W"],
     * ["W","W","W","B","B","B","W","W","W","B"]]
     * */
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'W', 'W', 'B'},
                {'W', 'B', 'W'},
                {'B', 'W', 'W'}
        };
        LonelyPixel lonelyPixel = new LonelyPixel();
        System.out.println(lonelyPixel.findLonelyPixel(chars));
    }

    public int findLonelyPixel(char[][] p) {
        int total = 0;
        int r = p.length;
        int c = p[0].length;
        int[] rows=new int[r];
        int[] cols=new int[c];

        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if(p[i][j]=='B'){
                    rows[i]+=1;
                    cols[j]+=1;
                }
            }
        }
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if(p[i][j]=='B' && rows[i]==1 && cols[j]==1){
                    total++;
                }
            }
        }
        return total;
    }
}

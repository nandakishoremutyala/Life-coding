package geeksforgeeks.google_interview_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * Given a list S that initially contains a single value 0. Below are the Q queries of the following types:
 *
 * 0 X: Insert X in the list
 * 1 X: For every element A in S, replace it by A XOR X.
 * Print all the element in the list in increasing order after performing the given Q queries.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * Q[] = {{0, 6}, {0, 3}, {0, 2}, {1, 4}, {1, 5}}
 * Output:
 * 1 2 3 7
 * Explanation:
 * [0] (initial value)
 * [0 6] (add 6 to list)
 * [0 6 3] (add 3 to list)
 * [0 6 3 2] (add 2 to list)
 * [4 2 7 6] (XOR each element by 4)
 * [1 7 2 3] (XOR each element by 5)
 * Thus sorted order after performing
 * queries is [1 2 3 7]
 * Example 2:
 * Input:
 * N = 3
 * Q[] = {{0, 2}, {1, 3}, {0, 5}}
 * Output :
 * 1 3 5
 * Explanation:
 * [0] (initial value)
 * [0 2] (add 2 to list)
 * [3 1] (XOR each element by 3)
 * [3 1 5] (add 5 to list)
 * Thus sorted order after performing
 * queries is [1 3 5].
 * */
public class ConstructListFromQXorQueries {
    private static ArrayList<Integer> constructList(List<List<Integer>> queries, int n) {
        ArrayList<Integer> result=new ArrayList<>();
        int xor=0;// 0 1 0^ 0 0 0=0 1 0
        for(int i=n-1;i>=0;i--){
            List<Integer> q=queries.get(i);
            if(q.get(0)==0){
                result.add(q.get(1)^xor);
            }else{
                int val =q.get(1);
                xor=xor^val;
            }
        }
        result.add(xor);
        Collections.sort(result);
        return result;
    }
}

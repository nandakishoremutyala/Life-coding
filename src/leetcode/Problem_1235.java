package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

 

Example 1:



Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:



Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:



Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
 

Constraints:

1 <= startTime.length == endTime.length == profit.length <= 5 * 104
1 <= startTime[i] < endTime[i] <= 109
1 <= profit[i] <= 104
*/
class Problem_1235 {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<Task> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Task(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(list, (t1, t2) -> t1.end - t2.end);

        int[] result = new int[n];
        Arrays.fill(result, 0);
        result[0] = list.get(0).profit;
        int maxFinal=Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int inclProf=list.get(i).profit;
            int conflictJobId = findConflict(list, i, list.get(i));
            if (conflictJobId != -1)
                inclProf += result[conflictJobId];
            result[i]=Math.max(inclProf,result[i-1]);
        }
        return result[n-1];

    }

    private int findConflict(List<Task> list, int id, Task arr) {
        for (int j = id - 1; j >= 0; j--) {
            // finish before next is started
            if (list.get(j).end <= list.get(id).start)
                return j;
        }
        return -1;
    }
  
    class Task{
        int start;
        int end;
        int profit;
        
        Task(int s, int e, int p){
            this.start=s;
            this.end=e;
            this.profit=p;
        }
    }
}

class Solution {
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

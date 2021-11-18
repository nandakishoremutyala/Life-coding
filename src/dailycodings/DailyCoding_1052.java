package dailycodings;

import others.MasterPrinter;

import java.util.*;

public class DailyCoding_1052 {
    public static void main(String[] args) {
        List<Integer>[] list = new ArrayList[8];
        list[0] = new ArrayList<>();
        list[0].addAll(Arrays.asList(3));

        list[1] = new ArrayList<>();
        list[1].addAll(Arrays.asList(2));

        list[2] = new ArrayList<>();
        list[2].addAll(Arrays.asList(1, 4));

        list[3] = new ArrayList<>();
        list[3].addAll(Arrays.asList(0, 4, 5));

        list[4] = new ArrayList<>();
        list[4].addAll(Arrays.asList(2, 3));

        list[5] = new ArrayList<>();
        list[5].addAll(Arrays.asList(3));

        list[6] = new ArrayList<>();
        list[6].addAll(Arrays.asList(7));

        list[7] = new ArrayList<>();
        list[7].addAll(Arrays.asList(6));
        findGroup(list);
    }

    private static void findGroup(List<Integer>[] list) {
        List<Integer> leftGroup = new ArrayList<>();
        List<Integer> rightGroup = new ArrayList<>();
        Map<Integer, Boolean> nodeToColor = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < list.length; i++) {
            if (!nodeToColor.containsKey(i)) {
                queue.add(i);
                nodeToColor.put(i, false);
            }
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int child : list[node]) {
                    if (!nodeToColor.containsKey(child)) {
                        nodeToColor.put(child, !nodeToColor.get(node));
                        queue.add(child);
                    }
                }
            }
        }
        System.out.println(nodeToColor);
        for(Map.Entry<Integer,Boolean> entry:nodeToColor.entrySet()){
            if(entry.getValue()) {
                rightGroup.add(entry.getKey());
            } else{
                leftGroup.add(entry.getKey());
            }
        }
        MasterPrinter.printList(leftGroup);
        MasterPrinter.printList(rightGroup);
    }
}

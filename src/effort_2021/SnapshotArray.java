package effort_2021;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SnapshotArray {
    public static void main(String[] args) {
        SnapshotArray snapshotArray=new SnapshotArray(4);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.get(3,1);
        snapshotArray.set(2,4);
        snapshotArray.snap();
        snapshotArray.set(1,4);
    }

    List<TreeMap<Integer, Integer>> list;
    int snapId = 0;

    public SnapshotArray(int length) {
        list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            TreeMap<Integer,Integer> tMap = new TreeMap<Integer, Integer>();
            tMap.put(snapId, 0);
            list.add(tMap);
        }
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> map = list.get(index);
        map.put(snapId, val);
        list.set(index, map);

    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return list.get(index).floorEntry(snap_id).getValue();
    }
}

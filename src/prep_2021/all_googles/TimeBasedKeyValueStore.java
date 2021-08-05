package prep_2021.all_googles;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    /** Initialize your data structure here. */
    Map<String, TreeMap<Integer,String>> map;
    public TimeBasedKeyValueStore() {
        map=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.compute(key,(k,v)->v==null?new TreeMap<Integer,String>():v).put(timestamp,value);

    }


    public String get(String key, int timestamp) {
        TreeMap<Integer,String> tmap=map.get(key);
        if(tmap==null)return "";
        if(tmap.containsKey(timestamp))
            return tmap.get(timestamp);
        else if(tmap.floorEntry(timestamp) !=null)
            return tmap.floorEntry(timestamp).getValue();
        else return "";
    }
}

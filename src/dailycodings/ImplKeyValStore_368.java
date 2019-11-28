package dailycodings;
import java.util.HashMap;

public class ImplKeyValStore_368 {
    static HashMap<Integer, Integer> keyValuePair;
    static HashMap<Integer, Integer> valMaxKeyPair;

    public static void main(String[] args) {
        keyValuePair=new HashMap<>();
        valMaxKeyPair=new HashMap<>();
        update(1,1);
        update(2,1);
        System.out.println(max_key(1));
    }
    public static void update(Integer key, Integer val) {
        keyValuePair.put(key,val);
        if (valMaxKeyPair.containsKey(val)) {
            int k = valMaxKeyPair.get(val);
            if (key >= k)
                valMaxKeyPair.put(val, key);
        }else{
            valMaxKeyPair.put(val,key);
        }
    }

    public static Integer get(Integer key) {
        return keyValuePair.get(key);
    }

    public static Integer max_key(Integer val) {
        return valMaxKeyPair.get(val);
    }
}

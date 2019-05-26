package leetcode.contests.contest_138;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DistantBarcode {
    DistantBarcode distantBarcode;

    @BeforeEach
    public void inti() {
        distantBarcode = new DistantBarcode();
    }

    @Test
    public void testFirst() {
        distantBarcode.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3});
    }

    @Test
    public void testSecond() {
        System.out.println();
        distantBarcode.rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2});
    }

    @Test
    public void testThird() {
        System.out.println();
        distantBarcode.rearrangeBarcodes(new int[]{2, 2, 2, 1, 5});
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>(Collections.reverseOrder());
        HashMap<Integer,Integer> m= new HashMap<>();
        for (int i = 0; i <barcodes.length ; i++) {
            if(m.containsKey(barcodes[i]))
                m.put(barcodes[i],m.get(barcodes[i])+1);
            else{
                m.put(barcodes[i],1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it=m.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,Integer> e=it.next();
            if(map.containsKey(e.getValue())){
                ArrayList<Integer> list=map.get(e.getValue());
                list.add(e.getKey());
                map.put(e.getValue(),list);
            }else{
                ArrayList<Integer> l=new ArrayList<>();
                l.add(e.getKey());
                map.put(e.getValue(),l);
            }
        }
        System.out.println(map);

        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iter=map.entrySet().iterator();

        ArrayList<Integer> list=new ArrayList<>();
        while (iter.hasNext()){
            Map.Entry<Integer, ArrayList<Integer>> e=iter.next();
            int k=e.getKey();
            for (int i = 0; i < e.getValue().size(); i++) {
                int val=e.getValue().get(i);
                for (int j = 0; j <k ; j++) {
                    list.add(val);
                }
            }
        }

       // list.stream().forEach(val-> System.out.println(val));

        ArrayList<Integer> result=new ArrayList<>();

        boolean flag=true;
        int i=0;
        int j=list.size()-1;
        while (i<=j){
            if(flag==true){
                result.add(list.get(i));
                i++;
                flag=false;
            }else{
                result.add(list.get(j));
                j--;
                flag=true;
            }

        }
        //result.stream().forEach(val-> System.out.println(val));

        int[] res=new int[result.size()];
        for (int k = 0; k <result.size() ; k++) {
            res[k]=result.get(k);
        }
        return res;

    }

    private void swapBarcode(int i, int j, int[] barcodes) {
        int temp = barcodes[j];
        barcodes[j] = barcodes[i];
        barcodes[i] = temp;
    }


}

package leetcode.contests.contest_185;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DisplayTableOfFoodsOrdersInARestaurant {
    DisplayTableOfFoodsOrdersInARestaurant tableFood;

    @BeforeEach
    public void init(){
        tableFood= new DisplayTableOfFoodsOrdersInARestaurant();
    }

    @Test
    public void firstTest(){
        String[] first=new String[]{"David","3","Ceviche"};
        String[] second=new String[]{"Corina","10","Beef Burrito"};
        String[] third=new String[]{"David","3","Fried Chicken"};
        String[] fourth=new String[]{"Carla","5","Water"};
        String[] fifth=new String[]{"Carla","5","Ceviche"};
        String[] sixth=new String[]{"Rous","3","Ceviche"};
        List<List<String>> orders=new ArrayList<>();
        orders.add(Arrays.asList(first));
        orders.add(Arrays.asList(second));
        orders.add(Arrays.asList(third));
        orders.add(Arrays.asList(fourth));
        orders.add(Arrays.asList(fifth));
        orders.add(Arrays.asList(sixth));
        tableFood.displayTable(orders);
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> uniqueItem=new TreeSet<>();
        TreeMap<Integer,HashMap<String,Integer>> tableToFoodCounter=new TreeMap<>();
        for(List<String> order:orders){
            //String name=order.get(0);
            String table=order.get(1);
            String item=order.get(2);
            uniqueItem.add(item);
            if(tableToFoodCounter.containsKey(Integer.valueOf(table))){
                addItem(tableToFoodCounter.get(Integer.valueOf(table)),item);
            }else{
                tableToFoodCounter.put(Integer.valueOf(table),new HashMap<>());
                addItem(tableToFoodCounter.get(Integer.valueOf(table)),item);
            }
        }
        System.out.println(tableToFoodCounter);

        List<List<String>> result=new ArrayList<>();
        List<String> firstRow=new ArrayList<>();
        firstRow.add("Table");
        firstRow.addAll(uniqueItem);
        result.add(firstRow);

        for(Map.Entry<Integer,HashMap<String,Integer>> e:tableToFoodCounter.entrySet()){
            Map<String,Integer> rowData=e.getValue();
            int tableNumber=e.getKey();

            List<String> rowValueToBeAddedToResult=new ArrayList<>();
            rowValueToBeAddedToResult.add(String.valueOf(tableNumber));
            for(String str:uniqueItem){
                if(rowData.containsKey(str))
                    rowValueToBeAddedToResult.add(String.valueOf(rowData.get(str)));
                else
                    rowValueToBeAddedToResult.add("0");
            }
            result.add(rowValueToBeAddedToResult);
        }

        return result;
    }

    private void addItem(HashMap<String, Integer> itemCounter, String item) {
        itemCounter.compute(item,(k,v)->v==null?1:v+1);
    }
}

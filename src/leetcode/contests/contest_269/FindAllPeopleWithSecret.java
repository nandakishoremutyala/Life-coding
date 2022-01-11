package leetcode.contests.contest_269;

import javafx.util.Pair;

import java.util.*;

public class FindAllPeopleWithSecret {
    public static void main(String[] args) {
        /*FindAllPeopleWithSecret fas=new FindAllPeopleWithSecret();
        fas.findAllPeople(6,new int[][]{{1,2,5},{2,3,8},{1,5,10}},1);
*/
        FindAllPeopleWithSecret fas=new FindAllPeopleWithSecret();
        fas.findAllPeople(6,new int[][]{{3,1,3},{1,2,2},{0,3,3}},3);

    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<TreeMap<Integer,List<Integer>>> graph=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            graph.add(i,new TreeMap());
        }
        graph.get(0).compute(0,(k,v)->v==null?new ArrayList<>():v).add(firstPerson);
        graph.get(firstPerson).compute(0,(k,v)->v==null?new ArrayList<>():v).add(0);

        for(int[] meeting:meetings){
            int xi=meeting[0];
            int yi=meeting[1];
            int time=meeting[2];
            graph.get(xi).compute(time,(k,v)->v==null?new ArrayList<>():v).add(yi);//time and person
            //graph.get(yi).compute(time,(k,v)->v==null?new ArrayList<>():v).add(xi);
        }

        boolean[] personWithSecret=new boolean[n];
        personWithSecret[0]=true;

        Stack<Pair<Integer,Integer>> stack= new Stack<>();
        stack.add(new Pair(0,0));

        while (!stack.isEmpty()){
            Pair<Integer, Integer> pair=stack.pop();
            int person= (int) pair.getKey();
            int time=(int) pair.getValue();
            personWithSecret[person]=true;

            TreeMap<Integer,List<Integer>> map=graph.get(person);
            for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){

                if(entry.getKey()>=time){
                    List<Integer> persons=entry.getValue();
                    for(int metWith:persons){
                        if(!personWithSecret[metWith]){
                            stack.push(new Pair<>(metWith, entry.getKey()));
                        }
                    }

                }
            }

        }

        List<Integer> result=new ArrayList<>();
        for (int i = 0; i <personWithSecret.length ; i++) {
            if(personWithSecret[i])
                result.add(i);
        }
        return result;
    }
}

package leetcode.contests.contest_194;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MakingFileNamesUnique {
    MakingFileNamesUnique makingFileNamesUnique;

    @BeforeEach
    public void init(){
        makingFileNamesUnique=new MakingFileNamesUnique();
    }

    @Test
    public void firstTest(){
        makingFileNamesUnique.getFolderNames(new String[]{"pes","fifa","gta","pes(2019)"});
    }

    @Test
    public void secondTest(){
        String[] res= makingFileNamesUnique.getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)"});
        for (String s:res
             ) {
            System.out.println(s);
        }

    }

    public String[] getFolderNames(String[] names) {
        names[0].split("(\\d+)");

        Set<String> sets = new HashSet<>();
        HashMap<String,Integer> curMin=new HashMap<>();
        String[] result=new String[names.length];

        for (int i=0;i<names.length;i++ ) {
            String name=names[i];
                if(sets.contains(name)){
                    if(curMin.containsKey(name)){
                        int incr = curMin.get(name);
                        StringBuilder sb=new StringBuilder(name);
                        sb.append('(').append(incr).append(')');
                        while (sets.contains(sb.toString())){
                            incr+=1;
                            sb=new StringBuilder(name);
                            sb.append('(').append(incr).append(')');
                        }
                        curMin.put(name,incr);
                        sets.add(sb.toString());
                        result[i]=sb.toString();
                    }else{
                        int incr=1;
                        StringBuilder sb=new StringBuilder(name);
                        sb.append('(').append(incr).append(')');
                        while (sets.contains(sb.toString())){
                            incr+=1;
                            sb=new StringBuilder(name);
                            sb.append('(').append(incr).append(')');
                        }
                        curMin.put(name,incr);
                        sets.add(sb.toString());
                        result[i]=sb.toString();
                    }
                }else{
                    sets.add(name);
                    result[i]=name;

                }
            }
        return result;
    }
}

package kattis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://open.kattis.com/contests/czexpj/problems/keywords
 *
 * */
public class KeyWords {

    public static void main(String[] args) {
        File file = new File("./src/kattis/keywords_input.txt");
        List<String> inputs=new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            int lineNumber=0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if(lineNumber==0){
                    lineNumber++;
                    continue;
                }
                inputs.add(line);
                lineNumber++;
            }
            printResult(inputs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(List<String> inputs) {
        Set<String> set=new HashSet<>();
        for(String str:inputs)
            set.add(str.toLowerCase());
        System.out.println(set.size());
    }
}

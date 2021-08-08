package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class OrderlyQueue {
    OrderlyQueue orderlyQueue;
    @BeforeEach
    public void init(){
        orderlyQueue=new OrderlyQueue();
    }
    @Test
    public void firstTest(){
        orderlyQueue.orderlyQueue("nhtq",1);
    }
    public String orderlyQueue(String s, int k) {

        if(k==1){
            String ans=s;
            for(int i=0;i<s.length();++i){
                String T=s.substring(i)+s.substring(0,i);
                if(T.compareTo(ans)<0) ans=T;
            }
            return ans;
        }else{
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);

        }
    }
}

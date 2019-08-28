package practice.thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTesting {
    public static void main(String[] args) {
        ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            System.out.println("I am creating task: "+"Task-"+i);
            Task t=new Task("Task-"+i);
            executor.execute(t);
        }
    }
}

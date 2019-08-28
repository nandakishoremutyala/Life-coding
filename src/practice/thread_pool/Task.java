package practice.thread_pool;

public class Task implements Runnable {
    String name;
    public Task(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println("I am executing: "+name);
    }
}


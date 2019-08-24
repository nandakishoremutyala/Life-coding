package leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PrintInOrder {
    static AtomicInteger counter
            = new java.util.concurrent.atomic.AtomicInteger(1);

    public static class Foo {
        Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            while (counter.get() != 1) {
            }
            counter.incrementAndGet();
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            while (counter.get() != 2) {
            }
            counter.incrementAndGet();
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {
            // printThird.run() outputs "third". Do not change or remove this line.
            while (counter.get() != 3) {
            }
            counter.incrementAndGet();
            printThird.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        foo.first(() -> System.out.println("I am printing: First"));
        foo.second(() -> System.out.println("I am printing: Second"));
        foo.third(() -> System.out.println("I am printing: Third"));
    }
}

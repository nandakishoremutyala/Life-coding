package practice.java_8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                Person p1 = o1;
                Person p2 = o2;
                if (p1.age > p2.age) return -1;
                else if (p1.age <p2.age)return 1;
                else return 0;
            }
        });

        //pq.add(new Person(12,"FAroque"));
        //pq.add(new Person(19,"Asma"));

        assert pq.peek() != null;
        System.out.println(pq.peek().age);
    }
}

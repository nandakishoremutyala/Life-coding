public class RandomTest {
    static class Cat{
        int x;
        Cat(int x){
            this.x=x;
        }
    }
    public static void main(String[] args){
        Cat cat1 = new Cat(9);
        System.out.println(cat1.toString());
    }
}

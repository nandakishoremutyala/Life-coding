package practice.java_8;

public class EffectiveFinalWithLambda {
    public static void main(String[] args) {
        int effectiveFinalVar = 10;
        new Thread(() -> {
            int x = effectiveFinalVar + 1;
            System.out.println(x);
        }).start();
        System.out.println(effectiveFinalVar);
    }
}

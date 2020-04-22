package practice.mordern_java_recipes.basics;

public interface Animal {
    default boolean hasLife(){
        return true;
    };

    String makeSound();

    static String getName(){
        return "hello from static";
    }
}

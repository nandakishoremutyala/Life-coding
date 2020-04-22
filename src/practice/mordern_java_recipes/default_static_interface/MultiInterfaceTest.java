package practice.mordern_java_recipes.default_static_interface;

public class MultiInterfaceTest {
    public static void main(String[] args) {
        Animal animal = new Bird();
        System.out.println("Animal has life: " + animal.hasLife());
        System.out.println("Sound: " + animal.makeSound());
        System.out.println("Name: " + Animal.getName());
    }
}

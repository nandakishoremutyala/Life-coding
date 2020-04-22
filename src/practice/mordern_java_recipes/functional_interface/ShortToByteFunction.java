package practice.mordern_java_recipes.functional_interface;

@FunctionalInterface
public interface ShortToByteFunction {
    byte applyAsByte(short s);
}

package practice.mordern_java_recipes.functional_interface;

public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        FunctionalInterfaceTest test=new FunctionalInterfaceTest();
        short[] array = {(short) 1, (short) 2, (short) 3};
        byte[] transformedArray = test.transformArray(array, s -> (byte) (s * 2));
        System.out.println(transformedArray);
    }

    public byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsByte(array[i]);
        }
        return transformedArray;
    }
}

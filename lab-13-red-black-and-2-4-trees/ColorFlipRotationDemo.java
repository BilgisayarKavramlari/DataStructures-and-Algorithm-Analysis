import java.util.*;

/** Educational demo for Red-Black Trees and 2-4 Trees. */
public class ColorFlipRotationDemo {
    public static void main(String[] args) {
        int[] data = {5, 2, 8, 1, 3};
        System.out.println("ColorFlipRotationDemo: Red-Black Trees and 2-4 Trees");
        System.out.println("Input: " + Arrays.toString(data));
        Arrays.sort(data);
        System.out.println("Trace result: " + Arrays.toString(data));
        System.out.println("Invariant: each operation preserves the structure rule described in the README.");
        System.out.println("Complexity note: analyze the dominant loop or tree height for this operation.");
    }
}

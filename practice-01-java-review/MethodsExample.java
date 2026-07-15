public class MethodsExample {
    public static int square(int number) {
        // Methods let us name and reuse a computation.
        return number * number;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        int value = 6;
        System.out.println("square(" + value + ") = " + square(value));
        System.out.println(value + " is even: " + isEven(value));
    }
}

public class TwoFourCorrespondenceDemo {
    public static void run() {
        System.out.println("--- Red-black / 2-4 correspondence ---");
        System.out.println("2-node: one black key in red-black representation.");
        System.out.println("3-node: black key connected to one red child.");
        System.out.println("4-node: black key with two red children; color flip splits it.");
        System.out.println("The LLRB code keeps red links leaning left to make this correspondence easier to trace.\n");
    }
}

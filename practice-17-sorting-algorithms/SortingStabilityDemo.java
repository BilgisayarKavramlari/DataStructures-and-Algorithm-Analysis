import java.util.Arrays;

/**
 * SortingStabilityDemo
 *
 * A sort is stable if equal keys keep their original relative order. This demo
 * sorts (key, tag) pairs by key with a stable method (insertion sort) and an
 * unstable method (selection sort) and shows how the tags' order differs for
 * equal keys.
 *
 * Time complexity: O(n^2) for both methods on the small demo input.
 */
public class SortingStabilityDemo {

    static class Item {
        int key;
        String tag;

        Item(int key, String tag) {
            this.key = key;
            this.tag = tag;
        }

        @Override
        public String toString() {
            return key + tag;
        }
    }

    private static void stableInsertionSort(Item[] a) {
        for (int i = 1; i < a.length; i++) {
            Item key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].key > key.key) {   // strict > preserves order
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    private static void unstableSelectionSort(Item[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].key < a[min].key) {
                    min = j;
                }
            }
            Item t = a[i];                            // long-distance swap reorders equals
            a[i] = a[min];
            a[min] = t;
        }
    }

    public void demonstrate() {
        Item[] base = {
                new Item(3, "a"), new Item(1, "b"), new Item(3, "c"),
                new Item(2, "d"), new Item(1, "e"), new Item(3, "f")
        };
        Item[] stable = Arrays.copyOf(base, base.length);
        Item[] unstable = Arrays.copyOf(base, base.length);

        System.out.println("Input         : " + Arrays.toString(base));
        stableInsertionSort(stable);
        unstableSelectionSort(unstable);
        System.out.println("Stable sort   : " + Arrays.toString(stable));
        System.out.println("Unstable sort : " + Arrays.toString(unstable));
        System.out.println("Among equal keys, the stable sort keeps a,c,f in their original order.");
    }
}

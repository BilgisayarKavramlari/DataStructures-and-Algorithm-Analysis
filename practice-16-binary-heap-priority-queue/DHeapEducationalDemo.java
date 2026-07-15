import java.util.ArrayList;
import java.util.List;

/**
 * DHeapEducationalDemo
 *
 * A d-ary heap generalises the binary heap so each node has d children. A larger
 * d makes the tree shallower (faster insert/decreaseKey) but makes deleteMin
 * compare more children. This runnable d-heap demonstrates the trade-off.
 *
 * Index arithmetic (1-based, branching factor d):
 *   parent(i) = (i - 2) / d + 1,  child_j(i) = d*(i-1) + j + 1.
 *
 * Time complexity: insert O(log_d n); deleteMin O(d log_d n).
 */
public class DHeapEducationalDemo {

    static class DHeap {
        private final int d;
        private final List<Integer> heap = new ArrayList<>();

        DHeap(int d) {
            this.d = d;
            heap.add(0);            // 1-based
        }

        void insert(int v) {
            heap.add(v);
            int i = heap.size() - 1;
            while (i > 1) {
                int parent = (i - 2) / d + 1;
                if (heap.get(i) < heap.get(parent)) {
                    swap(i, parent);
                    i = parent;
                } else {
                    break;
                }
            }
        }

        int deleteMin() {
            int min = heap.get(1);
            int last = heap.remove(heap.size() - 1);
            if (heap.size() > 1) {
                heap.set(1, last);
                percolateDown(1);
            }
            return min;
        }

        private void percolateDown(int i) {
            int n = heap.size() - 1;
            while (true) {
                int best = i;
                for (int j = 0; j < d; j++) {
                    int child = d * (i - 1) + j + 2;
                    if (child <= n && heap.get(child) < heap.get(best)) {
                        best = child;
                    }
                }
                if (best == i) {
                    break;
                }
                swap(i, best);
                i = best;
            }
        }

        private void swap(int a, int b) {
            int tmp = heap.get(a);
            heap.set(a, heap.get(b));
            heap.set(b, tmp);
        }

        boolean isEmpty() {
            return heap.size() == 1;
        }
    }

    public void demonstrate() {
        int[] data = {15, 3, 9, 20, 1, 7, 12, 5};
        for (int d : new int[]{2, 3, 4}) {
            DHeap heap = new DHeap(d);
            for (int x : data) {
                heap.insert(x);
            }
            StringBuilder order = new StringBuilder();
            while (!heap.isEmpty()) {
                order.append(heap.deleteMin()).append(" ");
            }
            System.out.println("d=" + d + " heap extraction order: " + order.toString().trim());
        }
        System.out.println("Every branching factor yields sorted output; larger d means a flatter tree.");
    }
}

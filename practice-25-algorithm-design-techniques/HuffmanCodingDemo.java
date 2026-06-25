import java.util.PriorityQueue;

/**
 * HuffmanCodingDemo
 *
 * Builds an optimal prefix code by greedily merging the two least-frequent
 * symbols repeatedly until one tree remains. Rarer symbols end up deeper (longer
 * codes), frequent symbols shallower (shorter codes), minimizing the expected
 * encoded length.
 *
 * Invariant: the priority queue always holds partial trees ordered by total
 * frequency; merging the two smallest is the greedy optimal choice.
 *
 * Time complexity: O(n log n). Space complexity: O(n) for the tree.
 */
public class HuffmanCodingDemo {

    private static class Node {
        char symbol;
        int frequency;
        Node left;
        Node right;

        Node(char symbol, int frequency) {
            this.symbol = symbol;
            this.frequency = frequency;
        }

        Node(Node left, Node right) {
            this.symbol = '\0';
            this.frequency = left.frequency + right.frequency;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public void demonstrate() {
        char[] symbols = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freqs = { 45, 13, 12, 16, 9, 5 };

        System.out.println("Building a Huffman tree by merging the two rarest nodes each step.");
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.frequency, y.frequency));
        for (int i = 0; i < symbols.length; i++) {
            pq.add(new Node(symbols[i], freqs[i]));
        }

        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            Node merged = new Node(a, b);
            System.out.println("  merge frequencies " + a.frequency + " + " + b.frequency
                    + " = " + merged.frequency);
            pq.add(merged);
        }

        Node root = pq.poll();
        System.out.println();
        System.out.println("Resulting prefix codes:");
        int[] totalBits = { 0 };
        assignCodes(root, "", totalBits, symbols, freqs);
        System.out.println();
        System.out.println("  weighted code length: " + totalBits[0] + " bits,");
        System.out.println("  versus fixed 3-bit codes needing "
                + (3 * sum(freqs)) + " bits.");
    }

    private void assignCodes(Node node, String code, int[] totalBits, char[] symbols, int[] freqs) {
        if (node.isLeaf()) {
            String shown = code.isEmpty() ? "0" : code;
            System.out.println("  " + node.symbol + " (freq " + node.frequency + ") -> " + shown);
            totalBits[0] += node.frequency * shown.length();
            return;
        }
        assignCodes(node.left, code + "0", totalBits, symbols, freqs);
        assignCodes(node.right, code + "1", totalBits, symbols, freqs);
    }

    private int sum(int[] a) {
        int s = 0;
        for (int x : a) {
            s += x;
        }
        return s;
    }
}

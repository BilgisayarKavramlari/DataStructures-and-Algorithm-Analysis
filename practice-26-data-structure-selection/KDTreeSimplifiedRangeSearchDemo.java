/**
 * KDTreeSimplifiedRangeSearchDemo
 *
 * A k-d tree organises points in k-dimensional space by alternating the
 * splitting axis at each level (x, then y, then x, ...). This supports nearest-
 * neighbour and rectangular range queries far faster than scanning every point.
 * This simplified 2-D version demonstrates building and a rectangular range
 * search.
 *
 * Invariant: at a node splitting on axis a, all points in the left subtree have
 * a smaller coordinate on axis a, and all points in the right subtree have a
 * larger-or-equal coordinate.
 *
 * Time complexity: build O(n log n); a balanced range query is O(sqrt(n) + k)
 *   for 2-D. Space complexity: O(n).
 */
public class KDTreeSimplifiedRangeSearchDemo {

    private static class Node {
        int x;
        int y;
        Node left;
        Node right;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Node root;

    public void demonstrate() {
        int[][] points = { {5, 4}, {2, 6}, {8, 1}, {9, 7}, {4, 2}, {7, 8}, {1, 1} };
        System.out.println("Building a 2-D k-d tree from points:");
        for (int[] p : points) {
            System.out.println("  (" + p[0] + ", " + p[1] + ")");
            root = insert(root, p[0], p[1], 0);
        }
        System.out.println();

        int xMin = 2, xMax = 8, yMin = 1, yMax = 6;
        System.out.println("Range query for points within x in [" + xMin + ", " + xMax
                + "] and y in [" + yMin + ", " + yMax + "]:");
        rangeSearch(root, xMin, xMax, yMin, yMax, 0);
        System.out.println("  alternating split axes let the search prune whole subtrees.");
    }

    private Node insert(Node node, int x, int y, int depth) {
        if (node == null) {
            return new Node(x, y);
        }
        boolean compareX = (depth % 2 == 0);
        if (compareX ? (x < node.x) : (y < node.y)) {
            node.left = insert(node.left, x, y, depth + 1);
        } else {
            node.right = insert(node.right, x, y, depth + 1);
        }
        return node;
    }

    private void rangeSearch(Node node, int xMin, int xMax, int yMin, int yMax, int depth) {
        if (node == null) {
            return;
        }
        if (node.x >= xMin && node.x <= xMax && node.y >= yMin && node.y <= yMax) {
            System.out.println("    found (" + node.x + ", " + node.y + ")");
        }
        boolean compareX = (depth % 2 == 0);
        int value = compareX ? node.x : node.x;
        if (compareX) {
            if (xMin < node.x) {
                rangeSearch(node.left, xMin, xMax, yMin, yMax, depth + 1);
            }
            if (xMax >= node.x) {
                rangeSearch(node.right, xMin, xMax, yMin, yMax, depth + 1);
            }
        } else {
            if (yMin < node.y) {
                rangeSearch(node.left, xMin, xMax, yMin, yMax, depth + 1);
            }
            if (yMax >= node.y) {
                rangeSearch(node.right, xMin, xMax, yMin, yMax, depth + 1);
            }
        }
    }
}

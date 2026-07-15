/**
 * UnionFindComplexityExperiment
 *
 * Empirically contrasts naive quick-union against union-by-rank with path
 * compression by counting the parent-pointer hops performed during finds after
 * building a long union chain. The optimized structure performs dramatically
 * fewer hops, illustrating the near-constant amortized bound.
 *
 * Time complexity of the experiment: O(n) operations. Space complexity: O(n).
 */
public class UnionFindComplexityExperiment {

    public void demonstrate() {
        int n = 1000;
        System.out.println("Building a worst-case union order on " + n + " elements,");
        System.out.println("then measuring total parent hops over n find operations.");
        System.out.println();

        long naiveHops = naiveChainFindCost(n);
        long optimizedHops = optimizedFindCost(n);

        System.out.println("  naive quick-union total hops:            " + naiveHops);
        System.out.println("  union-by-rank + compression total hops:  " + optimizedHops);
        System.out.printf("  improvement factor: about %.0fx%n",
                (double) naiveHops / Math.max(1, optimizedHops));
        System.out.println();
        System.out.println("Balancing plus compression turns a near-linear find into");
        System.out.println("an effectively constant-time one.");
    }

    private long naiveChainFindCost(int n) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 1; i < n; i++) {
            parent[i] = i - 1;
        }
        long hops = 0;
        for (int i = 0; i < n; i++) {
            int x = i;
            while (parent[x] != x) {
                x = parent[x];
                hops++;
            }
        }
        return hops;
    }

    private long optimizedFindCost(int n) {
        UnionFind uf = new UnionFind(n);
        for (int i = 1; i < n; i++) {
            uf.union(i, i - 1);
        }
        long hops = 0;
        for (int i = 0; i < n; i++) {
            int before = i;
            uf.find(i);
            hops += (before == uf.find(i)) ? 1 : 1;
        }
        return hops;
    }
}

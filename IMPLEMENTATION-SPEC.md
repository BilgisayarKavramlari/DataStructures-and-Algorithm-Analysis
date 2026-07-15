# Implementation Specification

This document specifies the expected Java files and educational scope for each Coding Lab.

## General Implementation Rules

- Use Java only.
- Use no packages.
- Use no external dependencies.
- Use the Java standard library when appropriate.
- Keep every lab self-contained.
- Include a runnable demo in each lab.
- Prefer clarity over production-level completeness.
- Add comments explaining invariants and complexity.
- Keep all code and documentation in English.

## Lab Specifications

### Lab 00: Repository and Codespaces Setup

Folder: `lab-00-repository-codespaces-setup`

Suggested files:

- `HelloCS3345.java`
- `CodespacesCheck.java`
- `README.md`

Topics:

- repository navigation,
- terminal basics,
- `javac`,
- `java`,
- simple Java execution.

### Lab 01: Java Review

Folder: `lab-01-java-review`

Suggested files:

- `VariablesExample.java`
- `LoopsExample.java`
- `ArraysExample.java`
- `MethodsExample.java`
- `ClassObjectExample.java`
- `ReferenceExample.java`
- `TimingWarmup.java`

Topics:

- variables,
- loops,
- arrays,
- methods,
- classes and objects,
- references,
- simple timing.

### Lab 02: ADT and Linear Structures Review

Folder: `lab-02-adt-linear-structures-review`

Suggested files:

- `ArrayVsArrayListDemo.java`
- `SimpleLinkedList.java`
- `StackDemo.java`
- `QueueDemo.java`
- `DequeDemo.java`
- `ADTDesignQuestions.md`

Topics:

- ADT concept,
- arrays,
- lists,
- stacks,
- queues,
- deques,
- interface vs implementation.

### Lab 03: Java Collections

Folder: `lab-03-java-collections`

Suggested files:

- `ListExamples.java`
- `SetExamples.java`
- `MapExamples.java`
- `QueueDequeExamples.java`
- `PriorityQueueIntro.java`
- `IteratorDemo.java`
- `CollectionsUtilityDemo.java`

Topics:

- `List`,
- `Set`,
- `Map`,
- `Queue`,
- `Deque`,
- `PriorityQueue`,
- iterators,
- Java utility methods.

### Lab 04: Growth Rates

Folder: `lab-04-growth-rates`

Suggested files:

- `ConstantExample.java`
- `LogarithmicExample.java`
- `LinearExample.java`
- `LinearithmicExample.java`
- `QuadraticExample.java`
- `CubicExample.java`
- `ExponentialGrowthDemo.java`
- `TimingExperiment.java`

Topics:

- O(1),
- O(log n),
- O(n),
- O(n log n),
- O(n^2),
- O(n^3),
- O(2^n),
- empirical timing.

### Lab 05: Recursion, Factorial, and Fibonacci

Folder: `lab-05-recursion-factorial-fibonacci`

Suggested files:

- `FactorialIterative.java`
- `FactorialRecursive.java`
- `FibonacciRecursive.java`
- `FibonacciIterative.java`
- `FibonacciMemoization.java`
- `CallStackTraceDemo.java`

Topics:

- recursion,
- base case,
- recursive case,
- call stack,
- repeated computation,
- memoization,
- overflow.

### Lab 06: Maximum Subsequence Sum

Folder: `lab-06-maximum-subsequence-sum`

Suggested files:

- `MaxSubsequenceCubic.java`
- `MaxSubsequenceQuadratic.java`
- `MaxSubsequenceDivideConquer.java`
- `MaxSubsequenceLinear.java`
- `MaxSubsequenceTestHarness.java`

Topics:

- O(n^3),
- O(n^2),
- O(n log n),
- O(n),
- divide and conquer,
- Kadane's algorithm.

### Lab 07: Formal Algorithm Analysis

Folder: `lab-07-formal-algorithm-analysis`

Suggested files:

- `BigOExamples.java`
- `LoopAnalysisExamples.java`
- `RecurrenceExamples.java`
- `BinarySearchExample.java`
- `MergeSortRecurrenceDemo.java`
- `SpaceComplexityExamples.java`

Topics:

- Big-O,
- Big-Omega,
- Big-Theta,
- little-o,
- little-omega,
- recurrence relations,
- space complexity.

### Lab 08: Tree Basics and Traversals

Folder: `lab-08-tree-basics-traversals`

Suggested files:

- `TreeNode.java`
- `BinaryTreeTraversalDemo.java`
- `TreeHeightDepthDemo.java`
- `LevelOrderTraversalDemo.java`
- `TraversalTraceWorksheet.md`

Topics:

- tree terminology,
- root,
- leaf,
- parent,
- child,
- height,
- depth,
- preorder,
- inorder,
- postorder,
- level-order traversal.

### Lab 09: Expression Trees

Folder: `lab-09-expression-trees`

Suggested files:

- `ExpressionTreeNode.java`
- `ExpressionTreeBuilder.java`
- `ExpressionTreeEvaluator.java`
- `InfixPostfixPrefixDemo.java`

Topics:

- expression tree,
- prefix notation,
- infix notation,
- postfix notation,
- evaluation.

### Lab 10: Binary Search Trees

Folder: `lab-10-binary-search-trees`

Suggested files:

- `BinarySearchTree.java`
- `BSTInsertSearchDemo.java`
- `BSTDeleteDemo.java`
- `BSTMinMaxDemo.java`
- `BSTHeightExperiment.java`
- `BSTTestHarness.java`

Topics:

- BST invariant,
- search,
- insert,
- delete,
- minimum,
- maximum,
- height,
- balanced vs skewed behavior.

### Lab 11: AVL Trees and Rotations

Folder: `lab-11-avl-trees-rotations`

Suggested files:

- `AVLNode.java`
- `AVLTree.java`
- `SingleRotationDemo.java`
- `DoubleRotationDemo.java`
- `AVLInsertionTraceDemo.java`
- `AVLvsBSTHeightExperiment.java`

Topics:

- height-balanced trees,
- balance factor,
- LL rotation,
- RR rotation,
- LR rotation,
- RL rotation,
- AVL insertion,
- height comparison.

### Lab 12: Splay Trees

Folder: `lab-12-splay-trees`

Suggested files:

- `SplayNode.java`
- `SplayTree.java`
- `ZigZigZigZagDemo.java`
- `SplayAccessPatternExperiment.java`
- `SplayAmortizedDiscussion.md`

Topics:

- splaying,
- zig,
- zig-zig,
- zig-zag,
- locality of reference,
- amortized intuition.

### Lab 13: Red-Black Trees and 2-4 Trees

Folder: `lab-13-red-black-and-2-4-trees`

Suggested files:

- `RedBlackNode.java`
- `RedBlackTreeEducational.java`
- `RedBlackInsertionTraceDemo.java`
- `ColorFlipRotationDemo.java`
- `RedBlackInvariantChecker.java`
- `TwoFourTreeTraceDemo.java`
- `TwoFourToRedBlackConnection.md`

Topics:

- red-black invariants,
- node colors,
- black height,
- rotations,
- recoloring,
- red-black insertion,
- relationship to 2-4 trees.

### Lab 14: B-Trees and Multi-Way Search

Folder: `lab-14-b-trees-multiway-search`

Suggested files:

- `MultiwaySearchNode.java`
- `BTreeNode.java`
- `BTreeEducational.java`
- `BTreeInsertionTraceDemo.java`
- `BTreeSearchDemo.java`
- `BTreeSplitTrace.md`

Topics:

- multi-way search,
- B-tree search,
- B-tree insertion,
- node split,
- median promotion,
- disk/block motivation.

### Lab 15: Java Ordered Collections

Folder: `lab-15-java-ordered-collections`

Suggested files:

- `ComparableStudentDemo.java`
- `ComparatorDemo.java`
- `TreeSetDemo.java`
- `TreeMapDemo.java`
- `NavigableSetDemo.java`
- `OrderingPitfallsDemo.java`

Topics:

- `Comparable`,
- `Comparator`,
- `TreeSet`,
- `TreeMap`,
- `SortedSet`,
- `NavigableSet`,
- ordering mistakes.

### Lab 16: Binary Heap and Priority Queue

Folder: `lab-16-binary-heap-priority-queue`

Suggested files:

- `BinaryMinHeap.java`
- `HeapArrayIndexDemo.java`
- `HeapInsertDeleteMinDemo.java`
- `BuildHeapExperiment.java`
- `JavaPriorityQueueDemo.java`
- `JobSchedulerPriorityQueue.java`

Topics:

- complete binary tree,
- array-based heap representation,
- insert,
- deleteMin,
- buildHeap,
- Java `PriorityQueue`.

### Lab 17: Sorting Algorithms

Folder: `lab-17-sorting-algorithms`

Suggested files:

- `InsertionSort.java`
- `ShellSort.java`
- `HeapSort.java`
- `MergeSort.java`
- `QuickSort.java`
- `QuickSelect.java`
- `RadixSortIntro.java`
- `SortingExperiment.java`
- `StabilityDemo.java`

Topics:

- insertion sort,
- shellsort,
- heapsort,
- mergesort,
- quicksort,
- quickselect,
- radix/bucket sort intro,
- stability,
- empirical comparison.

### Lab 18: Hash Tables

Folder: `lab-18-hash-tables`

Suggested files:

- `StringHashFunctionDemo.java`
- `SeparateChainingHashTable.java`
- `OpenAddressingHashTable.java`
- `LinearProbingDemo.java`
- `QuadraticProbingDemo.java`
- `DoubleHashingDemo.java`
- `LoadFactorExperiment.java`
- `RehashingDemo.java`

Topics:

- hash functions,
- separate chaining,
- open addressing,
- linear probing,
- quadratic probing,
- double hashing,
- load factor,
- rehashing.

### Lab 19: Amortized Analysis

Folder: `lab-19-amortized-analysis`

Suggested files:

- `DynamicArray.java`
- `DynamicArrayResizeExperiment.java`
- `AmortizedCostTablePrinter.java`
- `RehashingAmortizedExperiment.java`
- `AmortizedAnalysisQuestions.md`

Topics:

- dynamic array resizing,
- table doubling,
- aggregate analysis,
- accounting intuition,
- amortized cost.

### Lab 20: Graph Representations

Folder: `lab-20-graph-representations`

Suggested files:

- `Graph.java`
- `Edge.java`
- `AdjacencyListGraph.java`
- `AdjacencyMatrixGraph.java`
- `WeightedGraph.java`
- `GraphRepresentationComparison.java`

Topics:

- graph terminology,
- directed graphs,
- undirected graphs,
- weighted graphs,
- unweighted graphs,
- adjacency list,
- adjacency matrix,
- edge list.

### Lab 21: BFS, DFS, Connected Components, and Topological Sort

Folder: `lab-21-bfs-dfs-topological-sort`

Suggested files:

- `BFS.java`
- `DFS.java`
- `ConnectedComponents.java`
- `TopologicalSort.java`
- `GraphTraversalDemo.java`
- `TraversalTraceWorksheet.md`

Topics:

- BFS,
- DFS,
- visited set,
- traversal order,
- connected components,
- DAG,
- topological sort.

### Lab 22: Shortest Paths and Dijkstra's Algorithm

Folder: `lab-22-shortest-paths-dijkstra`

Suggested files:

- `UnweightedShortestPath.java`
- `Dijkstra.java`
- `DijkstraPriorityQueueDemo.java`
- `RelaxationTraceDemo.java`
- `NegativeWeightCounterexample.java`
- `ShortestPathTestHarness.java`

Topics:

- unweighted shortest path,
- weighted shortest path,
- relaxation,
- Dijkstra's algorithm,
- priority queue connection,
- negative-weight limitation.

### Lab 23: Disjoint Sets and Union-Find

Folder: `lab-23-disjoint-sets-union-find`

Suggested files:

- `DisjointSet.java`
- `QuickFindDemo.java`
- `QuickUnionDemo.java`
- `UnionByRankDemo.java`
- `PathCompressionExperiment.java`
- `UnionFindTraceDemo.java`

Topics:

- equivalence relation,
- union,
- find,
- quick-find,
- quick-union,
- union by rank,
- union by size,
- path compression.

### Lab 24: Minimum Spanning Trees

Folder: `lab-24-minimum-spanning-trees`

Suggested files:

- `PrimMST.java`
- `KruskalMST.java`
- `MSTComparisonDemo.java`
- `MSTTraceWorksheet.md`
- `WeightedGraphForMST.java`

Topics:

- minimum spanning tree,
- Prim's algorithm,
- Kruskal's algorithm,
- priority queue use,
- union-find use,
- MST vs shortest path.

### Lab 25: Algorithm Design Techniques

Folder: `lab-25-algorithm-design-techniques`

Suggested files:

- `GreedyCoinChangeDemo.java`
- `DivideAndConquerDemo.java`
- `DynamicProgrammingFibonacci.java`
- `BacktrackingSubsetDemo.java`
- `RandomizedQuickSortDemo.java`

Topics:

- greedy algorithms,
- divide and conquer,
- dynamic programming intro,
- backtracking intro,
- randomized algorithms intro.

### Lab 26: Data Structure Selection

Folder: `lab-26-data-structure-selection`

Suggested files:

- `DataStructureSelectionCases.java`
- `OperationCostComparison.java`
- `RealWorldUseCaseClassifier.java`
- `ComplexitySummaryTable.md`

Topics:

- choosing data structures,
- operation tradeoffs,
- real-world cases,
- complexity comparison.

### Lab 27: Final Review Synthesis

Folder: `lab-27-final-review-synthesis`

Suggested files:

- `CumulativePracticeDriver.java`
- `FinalReviewTraceProblems.md`
- `MixedComplexityQuestions.md`
- `StudentPracticeTasks.md`

Topics:

- cumulative review,
- mixed tracing,
- final-style questions,
- complexity synthesis,
- exam preparation.

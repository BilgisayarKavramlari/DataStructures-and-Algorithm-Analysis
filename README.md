# CS 3345: Data Structures and Foundations of Algorithmic Analysis

This repository is a clean Java teaching repository for Wednesday practice sessions. This branch intentionally replaces earlier generated content instead of preserving conflicting files. It contains original educational implementations for CS 3345, aligned with theoretical Course Modules and common topics from Mark Allen Weiss, *Data Structures and Algorithm Analysis in Java*, 3rd edition.

## Repository Purpose

The instructor should be able to open any `practice-*` folder, compile the Java files, run `java Main`, and teach the theory through runnable code, trace output, invariants, edge cases, and complexity comments.

## Folder Structure

Each practice folder is named `practice-XX-topic-title`. Each practice folder contains only Java source files. There are no Markdown files inside practice folders, no Maven or Gradle projects, no packages, and no external dependencies.

## Compile and Run

Compile all practice folders from the repository root:

```bash
bash compile_all.sh
```

Run one practice folder by number:

```bash
bash run_practice.sh 10
```

Run manually from a practice folder:

```bash
javac *.java
java Main
```

## Practice Folder Mapping

| Practice Folder | Course Module | Weiss Chapter/Topic | Main Topics | How to Run |
|---|---|---|---|---|
| `practice-00-repository-codespaces-setup` | Module 0 | course setup and Java environment preparation | Java main method, javac/java workflow, command-line arguments, simple output | `bash run_practice.sh 00` |
| `practice-01-java-review` | Module 0 / Module 1 | Java review, generics, Comparable, Comparator | primitive/reference types, arrays, loops, methods, objects, generics, Comparable, Comparator, timing | `bash run_practice.sh 01` |
| `practice-02-adt-linear-structures-review` | Module 1 / Module 2 | Chapter 3, Lists, Stacks, and Queues | ADT operations, array list, linked list, doubly linked list, stack, queue, deque, iterator, ConcurrentModificationException | `bash run_practice.sh 02` |
| `practice-03-java-collections` | Module 1 / Module 2 | Java Collections API | Collection, Iterable, Iterator, List, Set, Map, Queue, Deque, PriorityQueue, Collections, Arrays | `bash run_practice.sh 03` |
| `practice-04-growth-rates` | Module 1 | Chapter 2, algorithm analysis and growth rates | O(1), O(log n), O(n), O(n log n), O(n^2), O(n^3), O(2^n), O(n!), timing, operation counts | `bash run_practice.sh 04` |
| `practice-05-recursion-factorial-fibonacci` | Module 2 | Chapter 1 recursion review and Chapter 2 recursive analysis | base case, progress rule, call stack, factorial, Fibonacci, memoization, duplicate work, safe stack limit | `bash run_practice.sh 05` |
| `practice-06-maximum-subsequence-sum` | Module 2 | Chapter 2, maximum subsequence sum problem | cubic, quadratic, divide-and-conquer, linear Kadane, trace, timing, all-negative input | `bash run_practice.sh 06` |
| `practice-07-formal-algorithm-analysis` | Module 1 / Module 2 | Chapter 2, formal algorithm analysis | Big-O, Big-Omega, Big-Theta, little-o, little-omega, loop rules, binary search, recurrences, space complexity | `bash run_practice.sh 07` |
| `practice-08-tree-basics-traversals` | Module 3 | Chapter 4, tree preliminaries and traversals | tree terminology, first-child/next-sibling, binary tree, preorder, inorder, postorder, level-order, directory tree, postorder size | `bash run_practice.sh 08` |
| `practice-09-expression-trees` | Module 3 | Chapter 4, expression trees | postfix input, stack construction, prefix/infix/postfix traversal, evaluation, construction trace | `bash run_practice.sh 09` |
| `practice-10-binary-search-trees` | Module 3 | Chapter 4, Binary Search Trees | generic BST, invariant, contains, min/max, insert, remove, predecessor, successor, height, counts, experiments | `bash run_practice.sh 10` |
| `practice-11-avl-trees-rotations` | Module 4 | Chapter 4, AVL Trees | AVL invariant, balance factor, LL/RR/LR/RL rotations, insertion, deletion concept, invariant checker, BST comparison | `bash run_practice.sh 11` |
| `practice-12-splay-trees` | Module 4 | Chapter 4 and Chapter 11, Splay Trees | zig, zig-zig, zig-zag, splaying after access, insert, root changes, locality, amortized intuition | `bash run_practice.sh 12` |
| `practice-13-red-black-and-2-4-trees` | Module 4 | Chapter 12 red-black trees, Chapter 4 tree concepts | red-black invariants, insertion, recoloring, rotations, double-red repair, 2-4 correspondence, deletion concepts | `bash run_practice.sh 13` |
| `practice-14-b-trees-multiway-search` | Module 4 | Chapter 4, B-Trees | multi-way search, B-tree degree, search path, insertion, split, median promotion, root/internal split, disk-block motivation, deletion concepts | `bash run_practice.sh 14` |
| `practice-15-java-ordered-collections` | Module 4 | Chapter 4, Sets and Maps in the standard library | Comparable, Comparator, TreeSet, TreeMap, SortedSet, NavigableSet, NavigableMap, range queries, equals/compareTo consistency | `bash run_practice.sh 15` |
| `practice-16-binary-heap-priority-queue` | Module 5 | Chapter 6, Priority Queues and Heaps | binary heap, heap-order, array representation, insert, deleteMin, buildHeap, key changes, selection, simulation, d-heaps, leftist, skew, binomial queues | `bash run_practice.sh 16` |
| `practice-17-sorting-algorithms` | Module 5 | Chapter 7, Sorting | insertion sort, inversions, shellsort, heapsort, mergesort, quicksort, median-of-three, quickselect, radix/bucket, stability, timing, lower bound | `bash run_practice.sh 17` |
| `practice-18-hash-tables` | Module 6 | Chapter 5, Hashing | hash functions, chaining, probing, double hashing, lazy deletion, load factor, rehashing, Java maps/sets, cuckoo, hopscotch, universal, perfect, extendible hashing | `bash run_practice.sh 18` |
| `practice-19-amortized-analysis` | Module 6 | Chapter 11, Amortized Analysis | dynamic array resizing, table doubling, aggregate/accounting/potential, rehashing, splay, binomial queue, skew heap, Fibonacci heap concepts | `bash run_practice.sh 19` |
| `practice-20-graph-representations` | Module 7 | Chapter 9, Graph Definitions and Representations | vertices, edges, paths, cycles, directed/undirected, weighted/unweighted, adjacency list/matrix, edge list, degree, sparse/dense | `bash run_practice.sh 20` |
| `practice-21-bfs-dfs-topological-sort` | Module 7 | Chapter 9, BFS, DFS, Topological Sort | BFS, DFS recursive/iterative, visited set, connected components, cycle detection, topological sort, DAG validation | `bash run_practice.sh 21` |
| `practice-22-shortest-paths-dijkstra` | Module 8 | Chapter 9, Shortest Paths | BFS shortest path, weighted graph, relaxation, Dijkstra variants, path reconstruction, negative edge limitation, DAG shortest path, all-pairs demo | `bash run_practice.sh 22` |
| `practice-23-disjoint-sets-union-find` | Module 9 | Chapter 8, Disjoint Sets | quick-find, quick-union, union by size/rank, path compression, path halving, equivalence classes, complexity, maze generation | `bash run_practice.sh 23` |
| `practice-24-minimum-spanning-trees` | Module 9 | Chapter 9, Minimum Spanning Trees | Prim, Kruskal, priority queue, union-find, MST trace, MST vs shortest path, disconnected graph handling | `bash run_practice.sh 24` |
| `practice-25-algorithm-design-techniques` | Module 10 | Chapter 10, Algorithm Design Techniques | greedy scheduling, Huffman, bin packing, divide and conquer, selection, dynamic programming, matrix chain, optimal BST, randomized quicksort, skip list, primality, backtracking | `bash run_practice.sh 25` |
| `practice-26-data-structure-selection` | Module 10 | Chapter 10 and Chapter 12 selected advanced structures | data structure choice, operation tradeoffs, real-world cases, treap, suffix-array-style index, k-d tree, pairing heap, complexity summary | `bash run_practice.sh 26` |
| `practice-27-final-review-synthesis` | Module 11 | cumulative final review | complexity classification, selection, tracing, trees, heaps, hashing, sorting, graphs, shortest paths, MST, final prompts | `bash run_practice.sh 27` |

## Suggested Weekly Usage

| Week Range | Suggested Practice Focus |
|---|---|
| Weeks 1-2 | Java review, ADTs, Java Collections, growth rates, and recursion. |
| Weeks 3-4 | Formal analysis, maximum subsequence sum, trees, expression trees, BSTs, AVL trees, splay trees, red-black trees, and B-trees. |
| Weeks 5-7 | Ordered collections, heaps, sorting, hashing, and amortized analysis. |
| Weeks 8-10 | Graph representations, traversals, shortest paths, union-find, MSTs, algorithm design, data-structure selection, and final review. |

## Originality and Teaching Notes

The examples are original educational implementations. They are not copied textbook code, slide text, textbook pages, proprietary source code, images, or diagrams. Advanced structures may be simplified for teaching clarity, but every advanced topic is represented by runnable code and meaningful output. All code is intended for live explanation, tracing, modification, and experimentation.

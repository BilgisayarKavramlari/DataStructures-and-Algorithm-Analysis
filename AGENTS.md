# AGENTS.md

## Project

This repository is for **CS 3345: Data Structures and Foundations of Algorithmic Analysis** at **The University of Texas at Dallas**.

The repository contains Java Coding Labs aligned with the eLearning Course Modules and the Weiss textbook, *Data Structures and Algorithm Analysis in Java*.

## Critical Terminology

Use these terms consistently:

- **Course Module**: the official theory/eLearning unit.
- **Coding Lab**: a GitHub practice folder containing Java code, demos, trace exercises, and complexity questions.

Do not call GitHub practice folders "modules."

Correct examples:

- `Course Module 3: Trees and Binary Search Trees`
- `Coding Lab 10: Binary Search Trees`
- `lab-10-binary-search-trees`

Incorrect examples:

- `GitHub Module 10`
- `module-10-binary-search-trees`
- `practice module`

## Language

All repository files must be written in English.

This includes:

- Markdown documentation,
- Java comments,
- Java class names,
- commit messages,
- README files,
- student task descriptions,
- complexity questions,
- terminal instructions.

## Java Style

Use plain Java suitable for CS 3345 students.

Requirements:

1. Do not use Java packages.
2. Do not require Maven, Gradle, or external libraries.
3. Use only the Java standard library.
4. Keep each Coding Lab self-contained.
5. Provide at least one runnable `main` method in each lab.
6. Prefer educational clarity over production-level completeness.
7. Add comments explaining invariants, operations, and complexity.
8. Avoid unnecessarily abstract or over-engineered designs.
9. Avoid advanced Java features that distract from the data structure concept.
10. Use meaningful class names.

## Compilation

Each lab should compile from its own folder using:

```bash
javac *.java
```

Each lab README must include at least one run command, such as:

```bash
java BSTTestHarness
```

The repository should include a script:

```bash
scripts/compile-all.sh
```

The script should compile all lab folders that contain Java files.

## Folder Structure

Create these folders:

```text
lab-00-repository-codespaces-setup
lab-01-java-review
lab-02-adt-linear-structures-review
lab-03-java-collections
lab-04-growth-rates
lab-05-recursion-factorial-fibonacci
lab-06-maximum-subsequence-sum
lab-07-formal-algorithm-analysis
lab-08-tree-basics-traversals
lab-09-expression-trees
lab-10-binary-search-trees
lab-11-avl-trees-rotations
lab-12-splay-trees
lab-13-red-black-and-2-4-trees
lab-14-b-trees-multiway-search
lab-15-java-ordered-collections
lab-16-binary-heap-priority-queue
lab-17-sorting-algorithms
lab-18-hash-tables
lab-19-amortized-analysis
lab-20-graph-representations
lab-21-bfs-dfs-topological-sort
lab-22-shortest-paths-dijkstra
lab-23-disjoint-sets-union-find
lab-24-minimum-spanning-trees
lab-25-algorithm-design-techniques
lab-26-data-structure-selection
lab-27-final-review-synthesis
```

## Required README for Each Lab

Every lab folder must contain a `README.md` with the following sections:

```markdown
# Coding Lab XX: Title

## Related Course Module

## Related Weiss Topic

## Learning Objectives

## Files in This Lab

## How to Compile

## How to Run

## Suggested Student Workflow

## Student Tasks

## Complexity and Design Questions

## Expected Takeaways
```

## Coverage Requirement

Every major theory topic must have a visible Coding Lab counterpart.

The repository must cover:

- Java review and Codespaces workflow
- ADTs, lists, stacks, queues, recursion
- Java Collections Framework
- Big-O, Big-Omega, Big-Theta, little-o, little-omega
- recurrence relations and space complexity
- growth-rate experiments
- maximum subsequence sum
- tree terminology, traversals, binary trees, expression trees
- binary search trees
- AVL trees and rotations
- splay trees
- multi-way search trees
- 2-3 / 2-4 trees
- red-black trees
- B-trees
- Java `TreeSet`, `TreeMap`, `SortedSet`, `NavigableSet`, `Comparable`, `Comparator`
- binary heaps and priority queues
- insertion sort, shellsort, heapsort, mergesort, quicksort, quickselect
- introductory bucket/radix sorting where appropriate
- hashing with separate chaining and open addressing
- probing strategies, load factor, and rehashing
- amortized analysis
- dynamic array resizing
- graph representations
- BFS, DFS, connected components, topological sort
- unweighted shortest paths
- Dijkstra's algorithm and relaxation
- negative-weight limitation
- disjoint sets and union-find
- path compression and union by rank/size
- Prim's and Kruskal's MST algorithms
- algorithm design techniques
- data structure selection and cumulative final review

## Special Data Structure Requirements

Do not omit these topics:

### Red-Black Trees

Include:

- red-black invariants,
- node color,
- recoloring,
- rotations,
- insertion trace,
- relationship to 2-4 trees,
- an educational implementation,
- an invariant checker.

Minimum suggested files:

```text
RedBlackNode.java
RedBlackTreeEducational.java
RedBlackInsertionTraceDemo.java
ColorFlipRotationDemo.java
RedBlackInvariantChecker.java
TwoFourTreeTraceDemo.java
TwoFourToRedBlackConnection.md
```

### Splay Trees

Include:

- zig,
- zig-zig,
- zig-zag,
- splaying after access,
- access locality,
- amortized intuition.

Minimum suggested files:

```text
SplayNode.java
SplayTree.java
ZigZigZigZagDemo.java
SplayAccessPatternExperiment.java
SplayAmortizedDiscussion.md
```

### B-Trees

Include:

- multi-way search,
- node capacity,
- search path,
- split,
- promotion of median key,
- insertion trace,
- disk/block motivation.

Minimum suggested files:

```text
BTreeNode.java
BTreeEducational.java
BTreeInsertionTraceDemo.java
BTreeSearchDemo.java
BTreeSplitTrace.md
```

## Testing Expectations

Before completing work, run:

```bash
bash scripts/compile-all.sh
```

If any Java file does not compile, fix it before finishing.

If a topic is intentionally implemented only as a trace demo rather than a full production implementation, explain this clearly in that lab's README.

## Academic Tone

Write documentation in a clear academic style suitable for undergraduate data structures students.

Avoid casual language.

Prefer precise explanations of:

- invariants,
- operations,
- complexity,
- tradeoffs,
- edge cases,
- correctness reasoning.

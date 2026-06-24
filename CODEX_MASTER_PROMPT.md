# Codex Master Prompt

Copy and paste this prompt into Codex after uploading the seed Markdown files to the repository root.

## Prompt

You are working on the repository `BilgisayarKavramlari/DataStructures-and-Algorithm-Analysis`.

The repository is for **CS 3345: Data Structures and Foundations of Algorithmic Analysis** at **The University of Texas at Dallas**.

The instructor wants this repository rebuilt as a complete set of Java Coding Labs aligned with the official eLearning Course Modules and the Weiss textbook, *Data Structures and Algorithm Analysis in Java*.

Read and follow all root-level Markdown files, especially:

- `AGENTS.md`
- `README.md`
- `WEEKLY-PRACTICE-SCHEDULE.md`
- `COURSE-MODULE-TO-CODING-LAB-MAPPING.md`
- `LAB-TEMPLATE.md`
- `IMPLEMENTATION-SPEC.md`
- `ACADEMIC-INTEGRITY-AND-AI-USE.md`

## Core Terminology

Use these terms consistently:

- **Course Module** means the official eLearning/theory unit.
- **Coding Lab** means a GitHub practice folder.

Do not call GitHub practice folders "modules."

All documentation, Java comments, student tasks, and source code comments must be in English.

## Main Task

Rebuild the repository from the seed documentation.

Create the full Coding Lab structure:

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

For each lab:

1. Create `README.md`.
2. Include related Course Module.
3. Include related Weiss textbook topic.
4. Include learning objectives.
5. Include a list of Java files.
6. Include compile instructions.
7. Include run instructions.
8. Include suggested student workflow.
9. Include at least three student tasks.
10. Include at least three complexity or design questions.
11. Include expected takeaways.
12. Add Java source files suitable for CS 3345 students.
13. Keep the code simple, educational, traceable, and self-contained.
14. Do not use Java packages.
15. Do not require Maven, Gradle, or external dependencies.
16. Make sure each lab has at least one runnable demo with a `main` method.

## Required Root Files

Create or update:

- `README.md`
- `AGENTS.md`
- `WEEKLY-PRACTICE-SCHEDULE.md`
- `COURSE-MODULE-TO-CODING-LAB-MAPPING.md`
- `LAB-TEMPLATE.md`
- `IMPLEMENTATION-SPEC.md`
- `CONTRIBUTING.md`
- `ACADEMIC-INTEGRITY-AND-AI-USE.md`
- `.gitignore`
- `scripts/compile-all.sh`

## Required Compile Script

Create `scripts/compile-all.sh` with a script that:

1. Deletes old `.class` files.
2. Iterates through all `lab-*` folders.
3. Compiles Java files inside each lab using `javac *.java`.
4. Stops if compilation fails.
5. Prints a success message if all labs compile.

## Required Coverage

The repository must cover every major theory topic in the course:

- Java review
- GitHub Codespaces workflow
- ADTs
- lists, stacks, queues, deques
- Java Collections Framework
- Big-O, Big-Omega, Big-Theta, little-o, little-omega
- growth rates
- recurrence relations
- space complexity
- recursion
- factorial and Fibonacci
- maximum subsequence sum
- binary trees and traversals
- expression trees
- binary search trees
- AVL trees
- splay trees
- 2-3 / 2-4 trees
- red-black trees
- B-trees
- Java ordered collections
- heaps and priority queues
- sorting algorithms
- hashing
- amortized analysis
- graph representations
- BFS and DFS
- connected components
- topological sort
- shortest paths
- Dijkstra's algorithm
- disjoint sets and union-find
- minimum spanning trees
- Prim's algorithm
- Kruskal's algorithm
- algorithm design techniques
- final review synthesis

## Special Attention

Do not omit red-black trees, splay trees, or B-trees.

If a full production implementation would be too long, provide:

- an educational implementation,
- a trace demo,
- an invariant checker or explanation,
- a README explanation of what is implemented and what is intentionally simplified.

## Suggested Implementation Depth

Use full runnable implementations for:

- linked list,
- stack and queue demos,
- recursion examples,
- maximum subsequence sum,
- binary search tree,
- AVL insertion and rotations,
- binary heap,
- core sorting algorithms,
- hash table examples,
- graph representation,
- BFS and DFS,
- Dijkstra,
- union-find,
- Prim and Kruskal.

Use educational or trace-based implementations for:

- red-black tree deletion,
- B-tree deletion,
- full 2-4 tree deletion,
- advanced dynamic programming beyond introductory examples.

## Validation

After generating the repository:

1. Run `bash scripts/compile-all.sh`.
2. Fix all compilation errors.
3. Check that every lab has a README.
4. Check that every lab has at least one runnable demo.
5. Check that no GitHub practice folder is called `module-*`.
6. Check that the word "module" is used only for official Course Modules.
7. Provide a concise final summary of:
   - folders created,
   - key files created,
   - compile result,
   - any intentional simplifications,
   - suggested next instructor review points.

Commit all changes.

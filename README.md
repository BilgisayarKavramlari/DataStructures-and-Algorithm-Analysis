# CS 3345 Java Coding Labs

## Data Structures and Foundations of Algorithmic Analysis

This repository contains Java-based Coding Labs for **CS 3345: Data Structures and Foundations of Algorithmic Analysis** at **The University of Texas at Dallas**.

The Coding Labs are designed to support the official eLearning Course Modules, lecture materials, live practice sessions, textbook readings, assignments, quizzes, and exam preparation.

**Instructor:** Prof. Dr. Şadi Evren Şeker  
**Course:** CS 3345 — Data Structures and Foundations of Algorithmic Analysis  
**Institution:** The University of Texas at Dallas  
**Textbook:** Mark Allen Weiss, *Data Structures and Algorithm Analysis in Java*

## Repository Purpose

The purpose of this repository is to help students connect data structure theory with Java implementation.

Students should use this repository to:

- read Java examples,
- compile and run programs,
- trace data structure operations,
- compare alternative implementations,
- reason about time and space complexity,
- explain algorithmic design decisions,
- prepare for quizzes, assignments, midterms, and the final exam.

The goal is not only to produce programs that work. In CS 3345, students are expected to understand and explain invariants, operations, complexity, edge cases, test cases, and implementation tradeoffs.

## Course Module vs. Coding Lab

This repository uses the following terminology carefully:

| Term | Meaning |
|---|---|
| **Course Module** | The official theory unit used in eLearning. Course Modules organize lecture topics, readings, slides, quizzes, assignments, and assessments. |
| **Coding Lab** | A GitHub practice folder containing Java examples, implementation exercises, trace demos, and complexity questions. |

GitHub practice folders must be called **Coding Labs**, not modules.

For example:

- **Course Module 3** may cover Trees and Binary Search Trees.
- **Coding Lab 08**, **Coding Lab 09**, and **Coding Lab 10** may provide Java practice for tree traversals, expression trees, and binary search trees.

## How to Use This Repository

Recommended workflow:

1. Open the repository in GitHub.
2. Fork it to your own GitHub account.
3. Open your fork in GitHub Codespaces.
4. Navigate to the relevant Coding Lab folder.
5. Compile the Java files using `javac`.
6. Run the demo program using `java`.
7. Modify the examples and answer the design questions.
8. Commit and push your own practice work to your fork.

Students should not push directly to the instructor's repository.

## Recommended Codespaces Workflow

Inside GitHub Codespaces:

```bash
ls
cd lab-10-binary-search-trees
javac *.java
java BSTTestHarness
```

To return to the repository root:

```bash
cd ..
```

To remove compiled class files:

```bash
find . -name "*.class" -delete
```

## Lab Index

| Coding Lab | Title | Main Course Module |
|---|---|---|
| Lab 00 | Repository and Codespaces Setup | Module 0 |
| Lab 01 | Java Review | Module 0 / Module 1 |
| Lab 02 | ADT and Linear Structures Review | Module 1 / Module 2 |
| Lab 03 | Java Collections | Module 1 / Module 2 |
| Lab 04 | Growth Rates | Module 1 |
| Lab 05 | Recursion, Factorial, and Fibonacci | Module 2 |
| Lab 06 | Maximum Subsequence Sum | Module 2 |
| Lab 07 | Formal Algorithm Analysis | Module 1 / Module 2 |
| Lab 08 | Tree Basics and Traversals | Module 3 |
| Lab 09 | Expression Trees | Module 3 |
| Lab 10 | Binary Search Trees | Module 3 |
| Lab 11 | AVL Trees and Rotations | Module 4 |
| Lab 12 | Splay Trees | Module 4 |
| Lab 13 | Red-Black Trees and 2-4 Trees | Module 4 |
| Lab 14 | B-Trees and Multi-Way Search | Module 4 |
| Lab 15 | Java Ordered Collections | Module 4 |
| Lab 16 | Binary Heap and Priority Queue | Module 5 |
| Lab 17 | Sorting Algorithms | Module 5 |
| Lab 18 | Hash Tables | Module 6 |
| Lab 19 | Amortized Analysis | Module 6 |
| Lab 20 | Graph Representations | Module 7 |
| Lab 21 | BFS, DFS, Connected Components, and Topological Sort | Module 7 |
| Lab 22 | Shortest Paths and Dijkstra's Algorithm | Module 8 |
| Lab 23 | Disjoint Sets and Union-Find | Module 9 |
| Lab 24 | Minimum Spanning Trees | Module 9 |
| Lab 25 | Algorithm Design Techniques | Module 10 |
| Lab 26 | Data Structure Selection | Module 10 |
| Lab 27 | Final Review Synthesis | Module 11 |

## Weekly Practice Schedule

See [`WEEKLY-PRACTICE-SCHEDULE.md`](WEEKLY-PRACTICE-SCHEDULE.md).

## Course Module to Coding Lab Mapping

See [`COURSE-MODULE-TO-CODING-LAB-MAPPING.md`](COURSE-MODULE-TO-CODING-LAB-MAPPING.md).

## Academic Integrity

These Coding Labs are for learning, tracing, experimentation, and practice.

Students may use the examples to study the concepts, but graded assignments must follow the academic integrity rules stated in the syllabus and eLearning. Students are expected to understand and explain their own work.

See [`ACADEMIC-INTEGRITY-AND-AI-USE.md`](ACADEMIC-INTEGRITY-AND-AI-USE.md).

## Repository Generation Note

This repository may be generated or extended using Codex. The root-level `AGENTS.md` file provides instructions for the coding agent, and `CODEX_MASTER_PROMPT.md` provides the master task prompt for building the full lab structure.

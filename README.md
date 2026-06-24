# CS 3345 Java Examples

## Data Structures and Foundations of Algorithmic Analysis

This repository contains Java code examples prepared for **CS 3345: Data Structures and Foundations of Algorithmic Analysis**.

The examples are designed to support lecture slides, classroom demonstrations, and student practice. The main goal is to help students connect Java implementation with core data structures, algorithmic thinking, growth rates, recursion, and formal asymptotic analysis.

**Instructor:** Prof. Dr. Şadi Evren Şeker  
**Course:** CS 3345 — Data Structures and Foundations of Algorithmic Analysis  
**Institution:** The University of Texas at Dallas

## Repository Purpose

This repository is intended as a practical companion to the lecture materials. Students are encouraged to read, compile, run, modify, and extend the Java examples.

The code examples are not only written to produce correct outputs, but also to support discussion about:

- How algorithms work step by step
- How data structures affect performance
- How different implementations solve the same problem
- How running time grows with input size
- How to reason about Big O, Big Omega, Big Theta, little o, and little omega
- How recursion, loops, and divide-and-conquer strategies are analyzed

## Practice Roadmap and Theory Alignment

The following table shows the intended relationship between the course modules, practice folders, and textbook topics.

| Practice | Course Module | Practice Folder | Weiss Chapter / Topic | Main Theory Topics |
|---:|---|---|---|---|
| 00 | Module 0 | `practice-00-repository-codespaces-setup` | Java environment setup | GitHub, Codespaces, `javac`, `java`, `Main.java`, command-line workflow |
| 01 | Module 0 / Module 1 | `practice-01-java-review` | Java review | variables, loops, arrays, methods, objects, generics, `Comparable`, `Comparator` |
| 02 | Module 1 / Module 2 | `practice-02-adt-linear-structures-review` | Chapter 3: Lists, Stacks, and Queues | ADT idea, array lists, linked lists, stacks, queues, deque, iterators |
| 03 | Module 1 / Module 2 | `practice-03-java-collections` | Java Collections API | `Collection`, `List`, `Set`, `Map`, `Queue`, `Deque`, `PriorityQueue` |
| 04 | Module 1 | `practice-04-growth-rates` | Chapter 2: Algorithm Analysis | growth rates, operation counting, empirical timing, dominant terms |
| 05 | Module 2 | `practice-05-recursion-factorial-fibonacci` | Chapter 1 / Chapter 2: Recursion and Analysis | recursion, base case, call stack, factorial, Fibonacci, memoization |
| 06 | Module 2 | `practice-06-maximum-subsequence-sum` | Chapter 2: Maximum Subsequence Sum | cubic, quadratic, divide-and-conquer, and linear-time algorithms |
| 07 | Module 1 / Module 2 | `practice-07-formal-algorithm-analysis` | Chapter 2: Formal Algorithm Analysis | Big-O, Big-Omega, Big-Theta, little-o, loop analysis, recurrences |
| 08 | Module 3 | `practice-08-tree-basics-traversals` | Chapter 4: Trees | tree terminology, first-child/next-sibling, binary trees, traversals, depth, height |
| 09 | Module 3 | `practice-09-expression-trees` | Chapter 4: Expression Trees | postfix construction, stack-based tree building, prefix/infix/postfix traversal, evaluation |
| 10 | Module 3 | `practice-10-binary-search-trees` | Chapter 4: Binary Search Trees | BST invariant, search, insert, remove, min/max, predecessor/successor, height |
| 11 | Module 4 | `practice-11-avl-trees-rotations` | Chapter 4: AVL Trees | height balance, balance factor, LL/RR/LR/RL rotations, AVL invariant |
| 12 | Module 4 | `practice-12-splay-trees` | Chapter 4 / Chapter 11: Splay Trees | zig, zig-zig, zig-zag, access locality, amortized intuition |
| 13 | Module 4 | `practice-13-red-black-and-2-4-trees` | Chapter 12 / Chapter 4: Red-Black and 2-4 Trees | red-black invariants, rotations, recoloring, black height, 2-4 correspondence |
| 14 | Module 4 | `practice-14-b-trees-multiway-search` | Chapter 4: B-Trees | multi-way search, B-tree insertion, splitting, median promotion, disk-block motivation |
| 15 | Module 4 | `practice-15-java-ordered-collections` | Chapter 4: TreeSet and TreeMap | ordered sets/maps, `Comparable`, `Comparator`, range queries, ordering pitfalls |
| 16 | Module 5 | `practice-16-binary-heap-priority-queue` | Chapter 6: Priority Queues and Heaps | binary heap, insert, deleteMin, buildHeap, selection problem, event simulation |
| 17 | Module 5 | `practice-17-sorting-algorithms` | Chapter 7: Sorting | insertion sort, shellsort, heapsort, mergesort, quicksort, quickselect, radix/bucket ideas |
| 18 | Module 6 | `practice-18-hash-tables` | Chapter 5: Hashing | hash functions, separate chaining, probing, double hashing, lazy deletion, rehashing |
| 19 | Module 6 | `practice-19-amortized-analysis` | Chapter 11: Amortized Analysis | dynamic arrays, table doubling, accounting method, potential method, rehashing |
| 20 | Module 7 | `practice-20-graph-representations` | Chapter 9: Graphs | vertices, edges, adjacency list, adjacency matrix, edge list, sparse/dense graphs |
| 21 | Module 7 | `practice-21-bfs-dfs-topological-sort` | Chapter 9: Graph Traversal | BFS, DFS, connected components, cycle detection, topological sorting |
| 22 | Module 8 | `practice-22-shortest-paths-dijkstra` | Chapter 9: Shortest Paths | unweighted shortest paths, relaxation, Dijkstra, path reconstruction, negative edges |
| 23 | Module 9 | `practice-23-disjoint-sets-union-find` | Chapter 8: Disjoint Sets | quick-find, quick-union, union by size/rank, path compression, maze connectivity |
| 24 | Module 9 | `practice-24-minimum-spanning-trees` | Chapter 9: Minimum Spanning Trees | Prim, Kruskal, priority queues, union-find, MST trace |
| 25 | Module 10 | `practice-25-algorithm-design-techniques` | Chapter 10: Algorithm Design Techniques | greedy algorithms, divide and conquer, dynamic programming, backtracking, randomized algorithms |
| 26 | Module 10 | `practice-26-data-structure-selection` | Chapter 10 / Chapter 12: Design and Advanced Structures | selecting data structures, treap, suffix-array-style index, k-d tree, pairing heap |
| 27 | Module 11 | `practice-27-final-review-synthesis` | Cumulative Review | complexity, trees, heaps, hashing, sorting, graphs, shortest paths, MST, union-find |

## Suggested Weekly Usage

| Course Phase | Suggested Practice Focus |
|---|---|
| Early course setup | Practice 00–03: setup, Java review, ADTs, Java Collections |
| Algorithm analysis foundation | Practice 04–07: growth rates, recursion, maximum subsequence sum, formal analysis |
| Trees and balanced search structures | Practice 08–15: tree basics, expression trees, BST, AVL, splay, red-black, B-trees, ordered collections |
| Heaps, sorting, and hashing | Practice 16–19: priority queues, sorting, hashing, amortized analysis |
| Graph algorithms and disjoint sets | Practice 20–24: graph representations, BFS/DFS, shortest paths, union-find, MST |
| Design techniques and review | Practice 25–27: algorithm design, data-structure selection, final review |


## Topics Covered

### Java Quick Review

- Basic Java program structure
- Variables and primitive types
- Operators and integer division
- Conditional statements
- Loops and nested loops
- Arrays
- Methods
- Strings
- Classes and objects
- References and parameter passing
- Basic exception handling
- Simple timing experiments

### Java and Data Structures

- Arrays
- ArrayList
- Linked lists
- Stacks
- Queues
- Sets
- Maps
- Custom classes for data structures
- Generics
- Iterators
- Recursion
- Searching
- Sorting
- Runtime thinking for data structures

### Java Collections Framework

- List interface
- ArrayList
- LinkedList
- Set interface
- HashSet
- LinkedHashSet
- TreeSet
- Map interface
- HashMap
- LinkedHashMap
- TreeMap
- Queue
- Deque
- ArrayDeque
- PriorityQueue
- Comparator
- Collections utility methods
- Arrays utility methods

### Growth Rates and Growth Functions

- Constant growth: `O(1)`
- Logarithmic growth: `O(log n)`
- Linear growth: `O(n)`
- Linearithmic growth: `O(n log n)`
- Quadratic growth: `O(n²)`
- Cubic growth: `O(n³)`
- Exponential growth: `O(2ⁿ)`
- Factorial growth: `O(n!)`
- Dominant terms
- Ignoring constant factors
- Loop counting
- Empirical timing experiments

### Factorial, Fibonacci, and Recursion

- Iterative factorial
- Recursive factorial
- Call stack behavior
- Integer overflow
- Naive recursive Fibonacci
- Counting recursive calls
- Iterative Fibonacci
- Memoized Fibonacci
- Repeated computation
- Dynamic programming intuition

### Maximum Subsequence Sum

This repository includes four algorithmic approaches to the maximum subsequence sum problem:

1. Cubic brute-force algorithm — `O(n³)`
2. Improved quadratic brute-force algorithm — `O(n²)`
3. Divide-and-conquer algorithm — `O(n log n)`
4. Linear-time algorithm / Kadane’s algorithm — `O(n)`

The purpose of this section is to demonstrate how the same problem can be solved using increasingly efficient algorithmic strategies.

### Formal Algorithm Analysis

- Big O notation
- Big Omega notation
- Big Theta notation
- Little o notation
- Little omega notation
- Formal proof examples
- Loop analysis
- Best-case, worst-case, and average-case analysis
- Space complexity
- Recurrence relations
- Divide-and-conquer analysis
- Recursion tree intuition
- Master Theorem intuition

## Suggested Repository Structure

A possible structure for this repository is:

```text
cs3345-java-examples/
├── README.md
├── .gitignore
├── module-01-java-review/
│   ├── Main.java
│   ├── VariablesExample.java
│   ├── LoopsExample.java
│   ├── ArraysExample.java
│   └── MethodsExample.java
├── module-02-data-structures-review/
│   ├── ArrayExample.java
│   ├── ArrayListExample.java
│   ├── LinkedListExample.java
│   ├── StackExample.java
│   ├── QueueExample.java
│   ├── SetExample.java
│   └── MapExample.java
├── module-03-java-collections/
│   ├── ListExamples.java
│   ├── SetExamples.java
│   ├── MapExamples.java
│   ├── QueueDequeExamples.java
│   ├── PriorityQueueExample.java
│   └── ComparatorExample.java
├── module-04-growth-rates/
│   ├── ConstantExample.java
│   ├── LinearExample.java
│   ├── QuadraticExample.java
│   ├── LogarithmicExample.java
│   ├── LinearithmicExample.java
│   └── TimingExperiment.java
├── module-05-recursion-factorial-fibonacci/
│   ├── FactorialIterative.java
│   ├── FactorialRecursive.java
│   ├── FibonacciRecursive.java
│   ├── FibonacciIterative.java
│   └── FibonacciMemoization.java
├── module-06-maximum-subsequence-sum/
│   ├── MaxSubsequenceCubic.java
│   ├── MaxSubsequenceQuadratic.java
│   ├── MaxSubsequenceDivideConquer.java
│   ├── MaxSubsequenceLinear.java
│   └── MaxSubsequenceTestHarness.java
└── module-07-formal-algorithm-analysis/
    ├── BigOExamples.java
    ├── LoopAnalysisExamples.java
    ├── RecurrenceExamples.java
    ├── BinarySearchExample.java
    ├── MergeSortExample.java
    └── SpaceComplexityExamples.java
```

The actual folder names may differ depending on how the course materials are organized.

## Using Git, GitHub, and Codespaces for This Project

This section explains how students can use this repository, run the Java examples, make their own changes, and save their work using Git and GitHub Codespaces.

You do **not** need to install Java or an IDE on your computer if you use GitHub Codespaces. Codespaces gives you a browser-based development environment where you can edit, compile, and run the Java examples.

## Recommended Student Workflow

For this course, the recommended workflow is:

1. Fork this repository to your own GitHub account.
2. Open your fork in GitHub Codespaces.
3. Run the Java examples.
4. Modify the code for practice.
5. Commit your changes.
6. Push your changes to your own fork.

Students should not try to push changes directly to the original course repository.

## Step 1: Fork This Repository

A fork is your own copy of this repository under your GitHub account.

To create a fork:

1. Open the original course repository on GitHub.
2. Click the **Fork** button near the top-right corner of the page.
3. Choose your own GitHub account as the destination.
4. Keep the repository name as it is, or rename it if you prefer.
5. Click **Create fork**.

After this step, you will have your own copy of the repository.

For example, the original repository may look like this:

```text
BilgisayarKavramlari/DataStructures-and-Algorithm-Analysis
```

Your fork may look like this:

```text
your-github-username/DataStructures-and-Algorithm-Analysis
```

Make sure you are working in **your own fork**, not directly in the instructor's repository.

## Step 2: Open the Project in GitHub Codespaces

After creating your fork:

1. Go to your forked repository on GitHub.
2. Click the green **Code** button.
3. Open the **Codespaces** tab.
4. Click **Create codespace on main**.

GitHub will create a browser-based coding environment for you. This may take a minute the first time.

Once the Codespace opens, you should see a VS Code-like interface in your browser.

## Step 3: Open the Terminal

Inside Codespaces:

1. Look at the top menu.
2. Click **Terminal**.
3. Click **New Terminal**.

You will use this terminal to compile and run Java programs.

## Step 4: Check the Project Files

In the terminal, you can list the files and folders using:

```bash
ls
```

You should see folders such as:

```text
module-01-java-review
module-02-data-structures-review
module-03-java-collections
module-04-growth-rates
module-05-recursion-factorial-fibonacci
module-06-maximum-subsequence-sum
module-07-formal-algorithm-analysis
```

The exact folder names may differ slightly depending on the current version of the repository.

## Step 5: Move into a Module Folder

Use the `cd` command to move into a folder.

Example:

```bash
cd module-01-java-review
```

To see the files in that folder:

```bash
ls
```

If you want to go back to the main project folder:

```bash
cd ..
```

## Step 6: Compile a Java File

Most Java examples can be compiled using `javac`.

Example:

```bash
javac LinearExample.java
```

If the file compiles successfully, there may be no output. That usually means the compilation worked.

If there is an error, read the error message carefully. Java error messages often tell you the file name, line number, and type of problem.

## Step 7: Run a Java Program

After compiling a Java file, run it using the `java` command.

Example:

```bash
java LinearExample
```

Do not include `.java` when running the program.

Correct:

```bash
java LinearExample
```

Incorrect:

```bash
java LinearExample.java
```

## Step 8: Compile All Java Files in a Folder

If a folder contains multiple Java files, you can compile all of them with:

```bash
javac *.java
```

This compiles every `.java` file in the current folder.

Then run the class that contains the `main` method.

Example:

```bash
java Main
```

or:

```bash
java MaxSubsequenceTestHarness
```

The class name must match the name of the class containing:

```java
public static void main(String[] args)
```

## Step 9: Clean Compiled Files

When you compile Java code, Java may generate `.class` files.

These files are compiled outputs. You usually do not need to commit them to GitHub.

To remove compiled `.class` files from the current folder:

```bash
rm *.class
```

To remove `.class` files from all folders:

```bash
find . -name "*.class" -delete
```

## Basic Git Commands

Git helps you track your changes.

The most common Git commands are:

```bash
git status
```

Shows which files have changed.

```bash
git add .
```

Stages all changed files for commit.

```bash
git commit -m "Your commit message"
```

Saves a snapshot of your changes.

```bash
git push
```

Uploads your committed changes to your GitHub fork.

## Step 10: Check Your Current Git Status

Before saving your work, check what changed:

```bash
git status
```

You may see modified files, new files, or deleted files.

## Step 11: Stage Your Changes

To stage all changes:

```bash
git add .
```

To stage only one file:

```bash
git add module-01-java-review/LinearExample.java
```

## Step 12: Commit Your Changes

A commit is a saved version of your work.

Use a short and meaningful commit message.

Example:

```bash
git commit -m "Practice linear and quadratic growth examples"
```

Other good commit message examples:

```bash
git commit -m "Add my solution for array practice"
```

```bash
git commit -m "Modify Fibonacci example"
```

```bash
git commit -m "Add comments to maximum subsequence code"
```

## Step 13: Push Your Changes to GitHub

After committing, push your changes to your fork:

```bash
git push
```

If this is your first push from a new branch, Git may ask you to use a longer command. It may look like this:

```bash
git push --set-upstream origin main
```

or:

```bash
git push -u origin main
```

Follow the instruction shown in the terminal.

## Step 14: Confirm Your Changes on GitHub

After pushing:

1. Go back to your fork on GitHub.
2. Refresh the page.
3. Open the file you changed.
4. Confirm that your latest code appears online.

If you can see your updated file on GitHub, your push worked.

## Common Git Workflow for Students

A typical work session looks like this:

```bash
git status
cd module-04-growth-rates
javac LinearExample.java
java LinearExample
cd ..
git status
git add .
git commit -m "Practice growth rate examples"
git push
```

## If You Make a Mistake

If your code does not compile, carefully read the error message.

Common Java mistakes include:

- File name does not match the public class name.
- Missing semicolon.
- Missing closing brace `}`.
- Running the program with `.java` in the command.
- Trying to run a class that does not contain a `main` method.

Example:

```bash
javac MyExample.java
java MyExample
```

If the class is named:

```java
public class MyExample
```

then the file must be named:

```text
MyExample.java
```

## Keeping Your Fork Updated

The instructor may update the original course repository during the semester.

If you want to update your fork with the latest course materials, you can use GitHub's **Sync fork** button on your fork page.

Basic browser steps:

1. Go to your forked repository.
2. Look for the **Sync fork** button.
3. Click **Update branch** if GitHub says your fork is behind.

This brings new changes from the original course repository into your fork.

## Optional: Using Git Pull in Codespaces

If your fork has been updated on GitHub and you want to bring those changes into your Codespace, use:

```bash
git pull
```

This downloads the latest changes from your GitHub fork into your Codespace.

A common update workflow is:

```bash
git status
git pull
```

If you have local changes, commit them before pulling.

## Important: Work in Your Own Fork

Please remember:

- The instructor's repository is the official course version.
- Your fork is your personal working copy.
- You should make experiments and changes in your own fork.
- Do not try to push directly to the instructor's repository.
- Do not submit pull requests unless the instructor specifically asks you to do so.

## Suggested Practice Workflow

For each code example:

1. Open the related module folder.
2. Read the Java file.
3. Predict the output.
4. Compile the program.
5. Run the program.
6. Modify the input values.
7. Run it again.
8. Explain the time complexity.
9. Commit your changes to your fork.

Example:

```bash
cd module-06-maximum-subsequence-sum
javac MaxSubsequenceLinear.java
java MaxSubsequenceLinear
```

Then modify the input array and run it again.

## Example Practice Session

```bash
cd module-06-maximum-subsequence-sum
javac MaxSubsequenceLinear.java
java MaxSubsequenceLinear
```

After editing the file:

```bash
javac MaxSubsequenceLinear.java
java MaxSubsequenceLinear
```

Then save your work:

```bash
cd ..
git status
git add .
git commit -m "Experiment with maximum subsequence sum input"
git push
```

## What You Should Learn from This Workflow

By using Git, GitHub, and Codespaces, you practice not only Java programming but also a professional software development workflow.

You will learn how to:

- Read code from a repository
- Run Java programs in a cloud development environment
- Modify examples safely
- Track your changes with Git
- Save your work on GitHub
- Organize programming practice by module
- Connect code behavior with algorithm analysis

This workflow is part of becoming comfortable with real-world software development tools.


## How to Run the Code

Most examples are written as simple Java files so that students can compile and run them directly.

Go to the folder of the example:

```bash
cd module-01-java-review
```

Compile the Java file:

```bash
javac Main.java
```

Run the program:

```bash
java Main
```

If a folder contains multiple Java files used together, compile them all:

```bash
javac *.java
```

Then run the class that contains the `main` method:

```bash
java Main
```

## Running the Code in GitHub Codespaces

Students may also use GitHub Codespaces to run the examples without installing Java locally.

Suggested steps:

1. Open this repository on GitHub.
2. Click the green **Code** button.
3. Open the **Codespaces** tab.
4. Create a new codespace.
5. Open the terminal inside Codespaces.
6. Navigate to the relevant module folder.
7. Compile and run the Java files using `javac` and `java`.

Example:

```bash
cd module-04-growth-rates
javac LinearExample.java
java LinearExample
```

## Recommended Student Workflow

For each example, students should follow this process:

1. Read the code carefully.
2. Predict the output before running the program.
3. Compile and run the code.
4. Modify the input size or test data.
5. Observe how the output or running time changes.
6. Identify the main operation being repeated.
7. Classify the time complexity.
8. Explain the result using asymptotic notation.

This workflow is especially important for understanding algorithm analysis. The goal is not only to run code, but to reason about how the code scales.

## Example: Linear Growth

```java
public class LinearExample {
    public static void main(String[] args) {
        int n = 10;
        int operations = 0;

        for (int i = 0; i < n; i++) {
            operations++;
        }

        System.out.println("Operations: " + operations);
    }
}
```

This loop runs `n` times, so its time complexity is:

```text
O(n)
```

## Example: Quadratic Growth

```java
public class QuadraticExample {
    public static void main(String[] args) {
        int n = 10;
        int operations = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                operations++;
            }
        }

        System.out.println("Operations: " + operations);
    }
}
```

The nested loops produce approximately `n × n` operations, so the time complexity is:

```text
O(n²)
```

## Maximum Subsequence Sum Example

The maximum subsequence sum problem asks:

Given an integer array, what is the maximum possible sum of a contiguous subsequence?

Example:

```text
Input:  -2, 11, -4, 13, -5, 2
Output: 20
```

The maximum subsequence is:

```text
11, -4, 13
```

with sum:

```text
20
```

This repository demonstrates four solutions to this problem:

| Algorithm | Main Idea | Time Complexity |
|---|---|---:|
| Cubic brute force | Try all ranges and recompute each sum | `O(n³)` |
| Quadratic brute force | Try all ranges but update sum incrementally | `O(n²)` |
| Divide and conquer | Best left, best right, best crossing | `O(n log n)` |
| Linear algorithm | One pass using current and global best | `O(n)` |

This problem is a central example because it shows how algorithmic design can transform an inefficient solution into an optimal one.

## Asymptotic Notation Summary

| Notation | Meaning | Informal Interpretation |
|---|---|---|
| `O(g(n))` | Upper bound | Grows no faster than `g(n)` |
| `Ω(g(n))` | Lower bound | Grows at least as fast as `g(n)` |
| `Θ(g(n))` | Tight bound | Grows at the same rate as `g(n)` |
| `o(g(n))` | Strict upper bound | Grows strictly slower than `g(n)` |
| `ω(g(n))` | Strict lower bound | Grows strictly faster than `g(n)` |

Example:

```text
n = O(n²)
n = o(n²)
n² = O(n²)
n² ≠ o(n²)
```

Big O allows the same growth class.  
Little o requires strictly smaller growth.

## Notes on Timing Experiments

Some examples use `System.nanoTime()` to measure approximate runtime.

These experiments are useful for building intuition, but timing results may vary due to:

- JVM warm-up
- Hardware differences
- Operating system scheduling
- Background processes
- Cache behavior
- Input distribution
- Compiler optimizations

Therefore, empirical timing should be used together with mathematical analysis.

## Academic Use

These examples are provided for educational use in CS 3345. Students may use them to practice Java programming, data structure usage, and algorithm analysis.

Students are encouraged to modify the examples, create additional test cases, and compare different implementations.

## Important Reminder for Students

Running a program is not the same as understanding it.

For each example, ask:

- What is the input size?
- What is the basic operation?
- How many times does the operation execute?
- What is the dominant term?
- What is the Big O complexity?
- Is there a tighter Big Theta bound?
- What is the space complexity?
- Can a better data structure improve the algorithm?

## License and Usage

This repository is intended for course-related educational use.

If a license file is included in this repository, please follow the terms of that license. If no license is provided, please treat the materials as instructional examples for this course.

## Instructor

Prof. Dr. Şadi Evren Şeker  
The University of Texas at Dallas  
CS 3345 — Data Structures and Foundations of Algorithmic Analysis

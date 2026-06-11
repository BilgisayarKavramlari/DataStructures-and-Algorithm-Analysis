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

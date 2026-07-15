# Contributing and Student Workflow

This repository is primarily maintained by the instructor as a course resource for CS 3345.

Students are welcome to use the repository for practice, but they should normally work in their own fork.

## Recommended Student Workflow

1. Fork the repository to your own GitHub account.
2. Open your fork in GitHub Codespaces.
3. Navigate to the relevant Coding Lab.
4. Compile and run the Java examples.
5. Modify the code for practice.
6. Commit changes to your own fork.
7. Do not push directly to the instructor's repository.

## Running a Lab

Example:

```bash
cd lab-10-binary-search-trees
javac *.java
java BSTTestHarness
```

## Cleaning Compiled Files

```bash
find . -name "*.class" -delete
```

## Commit Examples

```bash
git add .
git commit -m "Practice binary search tree operations"
git push
```

## Instructor Maintenance Workflow

Before publishing or merging changes:

1. Check that every lab has a README.
2. Check that every lab has at least one runnable Java demo.
3. Run the compile script:

```bash
bash scripts/compile-all.sh
```

4. Review any educational simplifications.
5. Confirm that all documentation is in English.
6. Confirm that GitHub practice folders are called Coding Labs, not modules.

## Academic Integrity

Students may study and modify examples for learning. For graded work, students must follow the syllabus, eLearning instructions, and academic integrity policy.

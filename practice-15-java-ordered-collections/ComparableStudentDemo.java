import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ComparableStudentDemo
 *
 * Shows a custom class implementing Comparable to define its natural ordering.
 * The natural order here is by grade-point average, descending, with the name
 * as a tie-breaker. Collections.sort then uses compareTo without any extra
 * argument.
 *
 * Time complexity: O(n log n) for the sort.
 */
public class ComparableStudentDemo {

    /** A student whose natural order is highest GPA first. */
    static class Student implements Comparable<Student> {
        String name;
        double gpa;

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        @Override
        public int compareTo(Student other) {
            int byGpa = Double.compare(other.gpa, this.gpa);   // descending GPA
            if (byGpa != 0) {
                return byGpa;
            }
            return this.name.compareTo(other.name);            // ascending name
        }

        @Override
        public String toString() {
            return name + "(" + gpa + ")";
        }
    }

    public void demonstrate() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ada", 3.7));
        students.add(new Student("Linus", 3.9));
        students.add(new Student("Grace", 3.9));
        students.add(new Student("Dennis", 3.5));

        System.out.println("Before sorting: " + students);
        Collections.sort(students);          // uses compareTo
        System.out.println("After natural sort (GPA desc, name asc): " + students);
        System.out.println("Grace precedes Linus because equal GPA breaks ties on name.");
    }
}

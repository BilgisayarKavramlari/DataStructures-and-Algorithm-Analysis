import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ComparatorDemo
 *
 * Shows external orderings supplied by Comparator objects, independent of a
 * class's natural order. The same list is sorted three different ways without
 * modifying the element class, illustrating the separation between an object's
 * identity and the many orders we may impose on it.
 *
 * Time complexity: O(n log n) per sort.
 */
public class ComparatorDemo {

    static class Book {
        String title;
        int year;
        double price;

        Book(String title, int year, double price) {
            this.title = title;
            this.year = year;
            this.price = price;
        }

        @Override
        public String toString() {
            return title + "[" + year + ", $" + price + "]";
        }
    }

    public void demonstrate() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Algorithms", 2011, 80.0));
        books.add(new Book("Data Structures", 2011, 65.5));
        books.add(new Book("Compilers", 2006, 95.0));

        Comparator<Book> byYear = Comparator.comparingInt(b -> b.year);
        Comparator<Book> byPrice = Comparator.comparingDouble(b -> b.price);
        Comparator<Book> byYearThenPrice = byYear.thenComparing(byPrice);

        List<Book> a = new ArrayList<>(books);
        a.sort(byYear);
        System.out.println("By year         : " + a);

        List<Book> b = new ArrayList<>(books);
        b.sort(byPrice.reversed());
        System.out.println("By price desc   : " + b);

        List<Book> c = new ArrayList<>(books);
        c.sort(byYearThenPrice);
        System.out.println("Year then price : " + c);
        System.out.println("Comparators let one class support many orders at once.");
    }
}

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Ex 9.3 (Intermediate)
class Book {
    private final String isbn, title;
    Book(String isbn, String title) { this.isbn = isbn; this.title = title; }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book b)) return false;
        return isbn.equals(b.isbn);                  // identity of a book = its ISBN
    }
    @Override public int hashCode() { return Objects.hash(isbn); }   // uses the SAME field as equals
    @Override public String toString() { return title + " [" + isbn + "]"; }
}
public class BookSet {
    public static void main(String[] args) {
        Set<Book> set = new HashSet<>();
        System.out.println(set.add(new Book("978-1", "Clean Code")));
        System.out.println(set.add(new Book("978-1", "Clean Code (2nd copy)")));   // duplicate ISBN
        System.out.println(set.add(new Book("978-2", "Effective Java")));
        System.out.println("size = " + set.size());   // 2 distinct books
        // Without hashCode the two equal Books would usually land in different buckets and both be kept.
    }
}

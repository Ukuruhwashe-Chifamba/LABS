import java.util.*;

// Ex 8.2 (Basic)
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> names = List.of("Tariro", "Farai", "Tariro", "Rudo", "Farai", "Chipo");
        Set<String> unique = new LinkedHashSet<>(names);   // a Set rejects duplicates; Linked keeps first-seen order
        System.out.println(names + " -> " + unique);
    }
}

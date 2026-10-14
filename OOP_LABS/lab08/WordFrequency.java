import java.util.*;

// Ex 8.4 (Intermediate)
public class WordFrequency {
    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog the fox";
        Map<String, Integer> freq = new HashMap<>();
        for (String w : text.toLowerCase().split("\\W+")) {
            if (!w.isEmpty()) freq.merge(w, 1, Integer::sum);
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed()
                     .thenComparing(Map.Entry.comparingByKey()));      // frequency desc, then alphabetical
        for (Map.Entry<String, Integer> e : entries) System.out.println(e.getKey() + ": " + e.getValue());
    }
}

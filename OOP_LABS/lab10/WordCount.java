import java.io.IOException;
import java.nio.file.*;
import java.util.List;

// Ex 10.3 (Intermediate): like the Unix wc command. Usage: java WordCount [file]
public class WordCount {
    public static void main(String[] args) throws IOException {
        Path file;
        if (args.length > 0) file = Paths.get(args[0]);
        else {
            file = Paths.get("sample.txt");
            Files.writeString(file, "Java is fun.\nObjects hold state.\n\nClasses are blueprints.\n");
        }
        List<String> lines = Files.readAllLines(file);
        long words = lines.stream().flatMap(l -> java.util.Arrays.stream(l.trim().split("\\s+"))).filter(w -> !w.isEmpty()).count();
        long chars = Files.readString(file).length();
        System.out.println("Lines: " + lines.size() + ", words: " + words + ", characters: " + chars);
    }
}

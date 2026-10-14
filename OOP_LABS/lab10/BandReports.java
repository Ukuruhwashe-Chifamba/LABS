import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

// Ex 10.5 (Challenge). learners.csv format: name,score  (header row first)
public class BandReports {
    record Learner(String name, int score) {
        String band() { return score >= 75 ? "A" : score >= 60 ? "B" : "C"; }
    }
    public static void main(String[] args) throws IOException {
        Path csv = Paths.get("learners.csv");
        if (!Files.exists(csv)) {
            Files.write(csv, List.of("name,score", "Tendai,70", "Anesu,85", "Chipo,60", "Blessing,90", "Farai,45", "Rudo,78", "Tariro,55"));
        }
        List<Learner> learners = Files.readAllLines(csv).stream().skip(1)
            .filter(l -> !l.isBlank())
            .map(l -> l.split(","))
            .map(p -> new Learner(p[0].trim(), Integer.parseInt(p[1].trim())))
            .toList();

        Map<String, List<Learner>> byBand = learners.stream()
            .collect(Collectors.groupingBy(Learner::band, TreeMap::new, Collectors.toList()));

        for (Map.Entry<String, List<Learner>> e : byBand.entrySet()) {
            List<String> report = new ArrayList<>();
            report.add("Band " + e.getKey() + " (" + e.getValue().size() + " learners)");
            e.getValue().stream().sorted(Comparator.comparing(Learner::name))
                .forEach(l -> report.add(l.name() + ", " + l.score()));
            Path out = Paths.get("band_" + e.getKey() + ".txt");
            Files.write(out, report);
            System.out.println("Wrote " + out + ": " + report.subList(1, report.size()));
        }
    }
}

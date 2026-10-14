import java.util.*;

// Ex 10.4 (Intermediate)
record Learner(String name, int score) { }
public class AboveAverage {
    public static void main(String[] args) {
        List<Learner> list = List.of(new Learner("Tendai", 70), new Learner("Anesu", 85), new Learner("Chipo", 60), new Learner("Blessing", 90));
        double avg = list.stream().mapToInt(Learner::score).average().orElse(0);
        System.out.println("Average = " + avg);
        list.stream()
            .filter(l -> l.score() > avg)
            .map(Learner::name)
            .sorted()
            .forEach(System.out::println);
    }
}

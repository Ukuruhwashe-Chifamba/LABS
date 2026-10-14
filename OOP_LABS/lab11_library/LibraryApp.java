import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Path dataDir = Paths.get("library-data");
        Library lib = new Library();
        try { lib.load(dataDir); System.out.println("Data loaded."); }
        catch (IOException | RuntimeException e) { System.out.println("Could not load data: " + e.getMessage()); }

        Scanner in = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n1 Add item  2 Register member  3 Borrow  4 Return  5 Overdue  6 Search  0 Exit");
            System.out.print("> ");
            if (!in.hasNextLine()) break;
            String choice = in.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Type (book/dvd), id, title: ");
                        String[] p = in.nextLine().split(",", 3);
                        String t = p[0].trim().toLowerCase();
                        LibraryItem item = t.equals("dvd") ? new Dvd(p[1], p[2]) : new Book(p[1], p[2]);
                        lib.addItem(item); System.out.println("Added: " + item);
                    }
                    case "2" -> {
                        System.out.print("Member id, name: ");
                        String[] p = in.nextLine().split(",", 2);
                        lib.registerMember(new Member(p[0], p[1])); System.out.println("Registered.");
                    }
                    case "3" -> {
                        System.out.print("Member id, item id: ");
                        String[] p = in.nextLine().split(",");
                        lib.borrow(p[0].trim(), p[1].trim()); System.out.println("Borrowed.");
                    }
                    case "4" -> { System.out.print("Item id: "); lib.giveBack(in.nextLine().trim()); System.out.println("Returned."); }
                    case "5" -> {
                        var overdue = lib.overdueLoans();
                        if (overdue.isEmpty()) System.out.println("No overdue items.");
                        else overdue.forEach(l -> System.out.println("OVERDUE: " + l));
                    }
                    case "6" -> {
                        System.out.print("Title contains: ");
                        var found = lib.searchByTitle(in.nextLine().trim());
                        if (found.isEmpty()) System.out.println("No matches.");
                        else found.forEach(System.out::println);
                    }
                    case "0" -> running = false;
                    default -> System.out.println("Unknown option.");
                }
            } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                System.out.println("Cannot borrow: " + e.getMessage());          // expected business failures
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
        try { lib.save(dataDir); System.out.println("Data saved."); }
        catch (IOException e) { System.out.println("Could not save: " + e.getMessage()); }
    }
}

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final Map<String, Loan> loans = new HashMap<>();      // keyed by item id (one active loan per item)

    public void addItem(LibraryItem item) {
        if (items.putIfAbsent(item.getId(), item) != null) throw new IllegalArgumentException("Duplicate item id " + item.getId());
    }
    public void registerMember(Member m) {
        if (members.putIfAbsent(m.getId(), m) != null) throw new IllegalArgumentException("Duplicate member id " + m.getId());
    }

    public void borrow(String memberId, String itemId) throws ItemNotAvailableException, MemberLimitExceededException {
        Member m = members.get(memberId);
        LibraryItem item = items.get(itemId);
        if (m == null) throw new IllegalArgumentException("No such member: " + memberId);
        if (item == null) throw new IllegalArgumentException("No such item: " + itemId);
        item.borrow(m);                                   // checks availability and limit; marks item unavailable
        Loan loan = new Loan(item, m, LocalDate.now());
        loans.put(itemId, loan);
        m.addLoan(loan);
    }

    public void giveBack(String itemId) {
        Loan loan = loans.remove(itemId);
        if (loan == null) throw new IllegalArgumentException("Item " + itemId + " is not on loan");
        loan.getMember().removeLoan(loan);
        loan.getItem().giveBack();
    }

    public List<Loan> overdueLoans() {
        return loans.values().stream().filter(Loan::isOverdue)
                    .sorted(Comparator.comparing(Loan::getDueDate)).toList();
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
            .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
            .sorted(Comparator.comparing(LibraryItem::getTitle))
            .toList();
    }

    // ---- CSV persistence (Lab 10) ----
    public void save(Path dir) throws IOException {
        Files.createDirectories(dir);
        Files.write(dir.resolve("items.csv"), items.values().stream()
            .sorted(Comparator.comparing(LibraryItem::getId)).map(i -> i.type() + "," + i.getId() + "," + i.getTitle()).toList());
        Files.write(dir.resolve("members.csv"), members.values().stream()
            .sorted(Comparator.comparing(Member::getId)).map(m -> m.getId() + "," + m.getName()).toList());
        Files.write(dir.resolve("loans.csv"), loans.values().stream()
            .sorted(Comparator.comparing(l -> l.getItem().getId()))
            .map(l -> l.getItem().getId() + "," + l.getMember().getId() + "," + l.getBorrowedOn()).toList());
    }

    public void load(Path dir) throws IOException {
        Path pi = dir.resolve("items.csv"), pm = dir.resolve("members.csv"), pl = dir.resolve("loans.csv");
        if (Files.exists(pi)) for (String line : Files.readAllLines(pi)) {
            String[] p = line.split(",", 3);              // limit 3: a title may itself contain commas
            addItem(p[0].equals("DVD") ? new Dvd(p[1], p[2]) : new Book(p[1], p[2]));
        }
        if (Files.exists(pm)) for (String line : Files.readAllLines(pm)) {
            String[] p = line.split(",", 2); registerMember(new Member(p[0], p[1]));
        }
        if (Files.exists(pl)) for (String line : Files.readAllLines(pl)) {
            String[] p = line.split(",");
            LibraryItem item = items.get(p[0]); Member m = members.get(p[1]);
            Loan loan = new Loan(item, m, LocalDate.parse(p[2]));
            item.setAvailable(false); loans.put(p[0], loan); m.addLoan(loan);     // restore state without re-checking limits
        }
    }
}

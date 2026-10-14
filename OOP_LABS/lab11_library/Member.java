import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {
    public static final int MAX_LOANS = 3;
    private final String id;
    private String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Member id required");
        this.id = id.trim(); setName(name);
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Member name required");
        this.name = name.trim();
    }
    public int activeLoanCount() { return loans.size(); }
    public List<Loan> getLoans() { return Collections.unmodifiableList(loans); }   // no leaking of internals
    void addLoan(Loan l) { loans.add(l); }
    void removeLoan(Loan l) { loans.remove(l); }
    @Override public String toString() { return id + " " + name + " (" + loans.size() + " loans)"; }
}

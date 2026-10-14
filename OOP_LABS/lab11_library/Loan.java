import java.time.LocalDate;

public class Loan {
    private final LibraryItem item;
    private final Member member;
    private final LocalDate borrowedOn;

    public Loan(LibraryItem item, Member member, LocalDate borrowedOn) {
        this.item = item; this.member = member; this.borrowedOn = borrowedOn;
    }
    public LibraryItem getItem() { return item; }
    public Member getMember() { return member; }
    public LocalDate getBorrowedOn() { return borrowedOn; }
    public LocalDate getDueDate() { return borrowedOn.plusDays(item.loanPeriodDays()); }
    public boolean isOverdue() { return LocalDate.now().isAfter(getDueDate()); }
    @Override public String toString() {
        return item.getTitle() + " -> " + member.getName() + ", due " + getDueDate();
    }
}

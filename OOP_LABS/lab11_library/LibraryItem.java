public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank() || title == null || title.isBlank())
            throw new IllegalArgumentException("Id and title are required");
        this.id = id.trim(); this.title = title.trim();
    }
    public abstract int loanPeriodDays();            // polymorphic: Book and Dvd differ
    public abstract String type();                    // used when saving to CSV

    public String getId()        { return id; }
    public String getTitle()     { return title; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }   // package-private, as in the manual's skeleton

    @Override public void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if (!available) throw new ItemNotAvailableException(id);
        if (member.activeLoanCount() >= Member.MAX_LOANS) throw new MemberLimitExceededException(member.getId(), Member.MAX_LOANS);
        available = false;
    }
    @Override public void giveBack() { available = true; }

    @Override public String toString() {
        return String.format("%s %s \"%s\" (%d-day loan, %s)", type(), id, title, loanPeriodDays(), available ? "available" : "on loan");
    }
}

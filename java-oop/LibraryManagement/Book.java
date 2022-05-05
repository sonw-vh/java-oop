public class Book extends Document {
    private String authorName;
    private int pageNumber;

    public Book() {}

    public Book(String id, String publisherName, String issueNumber, String authorName, int pageNumber) {
        super(id, publisherName, issueNumber);
        this.authorName = authorName;
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String printBookString() {
        return toString() + " | " + this.authorName + " | " + this.pageNumber;
    }
}

public class Newspaper extends Document {
    private String issueDate;

    public Newspaper() {}

    public Newspaper(String id, String publisherName, String issueNumber, String issueDate) {
        super(id, publisherName, issueNumber);
        this.issueDate = issueDate;
    }

    public String getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String printNewspaperString() {
        return toString() + " | " + this.issueDate;
    }
}

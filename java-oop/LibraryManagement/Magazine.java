public class Magazine extends Document {
    private String issueMonth;

    public Magazine() {}

    public Magazine(String id, String publisherName, String issueNumber, String issueMonth) {
        super(id, publisherName, issueNumber);
        this.issueMonth = issueMonth;
    }

    public String getIssueMonth() {
        return this.issueMonth;
    }

    public void setIssueMonth(String issueMonth) {
        this.issueMonth = issueMonth;
    }

    public String printMagazineString() {
        return toString() + " | " + this.issueMonth;
    }
}

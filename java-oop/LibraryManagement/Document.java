public class Document implements Comparable<Document> {
    private String id;
    private String publisherName;
    private String issueNumber;

    public Document()   {}

    public Document(String id, String publisherName, String issueNumber) {
        this.id = id;
        this.publisherName = publisherName;
        this.issueNumber = issueNumber;
    }

    public String getId()   {
		return this.id;
	}

    public void setId(String id)    {
		this.id = id;
	}

    public String getPublisherName() {
        return this.publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getIssueNumber() {
        return this.issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public int compareTo(Document d) {
        return d.id.compareTo(this.id);
    }

    @Override
    public String toString() {
        return this.id + " | " + this.publisherName + " | " + this.issueNumber;
    }
}

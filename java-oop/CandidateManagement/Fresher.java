public class Fresher extends Candidate {
    private String Graduation_date;
    private String Graduation_rank;

    public Fresher() {}

    public Fresher(String Graduation_date, String Graduation_rank, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.Graduation_date = Graduation_date;
        this.Graduation_rank = Graduation_rank;
    }

    public String getGraduation_date() {
        return this.Graduation_date;
    }

    public void setGraduation_date(String Graduation_date) {
        this.Graduation_date = Graduation_date;
    }

    public String getGraduation_rank() {
        return this.Graduation_rank;
    }

    public void setGraduation_rank(String Graduation_rank) {
        this.Graduation_rank = Graduation_rank;
    }


}

package WorkerManagement;

public class SalaryHistory extends Worker implements Comparable<SalaryHistory> {
    private String dateChange;
    private String status;
    private double newSalary;

    public SalaryHistory() {}

    public SalaryHistory(String dateChange, String status, double newSalary, String id, String name, int age, double salary, String workLocation) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.dateChange = dateChange;
        this.newSalary = newSalary;
    }

    public String getDateChange() {
        return dateChange;
    }

    public void setDateChange(String dateChange) {
        this.dateChange = dateChange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }

    @Override
    public int compareTo(SalaryHistory t) {
        return this.getId().compareTo(t.getId());
    }
    
}

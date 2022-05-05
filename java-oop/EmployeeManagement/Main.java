package lab.EmployeeManagement;

public class Main {
    public static void main(String[] args) {
        Lecturer lecturer = new Lecturer();
        Officer officer = new Officer();
        System.out.println(lecturer.calSalary());
        System.out.println(officer.calSalary());
    }
}

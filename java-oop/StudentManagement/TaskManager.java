import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {
        ArrayList<Student> t = new ArrayList<>();
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.err.println("\t1. Create");
            System.out.println("\t2. Find and Sort");
            System.out.println("\t3. Update/Delete");
            System.out.println("\t4. Report");
            System.out.println("\t5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validate.inputLimit(1, 5);
            switch (choice) {
                case 1:
                    StudentManagement.addStudent(t);
                    break;
                case 2:
                    StudentManagement.findAndSort(t);
                    break;
                case 3:
                    StudentManagement.updateAndDeleteStudent(t);
                    break;
                case 4:
                    StudentManagement.report(t);
                    break;
                case 5:
                    break;
            }
        }
    }

}
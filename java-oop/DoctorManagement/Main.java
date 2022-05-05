package DoctorManagement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Doctor> list = new ArrayList<>();
        while (true) {
            System.out.println("========= Doctor Management ==========\n"
                                + "\t1. Add Doctor\n"
                                + "\t2. Update Doctor\n"
                                + "\t3. Delete Doctor\n"
                                + "\t4. Search Doctor\n"
                                + "\t5. Exit\n"
                                + "===================================");
            System.out.println("Enter your choice: ");

            int choice = Valid.inputLimit(1, 5);
            switch (choice) {
                case 1:
                    Manager.addDoctor(list);
                    break;
                case 2:
                    Manager.updateDoctor(list);
                    break;
                case 3:
                    Manager.deleteDoctor(list);
                    break;
                case 4:
                    Manager.searchDoctor(list);
                    break;
                case 5:
                    return;
            }
        }
    }
}

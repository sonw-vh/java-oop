package WorkerManagement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        ArrayList<SalaryHistory> salaryHistories = new ArrayList<>();
        while (true) {
            System.out.println("======== Worker Management =========");
            System.out.println("\t1. Add Worker");
            System.out.println("\t2. Up salary");
            System.out.println("\t3. Down salary");
            System.out.println("\t4. Display Information salary");
            System.out.println("\t5. Exit");
            System.out.println("====================================");
            System.out.print("Enter your choice: ");

            int choice = Valid.inputLimit(1, 5);
            switch (choice) {
                case 1:
                    ManageWorker.addWorker(workers, salaryHistories);
                    break;
            
                case 2:
                    ManageWorker.changeSalary(workers, salaryHistories, 1);
                    break;

                case 3:
                    ManageWorker.changeSalary(workers, salaryHistories, 2);
                    break;

                case 4:
                    ManageWorker.getInfomationSalary(salaryHistories);
                    break;

                case 5:
                    return;
            }
        }
    }
}

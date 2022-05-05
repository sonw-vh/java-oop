package WorkerManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class ManageWorker {

    public static void addWorker(ArrayList<Worker> workers, ArrayList<SalaryHistory> salaryHistories) {
        System.out.println("--------- Add Worker ----------");

        System.out.print("Enter Code: ");
        String id = Valid.inputString();

        Valid.workerExist(workers, id);

        System.out.print("Enter Name: ");
        String name = Valid.inputString();

        System.out.print("Enter Age: ");
        int age = Valid.inputLimit(18, 50);

        System.out.print("Enter Salary: ");
        double salary = Valid.inputDouble();

        System.out.print("Enter work location: ");
        String workLocation = Valid.inputString();
        
        workers.add(new Worker(id, name, age, salary, workLocation));
        
        Worker worker = getWorkerById(workers, id);

        salaryHistories.add(new SalaryHistory(getCurrentDate(), "/", 0, worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation()));

        System.err.println("Successful!");
    }

    public static void changeSalary(ArrayList<Worker> workers, ArrayList<SalaryHistory> salaryHistories, int status) {
        if (workers.isEmpty()) {
            System.err.println("Empty list.");
            return;
        }

        System.out.println("------- Up/Down Salary --------");
        System.out.print("Enter Code: ");
        String id = Valid.inputString();
        Worker worker = getWorkerById(workers, id);

        if (worker == null) {
            System.err.println("Worker not exist!");
        } else {
            double salaryCurrent = worker.getSalary();
            double amount;
            double salaryUpdate;

            if (status == 0) {
                salaryUpdate = 0;
                salaryHistories.add(new SalaryHistory(getCurrentDate(), "/", salaryUpdate, worker.getId(), worker.getName(), worker.getAge(), salaryCurrent, worker.getWorkLocation()));
            }

            if (status == 1) {
                System.out.print("Enter Salary: ");
                amount = Valid.inputDouble();
                salaryUpdate = salaryCurrent + amount;

                salaryHistories.add(new SalaryHistory(getCurrentDate(), "UP", salaryUpdate, worker.getId(), worker.getName(), worker.getAge(), salaryCurrent, worker.getWorkLocation()));
                worker.setSalary(salaryUpdate);
            }

            if (status == 2) {
                System.out.println("Enter Salary: ");
                amount = Valid.inputChangeSalary(salaryCurrent);
                salaryUpdate = salaryCurrent - amount;

                salaryHistories.add(new SalaryHistory(getCurrentDate(), "DOWN", salaryUpdate, worker.getId(), worker.getName(), worker.getAge(), salaryCurrent, worker.getWorkLocation()));
                worker.setSalary(salaryUpdate);
            }
            System.err.println("Successful!");
        }
    }

    public static void getInfomationSalary(ArrayList<SalaryHistory> salaryHistories) {
        if (salaryHistories.isEmpty()) {
            System.err.println("Empty list.");
            return;
        }

        System.out.println("--------------------Display Information Salary-----------------------");
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age", "Salary", "Status", "Date");

        Collections.sort(salaryHistories);
        for (SalaryHistory h : salaryHistories) {
            System.out.printf("%-5s%-15s%-5d%-10s%-10s%-20s\n", h.getId(), h.getName(), h.getAge(), h.getSalary(), h.getStatus(), h.getDateChange());
        }
    }

    public static Worker getWorkerById(ArrayList<Worker> workers, String id) {
        for (Worker worker: workers)    if (id.equalsIgnoreCase(worker.getId()))    return worker;
        return null;
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}

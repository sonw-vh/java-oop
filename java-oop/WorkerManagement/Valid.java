package WorkerManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Valid {

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (NumberFormatException exception) {
                System.out.println("Please input a number. Enter again:");
            }
        }
    }

    public static double inputDouble() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (NumberFormatException exception) {
                System.out.println("Please input a double value. Enter again:");
            }
        }
    }

    public static int inputLimit(int min, int max) {
        while (true) {
            int result = inputInt();
            if (result >= min && result <= max) {
                return result;
            } else {
                System.out.println("Please input a number in range (" + min + "," + max + "): ");
            }
        }
    }

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static double inputChangeSalary(double salaryCurrent) {
        while (true) {
            double result = inputDouble();
            if (result >= 0 && result <= salaryCurrent) {
                return result;
            } else {
                System.out.println("Invalid salary update. Enter again: ");
            }
        }
    }

    public static boolean workerExist(ArrayList<Worker> workers, String id) {
        while (true) {
            for (Worker worker: workers)    if (id.equalsIgnoreCase(worker.getId()))    return false;

            return true;
        }
    }


}

package DoctorManagement;

import java.util.ArrayList;

import javax.print.Doc;

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

    public static int inputLimit(int min, int max) {
        while (true) {
            int result = inputInt();
            if (result >= min && result <= max) {
                return result;
            } else {
                System.out.println("Please input a number in range (" + min + "," + max + "):");
            }
        }
    }

    public static float inputFloat() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                float result = Float.parseFloat(scanner.nextLine());
                if (result >0){
                    return result;
                }
                else {
                    System.out.println("Please input a positive number. Enter again:");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Please input a number. Enter again:");
            }
        }
    }

    public static boolean inputYN() {
        System.out.print("Do you want to continue (Y/N)? ");
        while (true) {
            String result = inputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
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

    public static boolean codeExist(ArrayList<Doctor> list, String code) {
        for (Doctor doctor: list) {
            if (code.equalsIgnoreCase(doctor.getCode()))    return false;
        }
        return true;
    }

    public static boolean checkDuplicate(ArrayList<Doctor> list, String code, String name, String specialization, int availability) {
        for (Doctor doctor: list) {
            if (code.equalsIgnoreCase(doctor.getCode())
                && name.equalsIgnoreCase(doctor.getName())
                && specialization.equalsIgnoreCase(doctor.getSpecialization())
                && availability == doctor.getAvailability())    return false;
        }
        return true;
    }

    public static boolean checkChangeInfo(Doctor doctor, String code, String name, String specialization, int availability) {
        if (doctor.getCode().equalsIgnoreCase(code)
            && doctor.getName().equalsIgnoreCase(name)
            && doctor.getSpecialization().equalsIgnoreCase(specialization)
            && doctor.getAvailability() == availability)  return false;
        
        return true;
    }
}

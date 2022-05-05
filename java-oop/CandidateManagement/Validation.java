import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Validation {
    private final static String PHONE_STRING = "^\\d{10}\\d*$";
    private final static String EMAIL_STRING = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

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
                if (result > 0){
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

    public static boolean inputDate(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    public static String inputPhone() {
        while (true) {
            String result = inputString();
            if (result.matches(PHONE_STRING)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String inputEmail() {
        while (true) {
            String result = inputString();
            if (result.matches(EMAIL_STRING)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String inputGraduationRank() {
        while (true) {
            String result = inputString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input 1 of 4 values: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int inputExperience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = inputLimit(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age!");
            } else {
                return yearExperience;
            }
        }
    }
}

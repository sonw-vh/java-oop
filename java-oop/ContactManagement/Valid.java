package ContactManagement;

import java.util.Scanner;

public class Valid {
    private final static Scanner in = new Scanner(System.in);
    private static final String VALID_PHONE = "[0-9]{3}[-. ]?[0-9]{3}[-. ]?[0-9]{4}" + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
    
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

    public static String inputPhone() {
        while (true) {
            String result = inputString();
            if (result.matches(VALID_PHONE)) {
                return result;
            }

            System.err.println("Please input Phone flow\n"
            + "• 1234567890\n"
            + "• 123-456-7890 \n"
            + "• 123-456-7890 x1234\n"
            + "• 123-456-7890 ext1234\n"
            + "• 123.456.7890\n"
            + "• 123 456 7890");

            System.out.println("Please enter again: ");
        }
    }

}

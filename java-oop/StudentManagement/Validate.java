import java.util.Scanner;

public class Validate {
    private final static Scanner sc = new Scanner(System.in);

    public static String checkString() {
        while (true) {
            String result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static boolean inputYN() {
        System.out.print("Do you want to continue? Y/N: ");
        String result = checkString();
        while (true) {
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
        }
    }

    public static int checkInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number Integer !! ");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputCourse() {
        while (true) {
            String result = checkString();
            if (result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.out.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

    public static int inputLimit(int min, int max) {
        while (true) {
            int result = checkInt();
            if (result >= min && result <= max) {
                return result;
            } else {
                System.out.println("Please input a number in range (" + min + "," + max + "):");
            }
        }

    }

    public static boolean checkUD() {
        System.out.print("Do you want to Update or Delete? please enter U or D: ");
        String result = checkString();
        while (true) {
            if (result.equalsIgnoreCase("u") || result.equalsIgnoreCase("U") || result.equalsIgnoreCase("Up")
                    || result.equalsIgnoreCase("update")) {
                return true;
            }
            if (result.equalsIgnoreCase("D") || result.equalsIgnoreCase("d")
                    || result.equalsIgnoreCase("delete")) {
                return false;
            }
        }
    }

}

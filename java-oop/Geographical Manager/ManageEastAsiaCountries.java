import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManageEastAsiaCountries {
    
    private final static Scanner in = new Scanner(System.in);
    
    public static int menu(){
        System.out.println("======================================MENU==================================");
        System.out.println("1. Input the information of countries in East Asia.");
        System.out.println("2. Display the information of country you've just input.");
        System.out.println("3. Search the information of country by user-entered name.");
        System.out.println("4. Display the information of countries sorted name in ascending order.");
        System.out.println("5. Exit.");
        System.out.println("============================================================================");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 5);
        return choice;
    }

//----------------------Validator------------------------
    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("The number should be in range of [" + min + ", " + max + "]!");
                System.out.print("Please enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while (true)    {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("String not empty!");
                System.out.print("Please enter again: ");
            } else {
                return result;
            }
        }
    }

    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("The number should be a real number!");
                System.out.print("Please enter again: ");
            }
        }
    }

//----------------------------------MENU------------------------------------
    public static void inputCountry(ArrayList<EastAsiaCountries> lc) {
        System.out.print("Enter the code of country: ");
        String countryCode = checkInputString();
        
        if (!checkCountryExist(lc, countryCode))    {
            System.err.println("Country already existed!");
            return;
        }

        System.out.print("Enter the name of the country: ");
        String countryName = checkInputString();

        System.out.print("Enter total area of the country: ");
        double totalArea = checkInputDouble();

        System.out.print("Enter the terrain of the country: ");
        String countryTerrain = checkInputString();

        lc.add(new Country(countryTerrain, countryCode, countryName, totalArea));
        System.err.println("Successfully added!");
    }

    public static void printCountry(ArrayList<EastAsiaCountries> lc) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries country : lc)  {
            country.display();
        }
    }

    public static void printCountrySorted(ArrayList<EastAsiaCountries> lc) {
        Collections.sort(lc);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        
        for (EastAsiaCountries country : lc)  {
            country.display();
        }
    }

    public static void searchByName(ArrayList<EastAsiaCountries> lc) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = checkInputString();

        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries country : lc)    {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }

    public static boolean checkCountryExist(ArrayList<EastAsiaCountries> lc, String countryCode) {
        for (EastAsiaCountries country : lc) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }
}
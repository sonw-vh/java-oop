package ContactManagement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Contact> list = new ArrayList<>();

        while (true) {
            System.out.println("========= Contact program =========\n"
                                + "1. Add a Contact\n"
                                + "2. Display all Contact\n"
                                + "3. Delete a Contact\n"
                                + "4. Exit\n"
                                + "===================================");
            System.out.println("Enter your choice: ");

            int choice = Valid.inputLimit(1, 4);

            switch (choice) {
                case 1:
                    Manager.addContact(list);
                    break;
            
                case 2:
                    Manager.printAll(list);
                    break;

                case 3:
                    Manager.deleteContact(list);
                    break;
                default:
                    break;
            }
        }
    }
}

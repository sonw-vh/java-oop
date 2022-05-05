package ContactManagement;

import java.util.ArrayList;

public class Manager {
    public static void addContact(ArrayList<Contact> list) {
        System.out.print("Enter contact id: ");
        int contactId = Valid.inputInt();
        System.out.print("Enter first name: ");
        String firstName = Valid.inputString();
        System.out.print("Enter last name: ");
        String lastName = Valid.inputString();
        System.out.print("Enter group: ");
        String group = Valid.inputString();
        System.out.print("Enter address: ");
        String address = Valid.inputString();
        System.out.print("Enter phone: ");
        String phone = Valid.inputPhone();

        list.add(new Contact(contactId, firstName + lastName,  firstName, lastName, group, address, phone));
        System.out.println("Add successfully!");
    }

    public static void printAll(ArrayList<Contact> list) {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name", "First name", "Last name", "Group", "Address", "Phone");
        
        for (Contact ct: list) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n", ct.getContactId(), ct.getName(), ct.getFirstName(), ct.getLastName(), ct.getGroup(), ct.getAddress(), ct.getPhoneNumber());
        }
    }

    public static void deleteContact(ArrayList<Contact> list) {
        System.out.println("Enter contact id: ");
        int idDel = Valid.inputInt();
        Contact ctDel = getContactById(list, idDel);

        if (ctDel == null) {
            System.err.println("No found contact");
            return;
        } else {
            list.remove(ctDel);
        }
        System.err.println("Contact deleted!");
    }

    public static Contact getContactById(ArrayList<Contact> list, int idDel) {
        for (Contact ct: list) {
            if (ct.getContactId() == idDel) return ct;
        }
        return null;
    }
}

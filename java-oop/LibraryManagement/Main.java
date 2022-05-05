import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Document> documents = new ArrayList<>();
        Book book = new Book();
        Magazine magazine = new Magazine();
        Newspaper newspaper = new Newspaper();

        while (true) {
            System.out.println("======== Library Management=======");
            System.out.println("\t1. Add document");
            System.out.println("\t2. Delete document");
            System.out.println("\t3. View document information");
            System.out.println("\t4. Update document information");
            System.out.println("\t5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Valid.checkInputIntLimit(1, 5);

            switch (choice) {
                case 1:
                    Manager.addDocument(documents);
                    break;
            
                case 2:
                    Manager.deleteDocument(documents);
                    break;

                case 3:
                    Manager.getInfomationDocument(documents, book, magazine, newspaper);
                    break;
            
                case 4:
                    Manager.updateDocument(documents, book, magazine, newspaper);
                    break;

                case 5:
                    return;
            }
        }
    }
}

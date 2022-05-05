import java.util.ArrayList;

import javax.print.Doc;

public class Manager {
    public static void addDocument(ArrayList<Document> documents) {
        while (true) {
            System.out.println("--------- Add document --------");
            System.out.print("Please enter 1 to create Books, 2 to create Magazines, 3 to create Newspapers: ");
            int type = Valid.checkInputIntLimit(1, 3);
            
            System.out.print("Enter Document ID: ");
            String id = Valid.checkInputString();
            System.out.print("Enter Publisher Name: ");
            String publisherName = Valid.checkInputString();
            System.out.print("Enter new Issue Number: ");
            String issueNumber = Valid.checkInputString();

            Document document = new Document(id, publisherName, issueNumber);

            if (Valid.checkIdExist(documents, id)) {
                switch (type) {
                    case 1:
                        addBook(documents, document);
                        break;
                
                    case 2:
                        addMagazine(documents, document);
                        break;
    
                    case 3:
                        addNewspaper(documents, document);
                        break;
                }
            } else {
                return;
            }
            
            System.out.print("Do you want to continue? (Y/N): ");
            if (!Valid.checkInputYN()) {
                return;
            }
        }
    }

    public static void addBook(ArrayList<Document> documents, Document document) {
        System.out.print("Enter Author Name: ");
        String authorName = Valid.checkInputString();
        System.out.print("Enter Page Number: ");
        int pageNumber = Valid.checkInputInt();

        documents.add(new Book(document.getId(), document.getPublisherName(), document.getIssueNumber(), authorName, pageNumber));
    }

    public static void addMagazine(ArrayList<Document> documents, Document document) {
        System.out.print("Enter Issue Month: ");
        String issueMonth = Valid.checkInputString();

        documents.add(new Magazine(document.getId(), document.getPublisherName(), document.getIssueNumber(), issueMonth));
    }

    public static void addNewspaper(ArrayList<Document> documents, Document document) {
        System.out.print("Enter Issue Date: ");
        String issueDate = Valid.checkInputString();

        documents.add(new Newspaper(document.getId(), document.getPublisherName(), document.getIssueNumber(), issueDate));
    }

    public static void deleteDocument(ArrayList<Document> documents) {
        if (documents.isEmpty()) {
            System.err.println("Empty list!");
            return;
        }

        System.out.println("------- Delete document--------");
        System.out.print("Enter Code: ");
        String id = Valid.checkInputString();
        if (Valid.checkIdExist(documents, id)) {
            System.err.println("Not Found!");
        } else {
            for (Document document : documents) {
                if (document.getId().contains(id)) {
                    documents.remove(document);
                }
            }
            System.err.println("Delete successful");
        }
    }

    public static void getInfomationDocument(ArrayList<Document> documents, Book book, Magazine magazine, Newspaper newspaper) {
        if (documents.isEmpty()) {
            System.err.println("Empty list!");
            return;
        }

        System.out.println("--------------------Display Document Information---------------------");
        for (Document document : documents) {
            if (document instanceof Book) {
                System.out.println(book.printBookString());
            }

            if (document instanceof Magazine) {
                System.out.println(magazine.printMagazineString());
            }

            if (document instanceof Newspaper) {
                System.out.println(newspaper.printNewspaperString());
            }
        }
    }

    public static void updateDocument(ArrayList<Document> documents, Book book, Magazine magazine, Newspaper newspaper) {
        if (documents.isEmpty()) {
            System.err.println("Empty list!");
            return;
        }

        System.out.println("--------- Update document----------");
        System.out.print("Enter Code: ");
        String id = Valid.checkInputString();
        if (Valid.checkIdExist(documents, id)) {
            System.err.println("Not Found!");
        } else {
            for (Document document : documents) {
                if (document.getId().contains(id)) {
                    documents.remove(document);
                    System.out.print("Enter new Document ID: ");
                    String newId = Valid.checkInputString();
                    System.out.print("Enter new Publisher Name: ");
                    String newPublisherName = Valid.checkInputString();
                    System.out.print("Enter new Issue Number: ");
                    String newIssueNumber = Valid.checkInputString();

                    if (document instanceof Book) {
                        System.out.print("Enter new Author Name: ");
                        String newAuthorName = Valid.checkInputString();
                        System.out.println("Enter new Page Number: ");
                        int newPageNumber = Valid.checkInputInt();

                        book.setId(newId);
                        book.setPublisherName(newPublisherName);
                        book.setIssueNumber(newIssueNumber);
                        book.setAuthorName(newAuthorName);
                        book.setPageNumber(newPageNumber);
                    }

                    if (document instanceof Magazine) {
                        System.out.print("Enter new Issue Month: ");
                        String newIssueMonth = Valid.checkInputString();

                        magazine.setId(newId);
                        magazine.setPublisherName(newPublisherName);
                        magazine.setIssueNumber(newIssueNumber);
                        magazine.setIssueMonth(newIssueMonth);
                    }

                    if (document instanceof Newspaper) {
                        System.out.print("Enter new Issue Date: ");
                        String newIssueDate = Valid.checkInputString();

                        newspaper.setId(newId);
                        newspaper.setPublisherName(newPublisherName);
                        newspaper.setIssueNumber(newIssueNumber);
                        newspaper.setIssueDate(newIssueDate);
                    }
                }
            }
            System.err.println("Update successful");
        }
    }
}

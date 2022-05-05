import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<>();

        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("\t1. Experience");
            System.out.println("\t2. Fresher");
            System.out.println("\t3. Internship");
            System.out.println("\t4. Searching");
            System.out.println("\t5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validation.inputLimit(1, 5);

            switch (choice) {
                case 1:
                    Manage.createCandidate(candidates, 0);
                    break;
            
                case 2:
                    Manage.createCandidate(candidates, 1);
                    break;

                case 3:
                    Manage.createCandidate(candidates, 2);
                    break;

                case 4:
                    Manage.searchCandidate(candidates);
                    break;

                case 5:
                    return;
            }
        }
    }
}

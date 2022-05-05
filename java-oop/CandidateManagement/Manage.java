import java.util.ArrayList;
import java.util.Calendar;

public class Manage {
    public static void createCandidate(ArrayList<Candidate> candidates, int type) {
        while (true) {
            System.out.print("Enter ID: ");
            String id = Validation.inputString();
            System.out.print("Enter First Name: ");
            String firstName = Validation.inputString();
            System.out.print("Enter Last Name: ");
            String lastName = Validation.inputString();
            System.out.print("Enter birth date: ");
            int birthDate = Validation.inputLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter Address: ");
            String address = Validation.inputString();
            System.out.print("Enter Phone: ");
            String phone = Validation.inputPhone();
            System.out.print("Enter Email: ");
            String email = Validation.inputEmail();

            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);

            if (checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                        
                    case 2:
                        createInternship(candidates, candidate);
                        break;
                }
            } else {
                return;
            }

            System.out.print("Do you want to continue (Y/N): ");
            if (!Validation.inputYN())  return;
        }
    }

    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    public static void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int ExpInYear = Validation.inputExperience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String ProSkill = Validation.inputString();
        candidates.add(new Experience(ExpInYear, ProSkill, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        System.err.println("Successful...");
    }

    public static void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String Graduation_date = Validation.inputString();
        System.out.print("Enter graduation rank: ");
        String Graduation_rank = Validation.inputString();
        candidates.add(new Fresher(Graduation_date, Graduation_rank, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        System.err.println("Successful...");
    }

    public static void createInternship(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter Major: ");
        String major = Validation.inputString();
        System.out.print("Enter Semester: ");
        String semester = Validation.inputString();
        System.out.print("Enter University: ");
        String university = Validation.inputString();
        candidates.add(new Internship(major, semester, university, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        System.err.println("Successful...");
    }

    public static void searchCandidate(ArrayList<Candidate> candidates) {
        System.err.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.err.println("==========FRESHER CANDIDATE==============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.err.println("===========INTERN CANDIDATE==============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        System.out.print("Input Candidate name (First name or Last name): ");
        String searchName = Validation.inputString();
        System.out.print("Input type of candidate: ");
        int type = Validation.inputLimit(0, 2);

        for (Candidate candidate : candidates) {
            if (candidate.getType() == type && candidate.getFirstName().contains(searchName) || candidate.getLastName().contains(searchName)) {
                System.out.println(candidate.toString());
            }
        }
    }
}

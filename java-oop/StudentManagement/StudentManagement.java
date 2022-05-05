import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<Student>();

    public static void addStudent(ArrayList<Student> students) {
        int size = 0;
        boolean YN = false;
        while (size < 3 || YN == true) {
            System.out.print("Enter ID: ");
            String id = Validate.checkString();

            System.out.print("Enter Name: ");
            String name = Validate.checkString();

            System.out.print("Enter Semester: ");
            String semester = Validate.checkString();

            System.out.print("Enter Course Name: ");
            String courseName = Validate.checkInputCourse();

            students.add(new Student(id, name, semester, courseName));

            size++;
            if (size == 3) {
                if (Validate.inputYN() == false) {
                    YN = false;
                } else {
                    size--;
                    YN = true;
                }
            }
        }
    }

    public static void findAndSort(ArrayList<Student> s) {
        ArrayList<Student> listStudentFindByName = listStudentFindByName(s);
        if (listStudentFindByName.isEmpty()) {
            System.out.println("Not exist.");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "Semester", "Course Name");
            for (Student student : listStudentFindByName) {
                student.print();
            }
        }
    }

    public static ArrayList<Student> listStudentFindByName(ArrayList<Student> s) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = Validate.checkString();
        for (Student student : s) {
            if (student.getStudentName().contains(name))    listStudentFindByName.add(student);
        }
        return listStudentFindByName;
    }

    public static Student existCode(ArrayList<Student> d, String code) {
        for (Student Student : d) {
            if (code.equalsIgnoreCase(Student.getId())) {
                return Student;
            }
        }
        return null;
    }

    public static void updateAndDeleteStudent(ArrayList<Student> d) {
        while (true) {
            System.out.print("Enter code for update or delete: ");
            String code = Validate.checkString();
            Student dd = existCode(d, code);
            if (dd != null) {
                boolean a = Validate.checkUD();
                if (a == true) {
                    System.out.print("Enter Name: ");
                    String name = Validate.checkString();

                    System.out.print("Enter Semester: ");
                    String semester = Validate.checkString();

                    System.out.print("Enter course name: ");
                    String coursename = Validate.checkString();

                    dd.setStudent(name, semester, coursename);
                    System.out.println("Student updated!");

                } else {
                    d.remove(dd);
                    System.out.println("Student deleted!");
                }
            } else
                System.err.println("Student not existed!");
            if (Validate.inputYN() == false) {
                break;
            }
        }
    }

    public static void report(ArrayList<Student> list) {
        HashMap<String, Integer> report = new HashMap<>();
        Integer value;
        for (Student st : list) {
            String key = st.getStudentName() + " | " + st.getCourseName();

            if (report.containsKey(key)) {
                value = report.get(key);
                report.remove(key);
                report.put(key, value + 1);
            } else  report.put(key, 1);
        }

        for (String key : report.keySet()) {
            System.out.println(key + " | " + report.get(key));
        }
    }
}

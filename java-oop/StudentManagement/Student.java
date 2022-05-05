public class Student implements Comparable<Student> {
    String id;
    String studentName;
    String semester;
    String courseName;

    public Student() {}

    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudent(String studentName, String semester, String courseName) {
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "id=" + id + ",StudentName=" + studentName + ",Semester=" + semester + ",CourseName=" + courseName;
    }

    @Override
    public int compareTo(Student o) {
        if (this.studentName.compareTo(o.studentName) == 0)     return 0;
        else  return this.studentName.compareTo(o.studentName);
    }

    public void print() {
        System.out.printf("%-15s%-15s%-15s\n", studentName, semester, courseName);
    }
}

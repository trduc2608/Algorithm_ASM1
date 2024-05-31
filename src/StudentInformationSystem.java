import java.util.ArrayList;
import java.util.Comparator;

public class StudentInformationSystem {
    private ArrayList<Student> students;

    public StudentInformationSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String ID, String name, double mark) {
        this.students.add(new Student(ID, name, mark));
    }

    public void editStudent(String ID, String newName, double newMark) {
        for (Student student : students) {
            if (student.ID.equals(ID)) {
                student.name = newName;
                student.mark = newMark;
                break;
            }
        }
    }

    public void deleteStudent(String ID) {
        students.removeIf(student -> student.ID.equals(ID));
    }

    public Student searchStudent(String ID) {
        for(Student student : students) {
            if (student.ID.equals(ID)) {
                return student;
            }
        }
        return null;
    }

    public void sortStudents() {
        students.sort(Comparator.comparingDouble(student -> student.mark));
    }

    public void displayStudents() {
        for(Student student : students) {
            System.out.println(student);
        }
    }


}

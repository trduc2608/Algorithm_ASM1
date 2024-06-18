import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class StudentInformationSystem {
    private ArrayList<Student> students;

    public StudentInformationSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(int ID, String name, double mark) {
        if(searchStudent(ID) == null) {
            this.students.add(new Student(ID, name, mark));
        } else {
            System.out.println("Student with ID " + ID + " already exists");
        }
    }

    public void editStudent(int ID, String newName, double newMark) {
        for (Student student : students) {
            if (student.getID() == ID) {
                student.setName(newName);
                student.setMark(newMark);
                break;
            }
        }
    }

    public void deleteStudent(int ID) {
//        students.removeIf(student -> student.getID() == ID);
        for(Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
            Student student = iterator.next();
            if(student.getID() == ID) {
                iterator.remove();
                break;
            }
        }
    }

    public Student searchStudent(int ID) {
        for(Student student : students) {
            if (student.getID() == ID) {
                return student;
            }
        }
        return null;
    }

    public void sortStudents() {
        students.sort(Comparator.comparingDouble(Student::getMark).reversed());
    }

    public void displayStudents() {
        for(Student student : students) {
            System.out.println(student);
        }
    }

    public void mergeSortStudents() {
        if (students.isEmpty()) {
            return;
        }
        students = mergeSort(new ArrayList<>(students));
    }

    private ArrayList<Student> mergeSort(ArrayList<Student> list) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        ArrayList<Student> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(list.subList(mid, list.size()));

        return merge(mergeSort(left), mergeSort(right));
    }

    private ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right) {
        ArrayList<Student> merged = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).getMark() <= right.get(0).getMark()) {
                merged.add(left.remove(0));
            } else {
                merged.add(right.remove(0));
            }
        }

        merged.addAll(left);
        merged.addAll(right);
        return merged;
    }

}

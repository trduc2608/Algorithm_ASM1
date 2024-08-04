import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class StudentInformationSystem {
    private HashMap<Integer, Student> studentMap;
    private ArrayList<Student> students;

    public StudentInformationSystem() {
        this.students = new ArrayList<>();
        this.studentMap = new HashMap<>();
    }

    public void addStudent(int ID, String name, double mark) {
        if(!studentMap.containsKey(ID)) {
            Student newStudent = new Student(ID, name, mark);
            this.students.add(newStudent);
            this.studentMap.put(ID, newStudent);
        } else {
            System.out.println("Student with ID " + ID + " already exists");
        }
    }

    public void editStudent(int ID, String newName, double newMark) {
        Student student = this.studentMap.get(ID);
        if(student != null) {
            student.setName(newName);
            student.setMark(newMark);
        } else {
            System.out.println("Student with ID " + ID + " not found");
        }
    }

    public void deleteStudent(int ID) {
        Student student = studentMap.remove(ID);
        if (student != null) {
            students.remove(student);
        } else {
            System.out.println("Student with ID " + ID + " not found");
        }
    }

    public Student searchStudent(int ID) {
        sortStudents();
        return binarySearchStudent(ID);
    }

    private Student binarySearchStudent(int ID) {
        int left = 0;
        int right = this.students.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(students.get(mid).getID() == ID) {
                return this.students.get(mid);
            } else if(students.get(mid).getID() < ID) {
                left = mid + 1;
            } else {
                right = mid - 1;
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
            if (left.getFirst().getMark() <= right.getFirst().getMark()) {
                merged.add(left.removeFirst());
            } else {
                merged.add(right.removeFirst());
            }
        }

        merged.addAll(left);
        merged.addAll(right);
        return merged;
    }

}

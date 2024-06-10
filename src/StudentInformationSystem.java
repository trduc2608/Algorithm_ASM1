import java.util.ArrayList;
import java.util.Comparator;

public class StudentInformationSystem {
    private ArrayList<Student> students;

    public StudentInformationSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String ID, String name, double mark) {
        if(searchStudent(ID) == null) {
            this.students.add(new Student(ID, name, mark));
        } else {
            System.out.println("Student with ID " + ID + " already exists");
        }
    }

    public void editStudent(String ID, String newName, double newMark) {
        for (Student student : students) {
            if (student.getID().equals(ID)) {
                student.setName(newName);
                student.setMark(newMark);
                break;
            }
        }
    }

    public void deleteStudent(String ID) {
        students.removeIf(student -> student.getID().equals(ID));
    }

    public Student searchStudent(String ID) {
        for(Student student : students) {
            if (student.getID().equals(ID)) {
                return student;
            }
        }
        return null;
    }

    public void sortStudents() {
        students.sort(Comparator.comparingDouble(student -> student.getMark()));
    }

    public void displayStudents() {
        for(Student student : students) {
            System.out.println(student);
        }
    }

    public void mergeSortStudents() {
        if (students.isEmpty()) return;
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

    public void quickSortStudents() {
        if (students.isEmpty()) return;
        quickSort(0, students.size() - 1);
    }

    private void quickSort(int start, int end) {
        if (start < end) {
            int partitionIndex = partition(start, end);
            quickSort(start, partitionIndex - 1);
            quickSort(partitionIndex + 1, end);
        }
    }

    private int partition(int start, int end) {
        Student pivot = students.get(end);
        int i = (start - 1);
        for (int j = start; j < end; j++) {
            if (students.get(j).getMark() <= pivot.getMark()) {
                i++;
                Student temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
            }
        }

        Student temp = students.get(i + 1);
        students.set(i + 1, students.get(end));
        students.set(end, temp);

        return i + 1;
    }

}

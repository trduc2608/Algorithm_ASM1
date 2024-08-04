public class TestStudentInformationSystem {
    public static void main(String[] args) {
        StudentInformationSystem sms = new StudentInformationSystem();
        sms.addStudent(1, "Alice", 7.5);
        sms.addStudent(2, "Bob", 8.0);
        sms.addStudent(3, "Charlie", 6.0);
        sms.addStudent(4, "David", 9.5);
        sms.addStudent(5, "Eve", 5.0);

        System.out.println("Original List:");
        sms.displayStudents();

        System.out.println("\nSorted by marks (highest to lowest):");
        sms.mergeSortStudents();
        sms.displayStudents();

        System.out.println("\nEditing Bob's mark to 8.5:");
        sms.editStudent(2, "Bob", 8.5);
        sms.mergeSortStudents();
        sms.displayStudents();

        System.out.println("\nDeleting Alice:");
        sms.deleteStudent(1);
        sms.mergeSortStudents();
        sms.displayStudents();
    }
}

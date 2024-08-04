import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentInformationSystem sms = new StudentInformationSystem();
        Scanner sc = new Scanner(System.in);

        while (true){
            try {
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Search Students");
                System.out.println("5. Sorted Students(highest to lowest)");
                System.out.println("6. Display Students");
                System.out.println("7. Sorted Students(lowest to highest)");
                System.out.println("0. Exit");

                int choice = sc.nextInt();
                sc.nextLine();

                switch(choice){
                    case 1:
                        System.out.println("Enter Student ID: ");
                        int studentID = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter Student Name: ");
                        String studentName = sc.nextLine().trim();

                        System.out.println("Enter Student Mark: ");
                        double studentMark = sc.nextDouble();
                        if (studentMark < 0 || studentMark > 10) {
                            System.out.println("Marks must be between 0 and 10.");
                            break;
                        }

                        sms.addStudent(studentID, studentName, studentMark);
                        break;

                    case 2:
                        System.out.println("Enter Student ID to edit: ");
                        studentID = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter new Student Name: ");
                        studentName = sc.nextLine().trim();
                        System.out.println("Enter new Student Mark: ");
                        studentMark = sc.nextDouble();
                        if (studentMark < 0 || studentMark > 10) {
                            System.out.println("Marks must be between 0 and 10.");
                            break;
                        }
                        sms.editStudent(studentID, studentName, studentMark);
                        break;

                    case 3:
                        System.out.println("Enter Student ID to delete: ");
                        studentID = sc.nextInt();
                        sms.deleteStudent(studentID);
                        break;

                    case 4:
                        System.out.println("Enter Student ID to search: ");
                        studentID = sc.nextInt();
                        Student student = sms.searchStudent(studentID);
                        if(student != null){
                            System.out.println(student);
                        } else {
                            System.out.println("Student not found");
                        }
                        break;

                    case 5:
                        sms.sortStudents();
                        System.out.println("Sorted Students by marks (highest to lowest): ");
                        sms.displayStudents();
                        break;

                    case 6:
                        sms.displayStudents();
                        break;

                    case 7:
                        sms.mergeSortStudents();
                        System.out.println("Sorted Students by marks (lowest to highest): ");
                        sms.displayStudents();
                        break;

                    case 0:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter the correct value.");
                sc.nextLine(); // clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}

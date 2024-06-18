import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       StudentInformationSystem sms = new StudentInformationSystem();
       Scanner sc = new Scanner(System.in);

       while (true){
           System.out.println("1. Add Student");
           System.out.println("2. Edit Student");
           System.out.println("3. Delete Student");
           System.out.println("4. Search Students");
           System.out.println("5. Sort Students");
           System.out.println("6. Display Students");
           System.out.println("7. Merge Sort");
//           System.out.println("8. Quick Sort");
           System.out.println("0. Exit");

           int choice = sc.nextInt();
           sc.nextLine();

           switch(choice){
               case 1:
                   System.out.println("Enter Student ID: ");
                   int studentID = sc.nextInt();
                   sc.nextLine();

                   System.out.println("Enter Student Name: ");
                   String studentName = sc.nextLine();

                   System.out.println("Enter Student Mark: ");
                   double studentMark = sc.nextDouble();

                   sms.addStudent(studentID, studentName, studentMark);
                   break;
               case 2:
                   System.out.println("Enter Student ID to edit: ");
                   studentID = sc.nextInt();
                   sc.nextLine();
                   System.out.println("Enter new Student Name: ");
                   studentName = sc.nextLine();
                   System.out.println("Enter new Student Mark: ");
                   studentMark = sc.nextDouble();
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
                   System.out.println("Sorted Students by marks(highest to lowest): ");
                   sms.displayStudents();
                   break;
               case 6:
                   sms.displayStudents();
                   break;
               case 7:
                   sms.mergeSortStudents();
                   System.out.println("Sorted Students by marks(lowest to highest): ");
                   sms.displayStudents();
                   break;
//               case 8:
//                   sms.quickSortStudents();
//                   System.out.println("Sorted Students with Quick Sort: ");
//                   sms.displayStudents();
//                   break;
               case 0:
                   System.exit(0);
                   break;
               default:
                   System.out.println("Invalid choice. Try again.");
           }
       }
    }
}
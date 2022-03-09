import java.util.Scanner;

public class Menu {

  public static boolean isContinue = true;

  public static int getSelectionMenu(Scanner scanner) {
    System.out.println("\nPlease inter your selection:");
    System.out.println("1. Print all students");
    System.out.println("2. Add a student");
    System.out.println("3. Remove a student");
    System.out.println("4. Edit a student");
    System.out.println("5. Exit");
    int option = scanner.nextInt();
    return option;
  }

  public static int selectSortSectionMenu(Scanner scanner) {
    System.out.println("---Please inter your sort option:");
    System.out.println("\t1. Sort by INCRESING ID");
    System.out.println("\t2. Sort by DECREASING ID");
    System.out.println("\t3. Sort by INCRESING GPA");
    System.out.println("\t4. Sort by DECREASING GPA");
    System.out.println("\t5. Back to Menu");
    int option = scanner.nextInt();
    return option;
  }

  public static void handleMenuSelection(StudentManager studentManager, Scanner scanner, int selection) {
    switch (selection) {
      case 1:
        int sortOption = selectSortSectionMenu(scanner);
        studentManager.sortStudentListByOption(studentManager.getStudentList(), sortOption);
        studentManager.printStudentList();
        break;
      case 2:
        Student student = studentManager.inputNewStudent(scanner);
        scanner.nextLine();
        studentManager.addStudent(student);
        break;
      case 3:
        System.out.print("----Enter student ID you want to remove: ");
        scanner.nextLine();
        String id = studentManager.inputStudentID(scanner);
        studentManager.removeStudent(id);
        break;

      case 4:
        // edit here
        System.out.print("----Enter student ID you want to edit: ");
        scanner.nextLine();
        String editStudentId = studentManager.inputStudentID(scanner);
        studentManager.editStudent(editStudentId, scanner);
        break;
      case 5:
        isContinue = false;
        break;
      default:
        System.out.println("------> Invalid selection, please enter your selection again <------");
        break;
    }
  }
}

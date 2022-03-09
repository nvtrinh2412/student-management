
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    StudentManager studentManager = new StudentManager();
    ArrayList<Student> studentList = new ArrayList<Student>();
    final String sourceFile = "students.csv";
    final String targetFile = "students.csv";
    Scanner scanner = new Scanner(System.in);

    // Load Student Data from CSV File
    try {
      studentList = studentManager.loadStudentList(sourceFile);
      studentManager.setStudentList(studentList);
      studentManager.printStudentList();
    } catch (FileNotFoundException e1) {
      // e1.printStackTrace();
      System.out.println(e1.getMessage());
    }

    // Main Menu
      do{
        int menuSelection = Menu.getSelectionMenu(scanner);
        Menu.handleMenuSelection(studentManager, scanner, menuSelection);
      }
      while(Menu.isContinue);
      

    // Save Student Data to CSV File
      try {
        studentManager.saveStudentList(targetFile);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

  }
}

import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class StudentManager {
  private ArrayList<Student> studentList;

  public StudentManager() {
    studentList = new ArrayList<Student>();
  }

  public ArrayList<Student> loadStudentList(String fileName) throws FileNotFoundException {
    ArrayList<Student> list = new ArrayList<Student>();
    Scanner input = new Scanner(new File(fileName));
    final String HEADER_FILE = input.nextLine();
    while (input.hasNext()) {
      String[] data = (input.nextLine()).split(",");
      Student student = new Student(data[0], data[1], Integer.parseInt(data[2]), Float.parseFloat(data[3]), data[4],
          data[5]);
      list.add(student);
    }
    input.close();
    return list;
  }

  public void saveStudentList(String fileName) throws FileNotFoundException {
    File csvFile = new File(fileName);
    PrintWriter w = new PrintWriter(csvFile);
    w.println("Id,Name,Age,GPA,Address,Note");
    for (Student student : studentList) {
      w.println(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getGpa() + ","
          + student.getAddress() + "," + student.getNote());
    }
    w.close();
  }

  public void addStudent(Student student) {
    if(student != null) {
      studentList.add(student);
    }
  }

  public void removeStudent(String id) {
    for (Student student : studentList) {
      if (student.getId().equals(id)) {
        studentList.remove(student);
        return;
      }
    }
    System.out.println("!!! Student not found !!!");
  }

  public void printStudentList() {
    System.out.println(String.format(Student.FORMAT_RULE, "Id", "Name", "Age", "GPA", "Address", "Note"));
    for (Student student : studentList) {
      System.out.println(student.toString());
    }
  }

  public ArrayList<Student> getStudentList() {
    return this.studentList;
  }

  public void setStudentList(ArrayList<Student> studentList) {
    this.studentList = studentList;
  }

  public Student inputNewStudent(Scanner scanner) {
    try {
      scanner.nextLine();
      System.out.print("Enter student ID: ");
      String id = scanner.nextLine();
      System.out.print("Enter student name: ");
      String name = scanner.nextLine();
      System.out.print("Enter student age: ");
      int age = scanner.nextInt();
      scanner.nextLine();
      System.out.print("Enter student GPA: ");
      float gpa = scanner.nextFloat();
      scanner.nextLine();
      System.out.print("Enter student address: ");
      String address = scanner.nextLine();
      System.out.print("Enter student note: ");
      String note = scanner.nextLine();
      Student student = new Student(id, name, age, gpa, address, note);
      return student;
    } catch (InputMismatchException e1Exception) {
      System.out.println("!!! Invalid input, please try again !!!");
      return null;
    }
  }

  public String inputStudentID(Scanner scanner) {
    String id = scanner.nextLine();
    return id;
  }

  public void sortStudentListByOption(ArrayList<Student> students, int option) {
    switch (option) {
      case 1:
        students
            .sort((Student o1, Student o2) -> Integer.parseInt(o1.getId()) - Integer.parseInt(o2.getId()) > 0 ? 1 : -1);
        break;
      case 2:
        students
            .sort((Student o1, Student o2) -> Integer.parseInt(o2.getId()) - Integer.parseInt(o1.getId()) > 0 ? 1 : -1);
        break;
      case 3:
        students.sort((Student o1, Student o2) -> o1.getGpa() - o2.getGpa() > 0 ? 1 : -1);
        break;
      case 4:
        students.sort((Student o1, Student o2) -> o2.getGpa() - o1.getGpa() > 0 ? 1 : -1);
        break;
      case 5:
        Menu.getSelectionMenu(new Scanner(System.in));
      default:
        System.out.println("!!! Invalid sort option !!!");
    }
  }

  public void editStudent(String id, Scanner scanner) {
    for (Student student : studentList) {
      if (student.getId().equals(id)) {
        try {
          scanner = new Scanner(System.in);
          System.out.print("--> Enter new student name: ");
          String name = scanner.nextLine();
          System.out.print("--> Enter new student age: ");
          int age = scanner.nextInt();
          scanner.nextLine();
          System.out.print("--> Enter new student GPA: ");
          float gpa = scanner.nextFloat();
          scanner.nextLine();
          System.out.print("--> Enter new student address: ");
          String address = scanner.nextLine();
          System.out.print("--> Enter new student note: ");
          String note = scanner.nextLine();
          student.setName(name);
          student.setAge(age);
          student.setGpa(gpa);
          student.setAddress(address);
          student.setNote(note);
        } catch (InputMismatchException e) {
          System.out.println("!!! Invalid input, please try again !!!");
          return;
        }
      }
    }
    System.out.println("!!! Student not found !!!");
  }
}

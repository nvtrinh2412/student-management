
public class Student {
  private String id;
  private String name;
  private int age;
  private float gpa;
  private String address;
  private String note;
  public static final String FORMAT_RULE ="%-12s%-15s%-9s%-7s%-25s%-10s";

  public Student() {
  }

  public Student(String id, String name, int age, float gpa, String address, String note) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gpa = gpa;
    this.address = address;
    this.note = note;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public float getGpa() {
    return gpa;
  }

  public void setGpa(float gpa) {
    this.gpa = gpa;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    return String.format(FORMAT_RULE, id, name, age, gpa, address, note);
  }

}

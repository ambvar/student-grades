import java.util.Scanner;
import java.util.ArrayList;

class Student {
  public double grade;
  public String name;
  public String letGrade;

  public Student(double grade, String name, String letGrade) {
    this.grade = grade;
    this.name = name;
    this.letGrade = letGrade;
  }

  public String toString() {
    return "Final Grade = " + this.letGrade + ", Student Name = " + this.name;
  }

  public double getGrade() {
    return grade;
  }

}

public class Program {

  public static String letterGrade(double g, double total) {
    double per = 100 * (g / total );

    if (per >= 93) {
      return "A";
    } else if (per >= 86 && per < 93) {
      return "AB";
    } else if (per >= 82 && per < 86) {
      return "B";
    } else if (per >= 76 && per < 82) {
      return "BC";
    } else if (per >= 70 && per < 76) {
      return "C";
    } else if (per >= 65 && per < 70) {
      return "CD";
    } else if (per >= 60 && per < 65) {
      return "D";
    } else {
      return "F";
    }

  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numStudents;
    double totalPoints = 0.0;
    boolean morePoints = true;
    int count = 0;

    System.out.println("How many students?");
    numStudents = input.nextInt();
    input.nextLine();

    ArrayList<Student> list = new ArrayList<>();
    ArrayList<String> studentList = new ArrayList<>();

    for (int i = 1; i < numStudents + 1; i++) {
      String stuName;
      System.out.println("What is student " + i + "'s name?");
      stuName = input.nextLine();

      studentList.add(stuName);

    }


    while (morePoints == true) {

      double points = 0.0;
      System.out.println("What is the total points?");
      points = input.nextDouble();
      input.nextLine();

      totalPoints = totalPoints + points;

      for (int i = 0; i < studentList.size(); i++) {

        double stuGrade;
        System.out.println("What is " + studentList.get(i) + "'s grade?");
        stuGrade = input.nextDouble();
        input.nextLine();


        if (count == 0) {
          String letter = letterGrade(stuGrade, totalPoints);
          list.add(new Student(stuGrade, studentList.get(i), letter));
        } else {
          stuGrade = stuGrade + list.get(i).getGrade();
          String letter = letterGrade(stuGrade, totalPoints);
          list.set(i, new Student(stuGrade, studentList.get(i), letter));
        }
      }

      for(Student s : list) {
        System.out.println(s);
      }


      String ans;
      System.out.println("Would you like to add another score?");
      ans = input.next();

      if (ans.equals("yes")) {
        morePoints = true;
      } else {
        morePoints = false;
      }

      count++;

    }
  }
}

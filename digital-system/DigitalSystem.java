import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int id;
    double grade;

    Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Grade: " + grade;
    }
}

public class DigitalSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("=== Welcome to Digital Transformation System ===");

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Average");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();

            switch(choice){
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: calculateAverage(); break;
                case 5: System.out.println("System Closed."); break;
                default: System.out.println("Invalid Choice!");
            }

        } while(choice != 5);
    }

    static void addStudent(){
        input.nextLine();
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        System.out.print("Enter ID: ");
        int id = input.nextInt();
        System.out.print("Enter Grade: ");
        double grade = input.nextDouble();

        students.add(new Student(name,id,grade));
        System.out.println("Student Added Successfully!");
    }

    static void viewStudents(){
        if(students.isEmpty()){
            System.out.println("No Students Found.");
        } else {
            for(Student s : students){
                System.out.println(s);
            }
        }
    }

    static void searchStudent(){
        System.out.print("Enter ID to Search: ");
        int id = input.nextInt();
        for(Student s : students){
            if(s.id == id){
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student Not Found.");
    }

    static void calculateAverage(){
        if(students.isEmpty()){
            System.out.println("No Data Available.");
            return;
        }
        double sum = 0;
        for(Student s : students){
            sum += s.grade;
        }
        System.out.println("Average Grade: " + (sum/students.size()));
    }
}
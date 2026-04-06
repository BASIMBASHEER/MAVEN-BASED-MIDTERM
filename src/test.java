import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int totalClasses;
    int attendedClasses;

    public Student(String name, int totalClasses, int attendedClasses) {
        this.name = name;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public double calculatePercentage() {
        if (totalClasses == 0) return 0.0;
        return ((double) attendedClasses / totalClasses) * 100;
    }

    public void displayReport() {
        double percentage = calculatePercentage();
        System.out.println("Student: " + name);
        System.out.println("Attendance: " + String.format("%.2f", percentage) + "%");
        if (percentage < 75.0) {
            System.out.println("Status: Below 75% - Defaulter");
        } else {
            System.out.println("Status: Above 75% - Safe");
        }
        System.out.println("-------------------------");
    }
}

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        
        
        students.add(new Student("Alice", 40, 35));
        students.add(new Student("Bob", 40, 28));
        students.add(new Student("Charlie", 40, 20));

        
        for (Student s : students) {
            s.displayReport();
        }
    }
}

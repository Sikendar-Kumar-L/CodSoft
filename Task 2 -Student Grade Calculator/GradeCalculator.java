import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n    Student Grade Calculator\n");
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        double[] marks = new double[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter mark obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextDouble();
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid mark. Please enter a value between 0 and 100.");
                System.out.print("Enter mark obtained in subject " + (i + 1) + " (out of 100): ");
                marks[i] = scanner.nextDouble();
            }
        }

        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }

        double avgPercentage = totalMarks / numSubjects;

        String grade;
        if (avgPercentage >= 90) {
            grade = "A";
        } else if (avgPercentage >= 80) {
            grade = "B";
        } else if (avgPercentage >= 70) {
            grade = "C";
        } else if (avgPercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\nResults:");
        System.out.println("Total marks: " + totalMarks);
        System.out.println("Average percentage: " + String.format("%.2f", avgPercentage) + "%");
        System.out.println("Grade: " + grade);
    }
}
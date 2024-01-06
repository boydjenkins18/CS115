import java.util.ArrayList;
import java.util.Scanner;

/**
 * The QuizGrader class allows a user to enter up to 10 quiz scores.
 * It calculates and displays the average score and the corresponding letter grade.
 * The user can stop entering scores by inputting 999.
 */

public class QuizGrader {

    private static final int MAX_GRADES = 10;
    private static final double QUIT_SIGNAL = 999;

    /**
     * The main method serves as the entry point of the program.
     * It orchestrates the flow of the program by calling other methods.
     */

    public static void main(String[] args) {
        printProjectSpecifications();
        ArrayList<Double> grades = inputQuizGrades();
        printGrades(grades);
        double average = calculateAverage(grades);
        System.out.println("The average quiz score is: " + average);
        char letterGrade = determineLetterGrade(average);
        System.out.println("The corresponding letter grade is: " + letterGrade);
    }
    /**
     * Prints the specifications of the project.
     */
    private static void printProjectSpecifications() {
        System.out.println("===== PROJECT SPECIFICATIONS =====");
        System.out.println("1. This program allows the user to enter up to 10 quiz scores.");
        System.out.println("2. The user can stop entering scores by inputting 999.");
        System.out.println("3. The program calculates and displays the average score and the corresponding letter grade.");
        System.out.println("==================================");
    }

    /**
     * Inputs quiz grades from the user until the user enters the QUIT_SIGNAL or MAX_GRADES are entered.
     * Validates each input to ensure it is within the valid range.
     *
     * @return ArrayList containing the valid grades entered by the user.
     */

    private static ArrayList<Double> inputQuizGrades() {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter quiz scores (999 to quit):");

        while (grades.size() < MAX_GRADES) {
            System.out.print("Enter score #" + (grades.size() + 1) + ": ");
            double score = scanner.nextDouble();

            if (score == QUIT_SIGNAL) {
                break;
            } else if (score < 0 || score > 100) {
                System.out.println("Invalid score. Please enter a value between 0 and 100.");
            } else {
                grades.add(score);
            }
        }

        return grades;
    }

    /**
     * Prints all grades entered by the user.
     *
     * @param grades ArrayList containing the grades to be printed.
     */

    private static void printGrades(ArrayList<Double> grades) {
        System.out.println("Grades entered:");
        for (Double grade : grades) {
            System.out.println(grade);
        }
    }

    /**
     * Calculates the average of the grades.
     *
     * @param grades ArrayList containing the grades.
     * @return The average of the grades.
     */

    private static double calculateAverage(ArrayList<Double> grades) {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    /**
     * Determines the letter grade based on the average score.
     *
     * @param average The average score for which the letter grade is to be determined.
     * @return The corresponding letter grade.
     */

    private static char determineLetterGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

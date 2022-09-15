import java.util.Scanner;

public class QuizGrade {

    public static void main (String[] args) {
        int quizGrade = 0;
        int quit = 999;
        int averageQuizScore;
        //Created this constant variable to easily adjust the number of quizzes that can stored in the quizGradesArray
        final int MAX_QUIZZES = 10;

        quizGradeInstructions();
        System.out.println(""); //line break

        int[] quizGradesArray = new int[MAX_QUIZZES];
        int counter = 0;

        do {
            System.out.println("Enter a Quiz Grade! Note: Only enter whole numbers between 0-100; or enter 999 to quit:");

            /*
                The while loop below puts the users input through Try/Catch blocks to ensure the input is valid.
                If the input isn't valid then the user will get an error message
             */
            boolean runIsTrue = true;

            while (runIsTrue) {
                try {
                    Scanner userInput = new Scanner(System.in);
                    quizGrade = userInput.nextInt();
                    runIsTrue = false;
                } catch (Exception e) {
                    System.out.println("Error Message: " + e);
                    System.out.println("Please try again!");
                }
            }

            //I assumed that students cannot enter a negative score or a score higher than 100
            if (quizGrade >= 0 && quizGrade <= 100) {
                if (counter <= MAX_QUIZZES) {
                    quizGradesArray[counter] = quizGrade;
                    counter++;
                }
                //If the user has entered 10 quizzes, setting the quizGrade variable to 999 to exit the program
                if (counter == MAX_QUIZZES) {
                    quizGrade = 999;
                }
            } else {
                System.out.println("Try Again! You cannot enter a quiz grade less than 0 or more than 100.");
                System.out.println(""); //line break
            }
        } while(quizGrade != quit);

        //Prints out the grades stored in the quizGradesArray array
        System.out.println(""); //line break
        quizGradesPrintedBelowPrompt();
        returnQuizGradesFromArray(counter, quizGradesArray);

        //Prints out average quiz score out of x quizzes
        System.out.println(""); //line break
        averageQuizScore = getAverageQuizScore(counter, quizGradesArray);
        System.out.println("Average Quiz Score: " + averageQuizScore + "%");

        //Prints out the average letter grade based on the average quiz score
        getAverageScoreGrade(averageQuizScore);
    }

    public static void quizGradeInstructions() {
        System.out.println("Quiz Grade Program Overview: This program allows a student to enter 10 test quiz scores, " +
                "computes the average score, and then displays the letter grade.");
    }

    public static void quizGradesPrintedBelowPrompt() {
        System.out.println("Quiz Grades will be printed below:");
    }

    /*
        Note:
            Used the counter variable as the baseline to judge how many values are in the array
            to then print in case someone exited out the program prior to entering 10 quiz grades.

            So it only prints x amount of quiz grades that were entered instead of the entire array
            with empty values.
     */
    public static void returnQuizGradesFromArray(int counter, int[] arrayOfGrades) {
        for (int i = 0; i < counter; i++) {
            System.out.println("Quiz#" + ( i + 1) + " = " + arrayOfGrades[i] + "%");
        }
    }

    /*
        A method that contains the logic to loop through the array containing the quiz grades,
        add the scores and average them, then return the average
     */

    public static int getAverageQuizScore(int counter, int[] arrayOfGrades) {
        int total = 0;
        int average;

        for (int i = 0; i < counter; i++) {
            total += arrayOfGrades[i];
        }
        average = total / counter;

        return average;
    }

    //A method to contain the decision logic to determine the average score grade
    public static void getAverageScoreGrade(int averageQuizScore) {
        if (averageQuizScore >= 90) {
            System.out.println("Average Grade = A");
        } else if (averageQuizScore >= 80 && averageQuizScore <= 89) {
            System.out.println("Average Grade = B");
        } else if (averageQuizScore >= 70 && averageQuizScore <= 79) {
            System.out.println("Average Grade = C");
        } else if (averageQuizScore >= 60 && averageQuizScore <= 69) {
            System.out.println("Average Grade = D");
        } else {
            System.out.println("Average Grade = F");
        }
    }
}
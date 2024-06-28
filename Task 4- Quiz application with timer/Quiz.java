import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private String[] questions = {
            "What is the capital of France?",
            "Who is the CEO of SpaceX?",
            "Who invented the Computer?",
            "Which animal is known as the 'Ship of the Desert?",
            "What is the largest planet in our solar system?",
            "Who is known as the Father of our Nation?",
            "Who was the first President of India?",
            "Who is known as the Father of the Indian Constitution?",
            "Which is the most sensitive organ in our body?"
    };

    private String[] answers = {
            "Paris", "Elon Musk",
            "Charles Babbage","Camel",
            "Jupiter","Mahatma Gandhi",
            "Dr. Rajendra Prasad",
            "Dr. B. R. Ambedkar","Skin"
    };

    private int score = 0;
    private int timeLimit = 30; // in seconds

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                printScore();
                System.exit(0);
            }
        }, timeLimit * 1000); // convert seconds to milliseconds

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(answers[i])) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + answers[i]);
            }
        }

        printScore();
    }

    private void printScore() {
        System.out.println("Your final score is " + score + " out of " + questions.length);
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
    }
}
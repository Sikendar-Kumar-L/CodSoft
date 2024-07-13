import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.util.Collections;

class Quiz {
    private final String question;
    private final String[] options;
    private final String correctAnswer;
    private final int timeLimit;

    public Quiz(String question, String[] options, String correctAnswer, int timeLimit) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.timeLimit = timeLimit;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getTimeLimit() {
        return timeLimit;
    }
}

public class Main {
    private static final Quiz[] quizzes = {
            new Quiz("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Rome"}, "Paris", 10),
            new Quiz("What is the largest planet in our solar system?", new String[]{"Earth", "Saturn", "Jupiter", "Uranus"}, "Jupiter", 10),
            new Quiz("What is the smallest country in the world?", new String[]{"Vatican City", "Monaco", "Nauru", "Tuvalu"}, "Vatican City", 10),
            new Quiz("Which of the following planets is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, "Mars", 10),
            new Quiz("What is the largest living species of lizard?", new String[]{"Crocodile", "Alligator", "Komodo Dragon", "Turtle"}, "Komodo Dragon", 10),
            new Quiz("What is the world's largest waterfall, by volume of water?", new String[]{"Victoria Falls", "Iguazu Falls", "Niagara Falls", "Angel Falls"}, "Victoria Falls", 10),
            new Quiz("What is the highest mountain peak in the solar system?", new String[]{"Mount Everest", "Olympus Mons", "Mauna Kea", "Denali"}, "Olympus Mons", 10),
            new Quiz("What is the deepest part of the ocean?", new String[]{"Mariana Trench", "Challenger Deep", "Tonga Trench", "Kermadec Trench"}, "Challenger Deep", 10),
            new Quiz("What is the world's largest desert?", new String[]{"Sahara", "Gobi", "Mojave", "Atacama"}, "Sahara", 10),
            new Quiz("What is the longest river in South America?", new String[]{"Amazon River", "Parana River", "Sao Francisco River", "Magdalena River"}, "Amazon River", 10),
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Quiz quiz : quizzes) {
            String[] options = quiz.getOptions();
            String[] shuffledOptions = options.clone();
            Collections.shuffle(Arrays.asList(shuffledOptions)); // shuffle the options

            System.out.println("Question: " + quiz.getQuestion());
            for (int i = 0; i < shuffledOptions.length; i++) {
                System.out.println((i + 1) + ". " + shuffledOptions[i]);
            }

            final boolean[] timeUp = {false};
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    timeUp[0] = true;
                }
            }, quiz.getTimeLimit() * 1000L);

            String answer = scanner.nextLine();

            timer.cancel();

            if (timeUp[0]) {
                System.out.println("The correct answer is " + quiz.getCorrectAnswer());
            } else {
                for (int i = 0; i < shuffledOptions.length; i++) {
                    if (answer.equals(String.valueOf(i + 1))) {
                        if (shuffledOptions[i].equalsIgnoreCase(quiz.getCorrectAnswer())) {
                            score++;
                            System.out.println("Correct!");
                        } else {
                            System.out.println("Incorrect. The correct answer is " + quiz.getCorrectAnswer());
                        }
                        break;
                    }
                }
                if (!answer.matches("\\d+")) {
                    System.out.println("Invalid answer. The correct answer is " + quiz.getCorrectAnswer());
                }
            }
        }

        System.out.println("Your final score is " + score + " out of " + quizzes.length);
    }
}

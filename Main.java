import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        Student student = new Student("John", "Doe", "john.doe@gmail.com", "johndoe");
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", "A", "Paris", "B", "London", "C", "Berlin"));
        questions.add(new Question("What is the largest planet in our solar system?", "A", "Jupiter", "B", "Mars", "C", "Earth"));
        Exam exam = new Exam(questions);

        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Starting exam...");

        student.login("john.doe@gmail.com", "johndoe");

        for (Question question : questions) {
            System.out.println("Question: " + question.getQuestionText());
            System.out.println("Options: " + question.getOptionA() + ", " + question.getOptionB() + ", " + question.getOptionC());
            String selectedAnswer = "A"; // Assuming the student selects option A for each question
            student.selectAnswer(question, selectedAnswer);
            System.out.println("Selected Answer: " + selectedAnswer);
        }

        Timer timer = new Timer();
        TimerTask autoSubmitTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Auto-submitting exam...");
                exam.autoSubmit();
            }
        };
        timer.schedule(autoSubmitTask, 60000); // Exam will be auto submitted after 60 seconds
    }
}
class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Student(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void login(String email, String password) {
        // Add logic to validate user credentials and log in
    }

    public void updateProfile(String firstName, String lastName, String email, String password) {
        // Add logic to update profile information
    }

    public void selectAnswer(Question question, String answer) {
        // Add logic to select answer for the question
    }

    public void closeSession() {
        // Add logic to close the session and log out
    }
}

class Question {
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String correctAnswer;

    // Adjusted constructor with optionD
    public Question(String questionText, String optionA, String correctAnswerA,
                    String optionB, String correctAnswerB,
                    String optionC, String correctAnswerC) {
        this.questionText = questionText;
        this.optionA = optionA + ". " + correctAnswerA;
        this.optionB = optionB + ". " + correctAnswerB;
        this.optionC = optionC + ". " + correctAnswerC;
        this.correctAnswer = correctAnswerA; // Assuming optionA is the correct answer
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

class Exam {
    private ArrayList<Question> questions;

    public Exam(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void autoSubmit() {
        // Add logic to auto submit the exam
    }
}

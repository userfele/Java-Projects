import java.util.ArrayList;
import java.util.Collections;

public class QuizApp {

    enum QuestionType { Tof, MultipleChoice }
    enum Level { Easy, Medium, Hard }

    class Answer {
        private String id;
        private String questionId;
        private boolean isActive;
        private boolean isCorrect;
        private String answerText;

        public Answer(String id, String questionId, boolean isActive, boolean isCorrect, String answerText) {
            this.id = id;
            this.questionId = questionId;
            this.isActive = isActive;
            this.isCorrect = isCorrect;
            this.answerText = answerText;
        }

        public String getId() {
            return id;
        }

        public String getQuestionId() {
            return questionId;
        }

        public boolean isActive() {
            return isActive;
        }

        public boolean isCorrect() {
            return isCorrect;
        }

        public String getAnswerText() {
            return answerText;
        }
    }

    class Question {
        private String id;
        private String quizId;
        private QuestionType type;
        private Level level;
        private int score;
        private String questionText;
        private ArrayList<Answer> answers;

        public Question(String id, String quizId, QuestionType type, Level level, int score,
                        String questionText, ArrayList<Answer> answers) {
            this.id = id;
            this.quizId = quizId;
            this.type = type;
            this.level = level;
            this.score = score;
            this.questionText = questionText;
            this.answers = answers;
        }

        public String getId() {
            return id;
        }

        public String getQuizId() {
            return quizId;
        }

        public QuestionType getType() {
            return type;
        }

        public Level getLevel() {
            return level;
        }

        public int getScore() {
            return score;
        }

        public String getQuestionText() {
            return questionText;
        }

        public ArrayList<Answer> getAnswers() {
            return answers;
        }
    }

    class Quiz {
        private String id;
        private String title;
        private String summary;
        private int score;
        private boolean isPublished;
        private String hostId;
        private ArrayList<Question> questions;

        public Quiz(String id, String title, String summary, int score, boolean isPublished,
                    String hostId, ArrayList<Question> questions) {
            this.id = id;
            this.title = title;
            this.summary = summary;
            this.score = score;
            this.isPublished = isPublished;
            this.hostId = hostId;
            this.questions = questions;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getSummary() {
            return summary;
        }

        public int getScore() {
            return score;
        }

        public boolean isPublished() {
            return isPublished;
        }

        public String getHostId() {
            return hostId;
        }

        public ArrayList<Question> getQuestions() {
            return questions;
        }
    }

    class User {
        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private boolean isHost;
        private String intro;

        public User(String id, String firstName, String lastName, String email, boolean isHost, String intro) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.isHost = isHost;
            this.intro = intro;
        }

        public String getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public boolean isHost() {
            return isHost;
        }

        public String getIntro() {
            return intro;
        }
    }

    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();
        quizApp.quizAppTester();
    }

    public void quizAppTester() {
        User user = createUser();
        ArrayList<Question> quizQuestions = createQuizQuestions();

        Quiz quiz1 = createQuiz(
                "quiz1",
                "The Boubacar Quiz Trivia",
                "This quiz is a few simple basketball questions. " +
                        "The quiz is worth 25 points total.\n" +
                        "This is just to see what you know and what you don't know about the sport :).",
                25,
                true,
                user.getId(),
                quizQuestions
        );

        printQuiz(quiz1, user, false);
        System.out.println();
        printQuiz(quiz1, user, true);
    }

    public User createUser() {
        return new User(
                "host1",
                "Deon",
                "Clark",
                "teejayx6@gmail.com",
                true,
                "Welcome, enjoy the quiz!"
        );
    }

    public Quiz createQuiz(String id, String title, String summary, int score,
                           boolean isPublished, String hostId, ArrayList<Question> questions) {
        return new Quiz(id, title, summary, score, isPublished, hostId, questions);
    }

    public ArrayList<Question> createQuizQuestions() {
        ArrayList<Question> questions = new ArrayList<>();

        ArrayList<Answer> q1Answers = new ArrayList<>();
        q1Answers.add(new Answer("a1", "q1", true, true, "True"));
        q1Answers.add(new Answer("a2", "q1", true, false, "False"));

        questions.add(new Question(
                "q1",
                "quiz1",
                QuestionType.Tof,
                Level.Easy,
                5,
                "True or False: 1 + 1 = 2",
                q1Answers
        ));

        ArrayList<Answer> q2Answers = new ArrayList<>();
        q2Answers.add(new Answer("a3", "q2", true, false, "6'7\""));
        q2Answers.add(new Answer("a4", "q2", true, false, "6'8\""));
        q2Answers.add(new Answer("a5", "q2", true, true, "6'9\""));
        q2Answers.add(new Answer("a6", "q2", true, false, "6'10\""));

        questions.add(new Question(
                "q2",
                "quiz1",
                QuestionType.MultipleChoice,
                Level.Easy,
                5,
                "How tall is LeBron James?",
                q2Answers
        ));

        ArrayList<Answer> q3Answers = new ArrayList<>();
        q3Answers.add(new Answer("a7", "q3", true, true, "1 point"));
        q3Answers.add(new Answer("a8", "q3", true, false, "2 points"));
        q3Answers.add(new Answer("a9", "q3", true, false, "3 points"));
        q3Answers.add(new Answer("a10", "q3", true, false, "4 points"));

        questions.add(new Question(
                "q3",
                "quiz1",
                QuestionType.MultipleChoice,
                Level.Easy,
                5,
                "How many points is a free throw worth in basketball?",
                q3Answers
        ));

        ArrayList<Answer> q4Answers = new ArrayList<>();
        q4Answers.add(new Answer("a11", "q4", true, true, "True"));
        q4Answers.add(new Answer("a12", "q4", true, false, "False"));

        questions.add(new Question(
                "q4",
                "quiz1",
                QuestionType.Tof,
                Level.Medium,
                5,
                "True or False: The NBA three-point line is farther than the college three-point line.",
                q4Answers
        ));

        ArrayList<Answer> q5Answers = new ArrayList<>();
        q5Answers.add(new Answer("a13", "q5", true, false, "Cleveland Cavaliers"));
        q5Answers.add(new Answer("a14", "q5", true, true, "Miami Heat"));
        q5Answers.add(new Answer("a15", "q5", true, false, "Los Angeles Lakers"));
        q5Answers.add(new Answer("a16", "q5", true, false, "Chicago Bulls"));

        questions.add(new Question(
                "q5",
                "quiz1",
                QuestionType.MultipleChoice,
                Level.Medium,
                5,
                "Which team did LeBron James win his first NBA championship with?",
                q5Answers
        ));

        return questions;
    }

    public void printQuiz(Quiz quiz, User host, boolean instructorCopy) {
        ArrayList<Question> shuffledQuestions = new ArrayList<>(quiz.getQuestions());
        Collections.shuffle(shuffledQuestions);

        System.out.println("____________________");
        if (instructorCopy) {
            System.out.println("INSTRUCTOR VERSION");
        } else {
            System.out.println("STUDENT VERSION");
        }
        System.out.println("____________________");
        System.out.println();

        System.out.println("Host: " + host.getFirstName().charAt(0) + host.getLastName().charAt(0));
        System.out.println(host.getFirstName() + " " + host.getLastName());
        System.out.println(host.getIntro());
        System.out.println("Email: " + host.getEmail());
        System.out.println();

        System.out.println("Quiz Topic: " + quiz.getTitle());
        System.out.println();
        System.out.println(quiz.getSummary());
        System.out.println();

        for (int i = 0; i < shuffledQuestions.size(); i++) {
            Question question = shuffledQuestions.get(i);

            System.out.println((i + 1) + ") (" + question.getScore() + " points):");
            System.out.println(question.getQuestionText());

            ArrayList<Answer> shuffledAnswers = new ArrayList<>(question.getAnswers());
            Collections.shuffle(shuffledAnswers);

            char letter = 'A';
            String correctAnswer = "";

            for (Answer answer : shuffledAnswers) {
                if (answer.isActive()) {
                    System.out.println(letter + ". " + answer.getAnswerText());
                    if (answer.isCorrect()) {
                        correctAnswer = answer.getAnswerText();
                    }
                    letter++;
                }
            }

            if (instructorCopy) {
                System.out.println();
                System.out.println("Correct Answer: " + correctAnswer);
            }

            System.out.println();
        }
    }
}
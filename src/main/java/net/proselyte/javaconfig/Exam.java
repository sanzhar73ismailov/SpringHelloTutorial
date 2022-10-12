package net.proselyte.javaconfig;


public class Exam {
    private AnswerChecker answerChecker;

    public Exam() {
    }

    public Exam(AnswerChecker answerChecker) {
        this.answerChecker = answerChecker;
    }

    public AnswerChecker getAnswerChecker() {
        return answerChecker;
    }

    public void setAnswerChecker(AnswerChecker answerChecker) {
        this.answerChecker = answerChecker;
    }

    public void examCheck() {
        answerChecker.checkAnswer();
    }
}

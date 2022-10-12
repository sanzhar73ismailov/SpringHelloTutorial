package net.proselyte.dependencies;

public class Exam {
    private AnswerChecker answerChecker;

    public AnswerChecker getAnswerChecker() {
        return answerChecker;
    }

    public void setAnswerChecker(AnswerChecker answerChecker) {
        this.answerChecker = answerChecker;
    }

    public void examCheck(){
        answerChecker.checkAnswer();
    }
}

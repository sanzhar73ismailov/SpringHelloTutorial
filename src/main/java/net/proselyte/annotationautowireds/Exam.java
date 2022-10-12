package net.proselyte.annotationautowireds;

import org.springframework.beans.factory.annotation.Autowired;

public class Exam {
    private AnswerChecker answerChecker;

    public Exam() {
    }

    @Autowired
    public Exam(AnswerChecker answerChecker) {
        this.answerChecker = answerChecker;
    }

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

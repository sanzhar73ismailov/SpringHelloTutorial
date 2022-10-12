package net.proselyte.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamConfig {

    @Bean(name = "examBean")
    public Exam exam() {
        return new Exam(answerChecker());
    }


    public Exam exam2() {
        return new Exam();
    }

    @Bean
    public AnswerChecker answerChecker() {
        return new AnswerChecker();
    }
}

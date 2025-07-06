package org.skypro.exam.model;

import org.skypro.exam.service.QuestionService;

import java.util.Objects;

public class Question implements QuestionService {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String getTypeQuestion() {
        return question;
    }

    @Override
    public String getTypeAnswer() {
        return answer;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }

    @Override
    public Integer getSize() {
        return 0;
    }
}

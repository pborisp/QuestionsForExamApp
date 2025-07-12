package org.skypro.exam.service;

import org.skypro.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    public String getTypeAnswer() {
        return "";
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.size() == 0) {
            throw  new ReqestException("Список вопросов пуст");
        }
        int number = ThreadLocalRandom.current().nextInt(0, questions.size());
        List<Question> listOfQuestion = new ArrayList<>(questions);
        return listOfQuestion.get(number);
    }

    @Override
    public void addQuestionAnswer(String question, String answer) {
        Question questionAnswer = new Question(question, answer);
        this.questions.add(questionAnswer);
    }

    @Override
    public String remove(String question, String answer) {
        Question questionAnswer = new Question(question, answer);
        if (questions.remove(questionAnswer)) {
            return "Вопрос успешно удален";
        } else {
            throw new ReqestException("Невозможно удалить вопрос - отсутствует в списке");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

}

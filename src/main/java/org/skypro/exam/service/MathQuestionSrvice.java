package org.skypro.exam.service;

import org.skypro.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MathQuestionSrvice implements QuestionService, QuestionRepository{
    private final Set<Question> questionsMath;

    public MathQuestionSrvice() {
        this.questionsMath = new HashSet<>();
    }

    @Override
    public Question getRandomQuestion() {
        if (questionsMath.size() == 0) {
            throw  new ReqestException("Список вопросов пуст");
        }
        int number = ThreadLocalRandom.current().nextInt(0, questionsMath.size());
        List<Question> listOfQuestion = new ArrayList<>(questionsMath);
        return listOfQuestion.get(number);
    }

    @Override
    public void addQuestionAnswer(String question, String answer) {
        Question questionAnswer = new Question(question, answer);
        this.questionsMath.add(questionAnswer);
    }

    @Override
    public String remove(String question, String answer) {
        Question questionAnswer = new Question(question, answer);
        if (questionsMath.remove(questionAnswer)) {
            return "Вопрос успешно удален";
        } else {
            throw new ReqestException("Невозможно удалить вопрос - отсутствует в списке");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return questionsMath;
    }
}

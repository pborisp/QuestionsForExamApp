package org.skypro.exam.service;

import org.skypro.exam.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JavaQuestionService implements QuestionService, QuestionRepository {
    private final Set<Question> questionsJava;

    public JavaQuestionService() {
        this.questionsJava = new HashSet<>();
    }

    @Override
    public Question getRandomQuestion() {
        if (questionsJava.isEmpty()) {
            throw  new ReqestException("Список вопросов пуст");
        }
        int number = ThreadLocalRandom.current().nextInt(0, questionsJava.size());
        List<Question> listOfQuestion = new ArrayList<>(questionsJava);
        return listOfQuestion.get(number);
    }

    @Override
    public void addQuestionAnswer(String question, String answer) {
        Question questionAnswer = new Question(question, answer);
        this.questionsJava.add(questionAnswer);
    }

    @Override
    public String remove(String question, String answer) {
        Question questionAnswer = new Question(question, answer);
        if (questionsJava.remove(questionAnswer)) {
            return "Вопрос успешно удален";
        } else {
            throw new ReqestException("Невозможно удалить вопрос - отсутствует в списке");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return questionsJava;
    }

}

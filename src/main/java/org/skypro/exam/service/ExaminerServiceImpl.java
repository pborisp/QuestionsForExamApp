package org.skypro.exam.service;

import org.skypro.exam.model.Question;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final MathQuestionSrvice mathQuestionSrvice;
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(MathQuestionSrvice mathQuestionSrvice, JavaQuestionService javaQuestionService) {
        this.mathQuestionSrvice = mathQuestionSrvice;
        this.javaQuestionService = javaQuestionService;
    }

    @Bean
    private Random random() {
        return new Random();
    }

    @Override
    public Set<Question> getQuestion(int amount) {
        if (amount > (javaQuestionService.getAll().size() + mathQuestionSrvice.getAll().size())) {
            throw new ReqestException("Кол-во запрошенных вопросов больше общего кол-ва");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            if (random().nextBoolean()) {
                result.add(javaQuestionService.getRandomQuestion());
            } else {
                result.add(mathQuestionSrvice.getRandomQuestion());
            }
        }
        return result;
    }

    @Override
    public Collection<Question> getMathQuestion(int amount) {
        if (amount > mathQuestionSrvice.getAll().size()) {
            throw new ReqestException("Кол-во запрошенных вопросов больше общего кол-ва");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(mathQuestionSrvice.getRandomQuestion());
        }
        return result;
    }

    @Override
    public Collection<Question> getJavaQuestion(int amount) {
        if (amount > javaQuestionService.getAll().size()) {
            throw new ReqestException("Кол-во запрошенных вопросов больше общего кол-ва");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(javaQuestionService.getRandomQuestion());
        }
        return result;
    }
}

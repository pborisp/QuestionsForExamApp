package org.skypro.exam.service;

import org.skypro.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
//    private final Random random;
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
//        this.random = random;
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestion(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new ReqestException("Кол-во запрошенных вопросов больше общего кол-ва");
        }

        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}

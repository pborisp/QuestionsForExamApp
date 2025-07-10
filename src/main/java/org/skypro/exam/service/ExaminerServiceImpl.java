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
        Set<Question> listOfQuestion = new HashSet<>();
        listOfQuestion.addAll(questionService.getAll());
        if (amount > listOfQuestion.size()) {
            throw new ReqestException("Кол-во запрошенных вопросов больше общего кол-ва");
        }

        Set<Question> result = new HashSet<>();
        int count = 0;
        while (count < amount) {
            if (result.add(questionService.getRandomQuestion())) {
                count++;
            }
        }
        return result;
    }
}

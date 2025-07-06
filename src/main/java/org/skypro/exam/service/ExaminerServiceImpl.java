package org.skypro.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    Random random;
    QuestionService questionService;

    @Autowired
    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    public Set<QuestionService> getQuestion(int amount) {
        Set<QuestionService> listOfQuestion = new HashSet<>();
        if (questionService.getSize() < amount) {
            throw new ReqestException("Кол-во запрошенных вопросов больше общего кол-ва");
        }
        for (int i = 0; i < amount; i++) {
            listOfQuestion.add (questionService.getRandomQuestion());
        }
        return listOfQuestion;
    }
}

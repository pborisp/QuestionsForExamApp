package org.skypro.exam.controller;

import org.skypro.exam.service.ExaminerServiceImpl;
import org.skypro.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    @Autowired
    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get")
    public Collection<QuestionService> getQuestions(@RequestParam Integer amount) {
        return examinerService.getQuestion(amount);
    }
}

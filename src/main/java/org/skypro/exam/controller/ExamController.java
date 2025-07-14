package org.skypro.exam.controller;

import org.skypro.exam.model.Question;
import org.skypro.exam.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestion(amount);
    }

    @GetMapping("/exam/get/math/{amount}")
    public Collection<Question> getQuestionsMath(@PathVariable("amount") int amount) {
        return examinerService.getMathQuestion(amount);
    }

    @GetMapping("/exam/get/java/{amount}")
    public Collection<Question> getQuestionsJava(@PathVariable("amount") int amount) {
        return examinerService.getJavaQuestion(amount);
    }

}

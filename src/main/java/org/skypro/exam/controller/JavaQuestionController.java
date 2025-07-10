package org.skypro.exam.controller;

import org.skypro.exam.model.Question;
import org.skypro.exam.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/exam/java/add")
    public String addQuestionAnswer(@RequestParam String question,
                                    @RequestParam String answer) {
        this.questionService.addQuestionAnswer(question, answer);
        return "Вопрос успешно добавлен";
    }

    @GetMapping("/exam/java/remove")
    public String removeQuestion(@RequestParam String question,
                                 @RequestParam String answer) {
        questionService.remove(question, answer);
        return "Вопрос: " + question + " удален.";
    }

    @GetMapping("/exam/java")
    public Collection<Question> getAllQuestion() {
        return questionService.getAll();
    }
}

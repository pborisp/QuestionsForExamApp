package org.skypro.exam.controller;

import org.skypro.exam.model.Question;
import org.skypro.exam.service.JavaQuestionService;
import org.skypro.exam.service.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/exam/java/add")
    public String addQuestionAnswer(@RequestParam String question,
                                    @RequestParam String answer) {
        this.javaQuestionService.addQuestionAnswer(question, answer);
        return "Вопрос успешно добавлен";
    }

    @GetMapping("/exam/java/remove")
    public String removeQuestion(@RequestParam String question,
                                 @RequestParam String answer) {
        javaQuestionService.remove(question, answer);
        return "Вопрос: " + question + " удален.";
    }

    @GetMapping("/exam/java")
    public Collection<Question> getAllQuestion() {
        return javaQuestionService.getAll();
    }
}

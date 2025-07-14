package org.skypro.exam.controller;

import org.skypro.exam.model.Question;
import org.skypro.exam.service.JavaQuestionService;
import org.skypro.exam.service.MathQuestionSrvice;
import org.skypro.exam.service.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class MathQuestionController {

    private final MathQuestionSrvice mathQuestionSrvice;

    public MathQuestionController(MathQuestionSrvice mathQuestionSrvice) {
        this.mathQuestionSrvice = mathQuestionSrvice;
    }

    @GetMapping("/exam/math/add")
    public String addQuestionAnswer(@RequestParam String question,
                                    @RequestParam String answer) {
        this.mathQuestionSrvice.addQuestionAnswer(question, answer);
        return "Вопрос успешно добавлен";
    }

    @GetMapping("/exam/math/remove")
    public String removeQuestion(@RequestParam String question,
                                 @RequestParam String answer) {
        mathQuestionSrvice.remove(question, answer);
        return "Вопрос: " + question + " удален.";
    }

    @GetMapping("/exam/math")
    public Collection<Question> getAllQuestion() {
        return mathQuestionSrvice.getAll();
    }
}

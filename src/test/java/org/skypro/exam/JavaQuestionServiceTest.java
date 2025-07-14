package org.skypro.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.model.Question;
import org.skypro.exam.service.JavaQuestionService;
import org.skypro.exam.service.QuestionService;
import org.skypro.exam.service.ReqestException;


@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void addQuestionAnswer_whenIsNotNull_ThenOk() {
        String question = "qTest";
        String answer = "aTest";
        Question questionAnswer = new Question(question, answer);
        javaQuestionService.addQuestionAnswer(question, answer);

        Assertions.assertEquals(true, javaQuestionService.getAll().contains(questionAnswer));
    }

    @Test
    void removeQuestion_whenQuestionNotFound_ThenThrowReqestException() {
        String question = "qTest";
        String answer = "aTest";
        javaQuestionService.addQuestionAnswer(question, answer);

        Assertions.assertThrows(ReqestException.class, () -> javaQuestionService.remove("otherTest", ""));
    }

    @Test
    void removeQuestion_whenQuestinFound_ThenOk() {
        String question = "qTest";
        String answer = "aTest";
        Question questionAnswer = new Question(question, answer);
        javaQuestionService.addQuestionAnswer(question, answer);

        javaQuestionService.remove(question, answer);

        Assertions.assertEquals(false, javaQuestionService.getAll().contains(questionAnswer));
    }

    @Test
    void getRandomQuestion_whenQuestionsSizeIsNull_ThenThrowRequestException() {
        Assertions.assertThrows(ReqestException.class, () -> javaQuestionService.getRandomQuestion());
    }

    @Test
    void getRandomQuestion_whenQuestionsSizeMoreNull_ThenFindQuestion() {
        String question = "qTest";
        String answer = "aTest";
        Question questionAnswer = new Question(question, answer);
        javaQuestionService.addQuestionAnswer(question, answer);

        Assertions.assertEquals(questionAnswer, javaQuestionService.getRandomQuestion());
    }
}

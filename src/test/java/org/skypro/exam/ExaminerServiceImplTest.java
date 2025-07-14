package org.skypro.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.model.Question;
import org.skypro.exam.service.*;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();
    private final MathQuestionSrvice mathQuestionSrvice = new MathQuestionSrvice();
    private final ExaminerService examinerServiceImpl = new ExaminerServiceImpl(mathQuestionSrvice, javaQuestionService);


    @Test
    void getQuestions_whenAmountMoreQuestionsSize_ThenThrowRequestException() {
        javaQuestionService.addQuestionAnswer("1","1");
        javaQuestionService.addQuestionAnswer("2", "2");
        int amount = 3;

        Assertions.assertThrows(ReqestException.class, () -> examinerServiceImpl.getJavaQuestion(amount));
    }

    @Test
    void getQuestions_whenQuestionSizeMoreAmount_ThenOk() {
        Set<Question> questions = new HashSet<>();
        Question questionAnswer = new Question("1", "2");
        questions.add(questionAnswer);

        javaQuestionService.addQuestionAnswer("1","2");
        int amount = 1;

        Set<Question> result = new HashSet<>(examinerServiceImpl.getJavaQuestion(amount));

        Assertions.assertEquals(questions, result);
    }

}


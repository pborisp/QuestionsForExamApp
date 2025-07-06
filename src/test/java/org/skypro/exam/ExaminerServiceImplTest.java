package org.skypro.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.model.Question;
import org.skypro.exam.service.ExaminerServiceImpl;
import org.skypro.exam.service.JavaQuestionService;
import org.skypro.exam.service.QuestionService;
import org.skypro.exam.service.ReqestException;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private Question question;

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    @Test
    void givenRandomQuestion_whenGetQuestion_thenRandomQuestionTimesOk() {
        int amount = javaQuestionService.getSize();

        examinerServiceImpl.getQuestion(amount);

        Mockito.verify(javaQuestionService, Mockito.times(amount)).getRandomQuestion();
    }

    @Test
    void givenAmount_0_whenGetQuestion_thenGetNull() {
        int amount = 0;

        Set<QuestionService> questions = examinerServiceImpl.getQuestion(amount);

        Assertions.assertNotNull(questions);
    }

    @Test
    void givenAmountMoreThenQuestions_whenGetQuestion_thenThrowReqestException() {
        int amount = javaQuestionService.getSize() + 1;

        Assertions.assertThrows(ReqestException.class, () -> examinerServiceImpl.getQuestion(amount));
    }
}

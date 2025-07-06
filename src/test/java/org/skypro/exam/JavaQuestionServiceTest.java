package org.skypro.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.model.Question;
import org.skypro.exam.service.JavaQuestionService;
import org.skypro.exam.service.ReqestException;
import static org.mockito.ArgumentMatchers.any;


import java.util.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private Question question;

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @Test
    void RemoveQuestion_whenQuestionNotFound_ThenThrowReqestException() {
        String question = "qTest";
        String answer = "aTest";
        javaQuestionService.addQuestionAnswer(question, answer);

        Assertions.assertThrows(ReqestException.class, () -> javaQuestionService.remove("otherTest", ""));
    }

    @Test
    void givenQuestion_whenGetAll_ThenQuestionIsNotNull() {

        Collection<Question> result = javaQuestionService.getAll();

        Assertions.assertNotNull(result);
    }

    @Test
    void givenSizeMap_whenGetRandomQuestion_thenRandomQuestionNotNull() {
        int size = javaQuestionService.getSize();
        Question result = javaQuestionService.getRandomQuestion();

        Assertions.assertNotNull(size);
        Assertions.assertNotNull(result);
    }

}

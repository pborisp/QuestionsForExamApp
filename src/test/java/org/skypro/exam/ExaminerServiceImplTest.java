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
    private final QuestionService questionService = new JavaQuestionService();
    private final ExaminerServiceImpl examinerServiceImpl = new ExaminerServiceImpl(questionService);


    @Test
    void getQuestions_whenAmountMoreQuestionsSize_ThenThrowRequestException() {
        questionService.addQuestionAnswer("1","1");
        questionService.addQuestionAnswer("2", "2");
        int amount = 3;

        Assertions.assertThrows(ReqestException.class, () -> examinerServiceImpl.getQuestion(amount));
    }

    @Test
    void getQuestions_whenQuestionSizeMoreAmount_ThenOk() {
        Set<Question> questions = new HashSet<>();
        Question questionAnswer = new Question("1", "2");
        questions.add(questionAnswer);

        questionService.addQuestionAnswer("1","2");
        int amount = 1;

        Set<Question> result = new HashSet<>(examinerServiceImpl.getQuestion(amount));

        Assertions.assertEquals(questions, result);
    }

}


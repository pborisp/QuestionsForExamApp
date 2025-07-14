package org.skypro.exam.service;

import org.skypro.exam.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface QuestionRepository {
    void addQuestionAnswer(String question, String answer);

    String remove(String question, String answer);

    Collection<Question> getAll();
}

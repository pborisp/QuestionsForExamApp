package org.skypro.exam.service;


import org.skypro.exam.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question getRandomQuestion();

    void addQuestionAnswer(String question, String answer);

    String remove(String question, String answer);

    Collection<Question> getAll();
}

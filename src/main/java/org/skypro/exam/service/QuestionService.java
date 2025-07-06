package org.skypro.exam.service;


import org.skypro.exam.model.Question;

public interface QuestionService {
    String getTypeQuestion();

    String getTypeAnswer();

    Question getRandomQuestion();

    Integer getSize();
}

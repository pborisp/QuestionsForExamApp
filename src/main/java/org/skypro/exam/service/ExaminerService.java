package org.skypro.exam.service;

import org.skypro.exam.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);

    Collection<Question> getMathQuestion(int amount);

    Collection<Question> getJavaQuestion(int amount);
}

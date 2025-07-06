package org.skypro.exam.service;

import java.util.Set;

public interface ExaminerService {
    Set<QuestionService> getQuestion(int amount);
}

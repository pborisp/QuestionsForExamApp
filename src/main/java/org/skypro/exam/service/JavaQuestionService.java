package org.skypro.exam.service;

import org.skypro.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JavaQuestionService implements QuestionService{
    private final Map<Integer, Question> questions;

    public JavaQuestionService() {
        this.questions = new HashMap<>();
        addQuestion();
    }

    @Override
    public String getTypeQuestion() {
        return "";
    }

    @Override
    public String getTypeAnswer() {
        return "";
    }

    @Override
    public Integer getSize() {
        return questions.size();
    }

    @Override
    public Question getRandomQuestion() {
        int number = ThreadLocalRandom.current().nextInt(0, questions.size() + 1);
        List<Question> listOfQuestion = new ArrayList<>(questions.values());
        return listOfQuestion.get(number);
    }

    public void addQuestionAnswer(String question, String answer) {
        Question questionAnswer = new Question(question, answer);
        int size = questions.size();
        this.questions.put(size + 1, questionAnswer);
    }

    public String remove(String question, String answer) {
        Question questionAnswer = new Question(question, answer);
        if (questions.containsValue(questionAnswer)) {
            for (int k : questions.keySet()) {
                if (questions.get(k).equals(questionAnswer)) {
                    questions.remove(k);
                    break;
                }
            }
            return "Вопрос успешно удален";
        }
        throw new ReqestException("Невозможно удалить вопрос - отсутствует в списке");
    }

    public Collection<Question> getAll() {
        List<Question> result = new ArrayList<>();
        result.addAll(questions.values());
        return result;
    }

    public void addQuestion() {
        Question qMap = new Question("What is Map?", "This is a storage in which elements are stored in key-value");
        this.questions.put(1, qMap);
        Question qSet = new Question("What is Set?", "A Java collection structure that stores unique elements of the same type");
        this.questions.put(2, qSet);
        Question qCollection = new Question("What is Collection? ", "This is an object that stores a set of other similar objects, and also allows you to access them using its methods.");
        this.questions.put(3, qCollection);
        Question fourOnFive = new Question("How much is 4х5? ", "its 20 (twenty)");
        this.questions.put(4, fourOnFive);
        Question fiveOnSix = new Question("How much is 5х6? ", "its 30 (thirty)");
        this.questions.put(5, fiveOnSix);
        Question sixOnSeven = new Question("How much is 6х7? ", "its 42 (forty two)");
        this.questions.put(6, sixOnSeven);
        Question sevenOnEiqht = new Question("How much is 7х8? ", "its 56 (fifty six)");
        this.questions.put(7, sevenOnEiqht);
        Question eiqhtOnNine = new Question("How much is 8х9? ", "its 72 (seventy two)");
        this.questions.put(8, eiqhtOnNine);
        Question nineOnTen = new Question("How much is 9х10? ", "its 90 (ninety)");
        this.questions.put(9, nineOnTen);
        Question tenOnZero = new Question("How much is 10х0? ", "its 0 (zero)");
        this.questions.put(10, tenOnZero);
    }
}

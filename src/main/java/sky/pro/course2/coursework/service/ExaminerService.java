package sky.pro.course2.coursework.service;

import sky.pro.course2.coursework.model.Question;

import java.util.Collection;

public abstract class ExaminerService {
    public abstract Collection<Question> getQuestions(int amount);
}

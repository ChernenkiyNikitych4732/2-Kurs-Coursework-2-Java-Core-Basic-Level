package sky.pro.course2.coursework.service;

import sky.pro.course2.coursework.model.Question;

import java.util.Collection;

public abstract class QuestionService {
    public abstract Question add(String question, String answer);

    public abstract Question add(Question question);

    public abstract Question remove(String question, String answer);

    public abstract Question remove(Question question);

    public abstract Collection<Question> getAll();

    public abstract Question getRandomQuestion();
}

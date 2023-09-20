package sky.pro.course2.coursework.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.course2.coursework.exception.QuestionAlreadyExistsException;
import sky.pro.course2.coursework.exception.QuestionNotFoundException;
import sky.pro.course2.coursework.model.Question;
import sky.pro.course2.coursework.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService extends QuestionService {

    private static final Random RANDOM = new Random();
    List<Question> questions = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        return remove(new Question(question, answer));
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(RANDOM.nextInt(questions.size()));
    }
}
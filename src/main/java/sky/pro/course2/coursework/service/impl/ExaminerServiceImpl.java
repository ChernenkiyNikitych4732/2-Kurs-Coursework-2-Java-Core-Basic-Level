package sky.pro.course2.coursework.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.course2.coursework.exception.NotEnoughQuestionsException;
import sky.pro.course2.coursework.model.Question;
import sky.pro.course2.coursework.service.ExaminerService;
import sky.pro.course2.coursework.service.QuestionService;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl extends ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionsException();
        }
        return Stream.generate(questionService::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }
}
package skypro.homework.coursework_3_question_generator.services;

import org.springframework.stereotype.Service;
import skypro.homework.coursework_3_question_generator.exceptions.UnSufficentQuestionsExceptions;
import skypro.homework.coursework_3_question_generator.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new UnSufficentQuestionsExceptions();
        }
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}


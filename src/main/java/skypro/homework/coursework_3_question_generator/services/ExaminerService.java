package skypro.homework.coursework_3_question_generator.services;

import org.springframework.stereotype.Service;
import skypro.homework.coursework_3_question_generator.model.Question;

import java.util.Collection;

@Service
public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}

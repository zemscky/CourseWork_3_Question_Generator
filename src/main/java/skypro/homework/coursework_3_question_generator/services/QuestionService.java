package skypro.homework.coursework_3_question_generator.services;

import skypro.homework.coursework_3_question_generator.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}

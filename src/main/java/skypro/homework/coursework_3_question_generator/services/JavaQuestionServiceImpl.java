package skypro.homework.coursework_3_question_generator.services;

import org.springframework.stereotype.Service;
import skypro.homework.coursework_3_question_generator.model.Question;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final static Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question questionObject = new Question(question, answer);
        this.questions.add(questionObject);
        return questionObject;
    }

    @Override
    public Question add(Question question) {
        this.questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        return this.questions.stream().skip(random.nextInt(0, this.questions.size())).findFirst().orElseThrow();
    }

}

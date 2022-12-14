package skypro.homework.coursework_3_question_generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro.homework.coursework_3_question_generator.model.Question;
import skypro.homework.coursework_3_question_generator.services.JavaQuestionServiceImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaQuestionServiceTest {

    private JavaQuestionServiceImpl javaQuestionService = new JavaQuestionServiceImpl();
    private List<Question> questions = List.of(
            new Question("q1","a1"),
            new Question("q2","a2"),
            new Question("q3","a3"),
            new Question("q4","a4"),
            new Question("q5","a5")
    );
    @BeforeEach
    void setUp() {
        this.javaQuestionService = new JavaQuestionServiceImpl();
       questions.forEach(javaQuestionService::add);
    }

    @Test
    void addQuestionTest() {
       Question question = new Question("q6", "a6");
       Question actual = this.javaQuestionService.add(question);
       assertThat(actual).isEqualTo(question);
       assertThat(this.javaQuestionService.getAll())
               .hasSize(6)
               .contains(question);
    }

    @Test
    void removeQuestionsTest() {
        Question expected = this.questions.get(0);
        Question actual = this.javaQuestionService.remove(expected);
        assertThat(actual).isEqualTo(expected);
        assertThat(this.javaQuestionService.getAll())
                .hasSize(4)
                .doesNotContain(expected);
    }

    @Test
    void getAllTest() {
        assertThat(this.javaQuestionService.getAll())
                .hasSize(5)
                .containsAll(this.questions);
    }

    @Test
    void getRandomQuestions() {
        Question actual = this.javaQuestionService.getRandomQuestion();
        assertThat(actual).isIn(questions);
    }

    @Test
    void whenListIsEmptyThenGetRandomQuestionReturnsExceptions() {

    }

}

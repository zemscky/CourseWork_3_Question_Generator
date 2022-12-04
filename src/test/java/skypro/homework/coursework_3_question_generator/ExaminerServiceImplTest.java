package skypro.homework.coursework_3_question_generator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.homework.coursework_3_question_generator.exceptions.UnSufficentQuestionsExceptions;
import skypro.homework.coursework_3_question_generator.model.Question;
import skypro.homework.coursework_3_question_generator.services.ExaminerServiceImpl;
import skypro.homework.coursework_3_question_generator.services.QuestionService;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void whenAmountOfQuestionsIsSufficientThenGetQuestionReturnExactAmount() {
        List<Question> questionList = List.of(
                new Question("q1","a1"),
                new Question("q2","a2"),
                new Question("q3","a3")
        );
        when(questionService.getAll()).thenReturn(questionList);
        when(questionService.getRandomQuestion())
                .thenReturn(
                        questionList.get(0),
                        questionList.get(1)
                );

        assertThat(examinerService.getQuestions(2))
                .hasSize(2)
                .contains(questionList.get(0),questionList.get(1));
    }

    @Test
    void whenAmountOfQuestionsIsInSufficientThenMethodThrowsExceptions(){
        when(questionService.getAll()).thenReturn(Collections.emptyList());
        assertThatThrownBy(() -> examinerService.getQuestions(100))
                .isInstanceOf(UnSufficentQuestionsExceptions.class);
    }

}


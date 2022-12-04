package skypro.homework.coursework_3_question_generator.controllers;

import org.springframework.web.bind.annotation.*;
import skypro.homework.coursework_3_question_generator.model.Question;
import skypro.homework.coursework_3_question_generator.services.JavaQuestionServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionServiceImpl javaQuestionService;

    public JavaQuestionController(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @PutMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return this.javaQuestionService.add(question, answer);
    }

    @DeleteMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        Question q = new Question(question, answer);
        return this.javaQuestionService.remove(q);
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return this.javaQuestionService.getAll();
    }
}

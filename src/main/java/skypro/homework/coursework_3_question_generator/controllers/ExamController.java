package skypro.homework.coursework_3_question_generator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skypro.homework.coursework_3_question_generator.exceptions.UnSufficentQuestionsExceptions;
import skypro.homework.coursework_3_question_generator.model.Question;
import skypro.homework.coursework_3_question_generator.services.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    @ExceptionHandler(UnSufficentQuestionsExceptions.class)
    public ResponseEntity<String> handlerException() {
        return ResponseEntity.badRequest().body("Недостаточно вопросов");
    }

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return this.examinerService.getQuestions(amount);
    }
}

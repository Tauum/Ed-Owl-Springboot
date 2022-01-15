package edowl.Controller;

import edowl.Model.Quiz;
import edowl.Service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Quiz")
@CrossOrigin
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizs()
    {
        List<Quiz> quizs = quizService.findAll();
        return new ResponseEntity<>(quizs, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("id") Long id)
    {
        Quiz quiz = quizService.findQuizById(id);
        return new ResponseEntity<>(quiz, HttpStatus.OK); //ok is 200 status code
    }
    @GetMapping("/newestOrder")
    public ResponseEntity<List<Quiz>> getAllOrderedByDateQuizs()
    {
        List<Quiz> quizs = quizService.findAllOrderByGeneratedDateDesc();
        return new ResponseEntity<>(quizs, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/latest")
    public ResponseEntity<Quiz> getLatestQuiz()
    {
        Quiz quiz = quizService.findQuizOrderByGeneratedDateDesc();
        return new ResponseEntity<>(quiz, HttpStatus.OK); //ok is 200 status code
    }

    @PostMapping("/getQuizWithID")
    public ResponseEntity<Quiz> getQuizWithID(@RequestBody Quiz quiz)
    {
        Quiz attempt = quizService.findQuizById(quiz.getId());
        return new ResponseEntity<>(attempt, HttpStatus.OK); //ok is 200 status code
    }

    @PostMapping("/add")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
    {
        Quiz newQuiz = quizService.addQuiz(quiz);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED); //ok is 200 status code
    }

    // "A collection with cascade=\"all-delete-orphan\" was no longer referenced by the owning entity instance: uk.ac.bolton.backend.Model.Quiz.questions
    @PutMapping("/update/{id}") // this doesnt work
    public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") Long id, @RequestBody Quiz quiz)
    {
        Quiz attempt = quizService.findQuizById(id);
        if (attempt != null){
            attempt.setTitle(quiz.title);
            attempt.setTimeLimit(quiz.timeLimit);
            attempt.setValue(quiz.value);

            attempt.questions.clear();

            attempt.setQuestions(quiz.questions);

            Quiz updatedQuiz = quizService.updateQuiz(attempt);
            // potentially do this? V delete questions and answers and rewrite them
            // quizService.delete
            return new ResponseEntity<>(updatedQuiz, HttpStatus.OK);  //ok is 200 status code
        }
        return new ResponseEntity<>(attempt, HttpStatus.BAD_REQUEST);

//        Quiz updateQuiz = quizService.updateQuiz(quiz);
//        return new ResponseEntity<>(updateQuiz, HttpStatus.OK);  //ok is 200 status code
    }

    @DeleteMapping("/delete/{id}") // THIS DOESNT DELETE QUESTIONS OR ANSWERS
    public ResponseEntity<?> deleteQuiz(@PathVariable("id") Long id)
    {
        quizService.findQuizById(id);
        quizService.deleteQuiz(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
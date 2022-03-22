package edowl.Controller;

import edowl.Model.Hangman;
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

    @GetMapping("/newestOrder-hideHidden")
    public ResponseEntity<List<Quiz>> getAllQuizOrderedByDateAndHideHidden()
    {
        List<Quiz> quizs = quizService.findAllOrderByGeneratedDateDescAndNotHidden();
        return new ResponseEntity<>(quizs, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/latest")
    public ResponseEntity<Quiz> getLatestQuizAndHideHidden()
    {
        Quiz quiz = quizService.findQuizOrderByGeneratedDateDescNotHidden();
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

    @GetMapping("/title/{title}")
    public ResponseEntity<Quiz> getQuizByTitle(@PathVariable("title")  String title)
    {
        Quiz quiz = quizService.findQuizByTitle(title);
        return new ResponseEntity<>(quiz, HttpStatus.OK); //ok is 200 status code
    }

    // "A collection with cascade=\"all-delete-orphan\" was no longer referenced by the owning entity instance: uk.ac.bolton.backend.Model.Quiz.questions
    @PutMapping("/update/{id}") // this doesnt work
    public ResponseEntity<String> updateQuiz(@PathVariable("id") Long id, @RequestBody Quiz quiz) {
        Quiz attempt = quizService.updateQuiz(id, quiz);
        if (attempt != null) {
            return new ResponseEntity<>("good", HttpStatus.OK);  //ok is 200 status code
        }
        return new ResponseEntity<>("bad", HttpStatus.BAD_REQUEST);
    }



    @DeleteMapping("/delete/{id}") // THIS DOESNT DELETE QUESTIONS OR ANSWERS
    public ResponseEntity<?> deleteQuiz(@PathVariable("id") Long id)
    {
        quizService.findQuizById(id);
        quizService.deleteQuiz(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
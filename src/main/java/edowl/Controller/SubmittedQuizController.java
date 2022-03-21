package edowl.Controller;

import edowl.Model.Statistic;
import edowl.Model.SubmittedQuiz;
import edowl.Service.SubmittedQuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/SubmittedQuiz")
@CrossOrigin
public class SubmittedQuizController {
    private final SubmittedQuizService submittedQuizService;

    public SubmittedQuizController(SubmittedQuizService submittedQuizService) {
        this.submittedQuizService = submittedQuizService;
    }

    @GetMapping
    public ResponseEntity<List<SubmittedQuiz>> getAllSubmittedQuizs()
    {
        List<SubmittedQuiz> quizSubmitteds = submittedQuizService.findAll();
        return new ResponseEntity<>(quizSubmitteds, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubmittedQuiz> getSubmittedQuiz(@PathVariable("id") Long id)
    {
        SubmittedQuiz quizSubmitted = submittedQuizService.findSubmittedQuizById(id);
        return new ResponseEntity<>(quizSubmitted, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/getForUser/{id}")
    public ResponseEntity<List<SubmittedQuiz>> getSubmittedQuizForUser(@PathVariable("id") Long id){
        List<SubmittedQuiz> quizzes = submittedQuizService.findAllByUserId(id);
        return new ResponseEntity<>(quizzes, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/getForQuiz/{title}")
    public ResponseEntity<List<SubmittedQuiz>> getSubmittedQuizForUser(@PathVariable("title") String title){
        List<SubmittedQuiz> quizzes = submittedQuizService.findAllByQuizTitle(title);
        return new ResponseEntity<>(quizzes, HttpStatus.OK); //ok is 200 status code
    }

    public Statistic getSubmittedQuizStatsForUser(@PathVariable("id") Long id){
        List<SubmittedQuiz> quizzes = submittedQuizService.findAllByUserId(id);
        List<Double>  score = new ArrayList<Double>();
        List<Double>  timeTaken = new ArrayList<Double>();
        List<Double>  origVal = new ArrayList<Double>();

        quizzes.forEach((quiz) -> score.add((double) quiz.getQuizValue()));

        quizzes.forEach((quiz) -> {
                    score.add((double) quiz.getScore());
                            timeTaken.add((double) quiz.getTimeTaken());
                            origVal.add((double) quiz.getQuizValue());
                });

        Statistic statistic = new Statistic();
        statistic.setTask("Quizzes");
        statistic.setAmount(quizzes.size());
        statistic.setOrigValue(statistic.generateAvg(origVal));
        statistic.setAvgTime(statistic.generateAvg(timeTaken));

        return statistic; //ok is 200 status code
    }

    @GetMapping("/getSQStatsForUser/{id}")
    public ResponseEntity<Statistic> getSQStatsForUser(@PathVariable("id") Long id){
        List<SubmittedQuiz> quizzes = submittedQuizService.findAllByUserId(id);
        Statistic statistic = new Statistic();
        List<Double>  score = new ArrayList<Double>();
        List<Double>  timeTaken = new ArrayList<Double>();
        List<Double>  origVal = new ArrayList<Double>();

        quizzes.forEach((quiz) -> {
            score.add((double) quiz.getScore());
            timeTaken.add((double) quiz.getTimeTaken());
            origVal.add((double) quiz.getQuizValue());
        });

        statistic.setTask("Quiz");
        statistic.setAmount(quizzes.size());
        statistic.setOrigValue(statistic.generateAvg(origVal));
        statistic.setAvgTime(statistic.generateAvg(timeTaken));
        statistic.setAvgScore(statistic.generateAvg(score));

        return new ResponseEntity<>(statistic, HttpStatus.OK);  //ok is 200 status code
    }


    @PostMapping("/add")
    public ResponseEntity<SubmittedQuiz> addSubmittedQuiz(@RequestBody SubmittedQuiz quizSubmitted)
    {
        SubmittedQuiz newSubmittedQuiz = submittedQuizService.addSubmittedQuiz(quizSubmitted);
        return new ResponseEntity<>(newSubmittedQuiz, HttpStatus.CREATED); //ok is 200 status code
    }

    @PutMapping("/update")
    public ResponseEntity<SubmittedQuiz> updateSubmittedQuiz(@RequestBody SubmittedQuiz quizSubmitted)
    {
        SubmittedQuiz updateSubmittedQuiz = submittedQuizService.updateSubmittedQuiz(quizSubmitted);
        return new ResponseEntity<>(updateSubmittedQuiz, HttpStatus.OK);  //ok is 200 status code
    }
    @PatchMapping("/vote/{id}/{Rating}")
    public ResponseEntity<Boolean> updateSubmittedQuiz(@PathVariable("Rating") Boolean Rating, @PathVariable("id") Long Id)
    {
        Boolean out = false;
        if (submittedQuizService.patchRating(Rating, Id)){
            out = true;
        }
        return new ResponseEntity<>(out, HttpStatus.OK);  //ok is 200 status code
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubmittedQuiz(@PathVariable("id") Long id)
    {
        submittedQuizService.deleteSubmittedQuiz(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package edowl.Controller;


import edowl.Model.Statistic;
import edowl.Model.SubmittedHangman;
import edowl.Model.SubmittedHangman;
import edowl.Service.SubmittedHangmanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/SubmittedHangman")
@CrossOrigin
public class SubmittedHangmanController {
    private final SubmittedHangmanService submittedHangmanService;

    public SubmittedHangmanController(SubmittedHangmanService submittedHangmanService) {
        this.submittedHangmanService = submittedHangmanService;
    }

    @GetMapping
    public ResponseEntity<List<SubmittedHangman>> getAllSubmittedHangmans()
    {
        List<SubmittedHangman> submittedHangmans = submittedHangmanService.findAll();
        return new ResponseEntity<>(submittedHangmans, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubmittedHangman> getSubmittedHangman(@PathVariable("id") Long id)
    {
        SubmittedHangman submittedHangman = submittedHangmanService.findSubmittedHangmanById(id);
        return new ResponseEntity<>(submittedHangman, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/getForUser/{id}")
    public ResponseEntity<List<SubmittedHangman>> getSubmittedHangmanForUser(@PathVariable("id") Long id){
        List<SubmittedHangman> submittedHangmans = submittedHangmanService.findAllByUserId(id);
        return new ResponseEntity<>(submittedHangmans, HttpStatus.OK); //ok is 200 status code
    }

    public Statistic getSubmittedHangmanStatsForUser(@PathVariable("id") Long id){
        List<SubmittedHangman> hangmans = submittedHangmanService.findAllByUserId(id);
        List<Double>  score = new ArrayList<Double>();
        List<Double>  timeTaken = new ArrayList<Double>();
        List<Double>  origVal = new ArrayList<Double>();

        hangmans.forEach((hangman) -> score.add((double) hangman.getHangmanValue()));

        hangmans.forEach((hangman) -> {
            score.add((double) hangman.getScore());
            timeTaken.add((double) hangman.getTimeTaken());
            origVal.add((double) hangman.getHangmanValue());
        });

        Statistic statistic = new Statistic();
        statistic.setTask("Hangmen");
        statistic.setAmount(hangmans.size());
        statistic.setOrigValue(statistic.generateAvg(origVal));
        statistic.setAvgTime(statistic.generateAvg(timeTaken));

        return statistic; //ok is 200 status code
    }

    @GetMapping("/getSHStatsForUser/{id}")
    public ResponseEntity<Statistic> getSHStatsForUser(@PathVariable("id") Long id){
        List<SubmittedHangman> hangmen = submittedHangmanService.findAllByUserId(id);
        Statistic statistic = new Statistic();
        List<Double>  score = new ArrayList<Double>();
        List<Double>  timeTaken = new ArrayList<Double>();
        List<Double>  origVal = new ArrayList<Double>();

        hangmen.forEach((hangman) -> {
            score.add((double) hangman.getScore());
            timeTaken.add((double) hangman.getTimeTaken());
            origVal.add((double) hangman.getHangmanValue());
        });

        statistic.setTask("Hangman");
        statistic.setAmount(hangmen.size());
        statistic.setOrigValue(statistic.generateAvg(origVal));
        statistic.setAvgTime(statistic.generateAvg(timeTaken));
        statistic.setAvgScore(statistic.generateAvg(score));

        return new ResponseEntity<>(statistic, HttpStatus.OK);  //ok is 200 status code
    }



    @PostMapping("/add")
    public ResponseEntity<SubmittedHangman> addSubmittedHangman(@RequestBody SubmittedHangman submittedHangman)
    {
        SubmittedHangman newSubmittedHangman = submittedHangmanService.addSubmittedHangman(submittedHangman);
        return new ResponseEntity<>(submittedHangman, HttpStatus.CREATED); //ok is 200 status code
    }

    @PutMapping("/update")
    public ResponseEntity<SubmittedHangman> updateSubmittedHangman(@RequestBody SubmittedHangman submittedHangman)
    {
        SubmittedHangman updateSubmittedHangman = submittedHangmanService.updateSubmittedHangman(submittedHangman);
        return new ResponseEntity<>(updateSubmittedHangman, HttpStatus.OK);  //ok is 200 status code
    }

    @PatchMapping("/vote/{id}/{Rating}")
    public ResponseEntity<Boolean> updateSubmittedHangmen(@PathVariable("Rating") Boolean Rating, @PathVariable("id") Long Id)
    {
        Boolean out = false;
        if (submittedHangmanService.patchRating(Rating, Id)){
            out = true;
        }
        return new ResponseEntity<>(out, HttpStatus.OK);  //ok is 200 status code
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubmittedHangman(@PathVariable("id") Long id)
    {
        submittedHangmanService.deleteSubmittedHangman(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


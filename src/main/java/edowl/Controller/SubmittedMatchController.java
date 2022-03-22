package edowl.Controller;


import edowl.Model.Statistic;
import edowl.Model.SubmittedMatch;
import edowl.Model.SubmittedMatch;
import edowl.Service.SubmittedMatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/SubmittedMatch")
@CrossOrigin
public class SubmittedMatchController {
    private final SubmittedMatchService submittedMatchService;

    public SubmittedMatchController(SubmittedMatchService submittedMatchService) {
        this.submittedMatchService = submittedMatchService;
    }

    @GetMapping
    public ResponseEntity<List<SubmittedMatch>> getAllSubmittedMatches()
    {
        List<SubmittedMatch> matchSubmitteds = submittedMatchService.findAll();
        return new ResponseEntity<>(matchSubmitteds, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubmittedMatch> getSubmittedMatch(@PathVariable("id") Long id)
    {
        SubmittedMatch matchSubmitted = submittedMatchService.findSubmittedMatchById(id);
        return new ResponseEntity<>(matchSubmitted, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/getForUser/{id}")
    public ResponseEntity<List<SubmittedMatch>> getSubmittedMatchForUser(@PathVariable("id") Long id){
        List<SubmittedMatch> matchzes = submittedMatchService.findAllByUserId(id);
        return new ResponseEntity<>(matchzes, HttpStatus.OK); //ok is 200 status code
    }

    public Statistic getSubmittedMatchStatsForUser(@PathVariable("id") Long id){
        List<SubmittedMatch> matches = submittedMatchService.findAllByUserId(id);
        List<Double>  score = new ArrayList<Double>();
        List<Double>  timeTaken = new ArrayList<Double>();
        List<Double>  origVal = new ArrayList<Double>();

//        matches.forEach((match) -> score.add((double) match.getMatchValue()));

        matches.forEach((match) -> {
            score.add((double) match.getScore());
            timeTaken.add((double) match.getTimeTaken());
            origVal.add((double) match.getMatchValue());
        });

        Statistic statistic = new Statistic();
        statistic.setTask("Match");
        statistic.setAmount(matches.size());
        statistic.setOrigValue(statistic.generateAvg(origVal));
        statistic.setAvgTime(statistic.generateAvg(timeTaken));

        return statistic; //ok is 200 status code
    }

    @GetMapping("/getSMStatsForUser/{id}")
    public ResponseEntity<Statistic> getSMStatsForUser(@PathVariable("id") Long id){
        List<SubmittedMatch> Matches = submittedMatchService.findAllByUserId(id);
        Statistic statistic = new Statistic();
        List<Double>  score = new ArrayList<Double>();
        List<Double>  timeTaken = new ArrayList<Double>();
        List<Double>  origVal = new ArrayList<Double>();

//        Matches.forEach((Match) -> score.add((double) Match.getMatchValue()));
        Matches.forEach((Match) -> {
            score.add((double) Match.getScore());
            timeTaken.add((double) Match.getTimeTaken());
            origVal.add((double) Match.getMatchValue());
        });

        statistic.setTask("Matches");
        statistic.setAmount(Matches.size());
        statistic.setOrigValue(statistic.generateAvg(origVal));
        statistic.setAvgTime(statistic.generateAvg(timeTaken));
        statistic.setAvgScore(statistic.generateAvg(score));

        return new ResponseEntity<>(statistic, HttpStatus.OK);  //ok is 200 status code
    }


    @PostMapping("/add")
    public ResponseEntity<SubmittedMatch> addSubmittedMatch(@RequestBody SubmittedMatch matchSubmitted)
    {
        SubmittedMatch newSubmittedMatch = submittedMatchService.addSubmittedMatch(matchSubmitted);
        return new ResponseEntity<>(newSubmittedMatch, HttpStatus.CREATED); //ok is 200 status code
    }

    @PutMapping("/update")
    public ResponseEntity<SubmittedMatch> updateSubmittedMatch(@RequestBody SubmittedMatch matchSubmitted)
    {
        // redo save function here
        SubmittedMatch updateSubmittedMatch = submittedMatchService.updateSubmittedMatch(matchSubmitted);
        return new ResponseEntity<>(updateSubmittedMatch, HttpStatus.OK);  //ok is 200 status code
    }
    @PatchMapping("/vote/{id}/{Rating}")
    public ResponseEntity<Boolean> updateSubmittedMatch(@PathVariable("Rating") Boolean Rating, @PathVariable("id") Long Id)
    {
        Boolean out = false;
        if (submittedMatchService.patchRating(Rating, Id)){
            out = true;
        }
        return new ResponseEntity<>(out, HttpStatus.OK);  //ok is 200 status code
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubmittedMatch(@PathVariable("id") Long id)
    {
        submittedMatchService.deleteSubmittedMatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

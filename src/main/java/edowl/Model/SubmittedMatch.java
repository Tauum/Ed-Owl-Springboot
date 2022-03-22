package edowl.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Submitted_Match")
public class SubmittedMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;

    public String matchTitle;
    public float matchValue;
    public String matchContent;
    public Long matchId;
    private int incorrect;
    private int correct;
    private LocalDate generatedDate;
    private int timeTaken;
    private float score;
    public boolean rating;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "submitted_match_user",
            joinColumns = { @JoinColumn(name = "submitted_match_id")},
            inverseJoinColumns = { @JoinColumn(name = "user_id")})
    public User user;

    public SubmittedMatch() { }

    public SubmittedMatch(String matchTitle, float matchValue, String matchContent, Long matchId, int incorrect, int correct, LocalDate generatedDate, int timeTaken, float score, boolean rating, User user) {
        this.matchTitle = matchTitle;
        this.matchValue = matchValue;
        this.matchContent = matchContent;
        this.matchId = matchId;
        this.incorrect = incorrect;
        this.correct = correct;
        this.generatedDate = generatedDate;
        this.timeTaken = timeTaken;
        this.score = score;
        this.rating = rating;
        this.user = user;
    }

    public String getMatchContent() {
        return matchContent;
    }

    public void setMatchContent(String matchContent) {
        this.matchContent = matchContent;
    }

    public boolean isRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }

    public String getMatchTitle() {
        return matchTitle;
    }

    public void setMatchTitle(String matchTitle) {
        this.matchTitle = matchTitle;
    }

    public float getMatchValue() {
        return matchValue;
    }

    public void setMatchValue(float matchValue) {
        this.matchValue = matchValue;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }

    public float getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package edowl.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity //needed for database mapping
@Table(name = "Submitted_Hangman")
public class SubmittedHangman {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private int incorrect;
    private boolean hintUsed;
    private boolean completed;
    private LocalDate generatedDate;
    private int timeTaken;
    private float score;
    private float hangmanValue;
    public String hangmanTitle;
    public Long hangmanId;
    public boolean rating;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "submitted_hangman_user",
            joinColumns = { @JoinColumn(name = "submitted_hangman_id")},
            inverseJoinColumns = { @JoinColumn(name = "user_id")})
    public User user; // on submit it inserts this value instead of referencing

    public SubmittedHangman() {
    }

    public SubmittedHangman(int incorrect, boolean hintUsed, boolean completed, LocalDate generatedDate, int timeTaken, float score, float hangmanValue, String hangmanTitle, Long hangmanId, boolean rating, String hangmanContent, User user) {
        this.incorrect = incorrect;
        this.hintUsed = hintUsed;
        this.completed = completed;
        this.generatedDate = generatedDate;
        this.timeTaken = timeTaken;
        this.score = score;
        this.hangmanValue = hangmanValue;
        this.hangmanTitle = hangmanTitle;
        this.hangmanId = hangmanId;
        this.rating = rating;
        this.user = user;
    }

    public Long getHangmanId() {
        return hangmanId;
    }

    public void setHangmanId(Long hangmanId) {
        this.hangmanId = hangmanId;
    }

    public boolean isRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }

    public String getHangmanTitle() {
        return hangmanTitle;
    }

    public void setHangmanTitle(String hangmanTitle) {
        this.hangmanTitle = hangmanTitle;
    }

    public float getHangmanValue() {
        return hangmanValue;
    }

    public void setHangmanValue(float hangmanValue) {
        this.hangmanValue = hangmanValue;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
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

    public boolean isHintUsed() {
        return hintUsed;
    }

    public void setHintUsed(boolean hintUsed) {
        this.hintUsed = hintUsed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}


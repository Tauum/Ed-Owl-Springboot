package edowl.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity //needed for database mapping
@Table(name = "SubmittedHangman")
public class SubmittedHangman {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) private Long id;
    private int incorrect;
    private boolean hintUsed;
    private boolean completed;
    private LocalDate generatedDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "hangman_submitted_hangman",
            joinColumns = { @JoinColumn(name = "submitted_hangman_id")},
            inverseJoinColumns = { @JoinColumn(name = "hangman_id")})
    public Hangman hangman; // on submit it inserts this value instead of referencing

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_submitted_hangman",
            joinColumns = { @JoinColumn(name = "submitted_hangman_id")},
            inverseJoinColumns = { @JoinColumn(name = "user_id")})
    public User user; // on submit it inserts this value instead of referencing

    public SubmittedHangman() {
    }

    public SubmittedHangman(int incorrect, boolean hintUsed, boolean completed, LocalDate generatedDate, Hangman hangman, User user) {
        this.incorrect = incorrect;
        this.hintUsed = hintUsed;
        this.completed = completed;
        this.generatedDate = generatedDate;
        this.hangman = hangman;
        this.user = user;
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

    public Hangman getHangman() {
        return hangman;
    }

    public void setHangman(Hangman hangman) {
        this.hangman = hangman;
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
}


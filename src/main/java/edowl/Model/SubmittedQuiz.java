package edowl.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity //needed for database mapping
@Table(name = "Submitted_Quiz")
public class SubmittedQuiz {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "Submitted_Quiz_User",
            joinColumns = { @JoinColumn(name = "quiz_submitted_id")},
            inverseJoinColumns = { @JoinColumn(name = "user_id")})
    public User user;

    private String quizTitle;
    private int quizValue;
    private int quizTimeLimit;
    public Long quizId;

    private float score;
    private LocalDate generatedDate;
    private int timeTaken;
    private boolean rating;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Submitted_quiz_question",
            joinColumns = { @JoinColumn(name = "quiz_id")},
            inverseJoinColumns = { @JoinColumn(name = "submitted_question_id")})
    @Column(name = "submitted_questions")
    private Set<SubmittedQuestion> submittedQuestions = new HashSet<>();

    public SubmittedQuiz() {
    }

    public SubmittedQuiz(User user, String quizTitle, int quizValue, int quizTimeLimit, Long quizId, float score, LocalDate generatedDate, int timeTaken, Set<SubmittedQuestion> submittedQuestions) {
        this.user = user;
        this.quizTitle = quizTitle;
        this.quizValue = quizValue;
        this.quizTimeLimit = quizTimeLimit;
        this.quizId = quizId;
        this.score = score;
        this.generatedDate = generatedDate;
        this.timeTaken = timeTaken;
        this.submittedQuestions = submittedQuestions;
    }

    public boolean isRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }

    public int getQuizTimeLimit() {
        return quizTimeLimit;
    }

    public void setQuizTimeLimit(int quizTimeLimit) {
        this.quizTimeLimit = quizTimeLimit;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public int getQuizValue() {
        return quizValue;
    }

    public void setQuizValue(int quizValue) {
        this.quizValue = quizValue;
    }

    public int getTimeLimit() {
        return quizTimeLimit;
    }

    public void setTimeLimit(int quizTimeLimit) {
        this.quizTimeLimit = quizTimeLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<SubmittedQuestion> getSubmittedQuestions() {
        return submittedQuestions;
    }

    public void setSubmittedQuestions(Set<SubmittedQuestion> submittedQuestions) {
        this.submittedQuestions = submittedQuestions;
    }
}



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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "Submitted_Quiz_Quiz",
            joinColumns = { @JoinColumn(name = "quiz_submitted_id")},
            inverseJoinColumns = { @JoinColumn(name = "quiz_id")})
    public Quiz quiz;

    private float score;
    private LocalDate generatedDate;
    private float timeTaken;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Submitted_quiz_question",
            joinColumns = { @JoinColumn(name = "quiz_submitted_id")},
            inverseJoinColumns = { @JoinColumn(name = "question_id")})
    @Column(name = "submitted_questions")
    private Set<SubmittedQuestion> submittedQuestions = new HashSet<>();

    public SubmittedQuiz() {
    }

    public SubmittedQuiz(User user, Quiz quiz, float score, LocalDate generatedDate, float timeTaken, Set<SubmittedQuestion> submittedQuestions) {
        this.user = user;
        this.quiz = quiz;
        this.score = score;
        this.generatedDate = generatedDate;
        this.timeTaken = timeTaken;
        this.submittedQuestions = submittedQuestions;
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

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
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

    public void setTimeTaken(float timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Set<SubmittedQuestion> getSubmittedQuestions() {
        return submittedQuestions;
    }

    public void setSubmittedQuestions(Set<SubmittedQuestion> submittedQuestions) {
        this.submittedQuestions = submittedQuestions;
    }
}



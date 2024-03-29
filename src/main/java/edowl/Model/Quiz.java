package edowl.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    @OneToMany(fetch =  FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "quiz_questions",
            joinColumns = { @JoinColumn(name = "quiz_id")},
            inverseJoinColumns = { @JoinColumn(name = "question_id")})
    @Column(name = "questions")
    public Set<Question> questions;
    private LocalDate generatedDate;
    public int timeLimit;
    public float value;
    public boolean hidden;
    public String subject;
    public String content;

    public Quiz(){}

    public Quiz(String title, Set<Question> questions, LocalDate generatedDate, int timeLimit, float value, boolean hidden, String subject, String content) {
        this.title = title;
        this.questions = questions;
        this.generatedDate = generatedDate;
        this.timeLimit = timeLimit;
        this.value = value;
        this.hidden = hidden;
        this.subject = subject;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setGeneral(String title, int timeLimit, float value, boolean hidden, String subject, String content){
        this.title = title;
        this.timeLimit =timeLimit;
        this.value =value;
        this.hidden = hidden;
        this.subject =subject;
        this.content = content;
    }

}


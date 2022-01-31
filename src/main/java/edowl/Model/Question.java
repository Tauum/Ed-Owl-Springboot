package edowl.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Long id;
    public String question;
    public String explaination;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "question_answers",
            joinColumns = { @JoinColumn(name = "question_id")},
            inverseJoinColumns = { @JoinColumn(name = "answer_id")})
    @Column(name = "answers")
    public Set<Answer> answers;
    public float value;

    public Question() { }

    public Question(String question, String explaination, Set<Answer> answers, float value, Quiz quiz) {
        this.question = question;
        this.explaination = explaination;
        this.answers = answers;
        this.value = value;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setGeneral(String question, String explaination, float value){
        this.value = value;
        this.question = question;
        this.explaination = explaination;
    }
}

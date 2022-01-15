package edowl.Model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hangman")
public class Hangman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public String word;
    public String hint;
    public float value;
    public String subject;
    private LocalDate generatedDate;

    public Hangman() {
    }

    public Hangman(String title, String word, String hint, float value, String subject, LocalDate generatedDate) {
        this.title = title;
        this.word = word;
        this.hint = hint;
        this.value = value;
        this.subject = subject;
        this.generatedDate = generatedDate;
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }
}




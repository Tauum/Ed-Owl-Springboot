package edowl.Model;


import javax.persistence.*;

@Entity
@Table(name = "Submitted_Question")
public class SubmittedQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String answer;
    private String explaination;
    private boolean correct;
    private float score;
    private float timeTaken;
    private boolean copied;

    public SubmittedQuestion() {
    }

    public SubmittedQuestion(String question, String answer, String explaination, boolean correct, float score, float timeTaken, boolean coppied) {
        this.question = question;
        this.answer = answer;
        this.explaination = explaination;
        this.correct = correct;
        this.score = score;
        this.timeTaken = timeTaken;
        this.copied = copied;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getTime_taken() {
        return timeTaken;
    }

    public void setTime_taken(float timeTaken) {
        this.timeTaken = timeTaken;
    }

    public boolean isCopied() {
        return copied;
    }

    public void setCopied(boolean copied) {
        this.copied = copied;
    }
}

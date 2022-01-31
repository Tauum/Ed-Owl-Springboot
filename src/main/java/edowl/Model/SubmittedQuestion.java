package edowl.Model;

import javax.persistence.*;

@Entity
@Table(name = "Submitted_Question")
public class SubmittedQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long questionId;
    private String question;
    private Long answerId;
    private String answer;
    private String explaination;
    private boolean correct;
    private float score;
    private boolean coppied;
    private int questionValue;

    public SubmittedQuestion() {
    }

    public SubmittedQuestion(Long questionId, String question, Long answerId, String answer, String explaination, boolean correct, float score, boolean coppied, int questionValue) {
        this.questionId = questionId;
        this.question = question;
        this.answerId = answerId;
        this.answer = answer;
        this.explaination = explaination;
        this.correct = correct;
        this.score = score;
        this.coppied = coppied;
        this.questionValue = questionValue;
    }

    public int getQuestionValue() {
        return questionValue;
    }

    public void setQuestionValue(int questionValue) {
        this.questionValue = questionValue;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public boolean isCoppied() {
        return coppied;
    }

    public void setCoppied(boolean coppied) {
        this.coppied = coppied;
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

    public boolean isCopied() {
        return coppied;
    }

    public void setCopied(boolean coppied) {
        this.coppied = coppied;
    }
}

package edowl.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity //needed for database mapping
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long userId;
    public String userEmail;
    private String content;

    public Note() {
    }

    public Note(Long userId, String userEmail, String content) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
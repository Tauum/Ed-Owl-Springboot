package edowl.Model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity //needed for database mapping
@Table(name = "announcement")
public class Announcement {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Long id;
    public String content;
    public String redirect;
    public LocalDate generatedDate;

    public Announcement() {  }

    public Announcement(String content, String redirect, LocalDate generatedDate) {
        this.content = content;
        this.redirect = redirect;
        this.generatedDate = generatedDate;
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

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }
}


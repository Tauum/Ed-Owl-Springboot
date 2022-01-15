package edowl.Model;

import javax.persistence.*;
import java.time.LocalDate;

// serializable helps translating to streams
@Entity //needed for database mapping
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public String summary;
    public String content;
    public String author;
    public LocalDate creation;
    public String video;

    public Post() { }

    public Post(String title, String summary, String content, String author, LocalDate creation, String video) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.author = author;
        this.creation = creation;
        this.video = video;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getCreation() {
        return creation;
    }

    public void setCreation(LocalDate creation) {
        this.creation = creation;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

}


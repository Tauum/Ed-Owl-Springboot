package edowl.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contact_us")
public class ContactUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String name;
    private String email;
    private String message;
    private LocalDate generatedDate;

    public ContactUs() {
    }

    public ContactUs(String name, String email, String message, LocalDate generatedDate) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.generatedDate = generatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }
}




package edowl.Model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "quiz")


public class Tag {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Long id;
    public String content;
    public Boolean admin;
}

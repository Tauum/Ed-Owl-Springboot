package edowl.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "match_definitions",
            joinColumns = { @JoinColumn(name = "match_id")},
            inverseJoinColumns = { @JoinColumn(name = "definition_id")})
    @Column(name = "definitions")
    public Set<Definition> definitions = new HashSet<>();
    public String title;
    public String subject;
    private LocalDate generatedDate;
    public float value;
    public String content;
    public boolean hidden;

    public Match(Set<Definition> definitions, String title, String subject, LocalDate generatedDate, float value, String content, boolean hidden) {
        this.definitions = definitions;
        this.title = title;
        this.subject = subject;
        this.generatedDate = generatedDate;
        this.value = value;
        this.content = content;
        this.hidden = hidden;
    }

    public Match() { }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Set<Definition> definitions) {
        this.definitions = definitions;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }



    public void setGeneral(String title, float value, boolean hidden, String subject, String content){
        this.title = title;
        this.value =value;
        this.hidden = hidden;
        this.subject =subject;
        this.content = content;
    }

}

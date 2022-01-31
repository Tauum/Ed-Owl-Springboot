package edowl.Model;

import javax.persistence.*;

@Entity
@Table(name = "definition")
public class Definition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    public String title;
    public String explaination;
    public float value;

    public Definition() { }

    public Definition(String title, String explaination, float value) {
        this.title = title;
        this.explaination = explaination;
        this.value = value;
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

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setGeneral(String title, String explaination, float value){
        this.title = title;
        this.explaination = explaination;
        this.value = value;
    }
}

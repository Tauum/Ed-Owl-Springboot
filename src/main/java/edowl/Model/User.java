package edowl.Model;

//https://attacomsian.com/blog/spring-data-jpa-one-to-many-mapping
//    ^ this shows using mappedBy - however not every module or tag will be referencing things outside of user

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// serializable helps translating to streams
@Entity //needed for database mapping
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) public Long id;
    @Column(name = "name")
    public String name;
    @Column(name = "email")
    private String email;
    @Column(name = "yob")
    private int yob;
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Column(name = "terms_and_conditions")
    private boolean termsandconditions;
    @Column(name = "study_acceptence")
    private boolean studyacceptence;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_modules",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "module_id")})
    @Column(name = "modules")
    public Set<Module> modules; // this doesnt work?

    public User() {}

    public User(String name, String email, int yob, Role role, boolean termsandconditions, boolean studyacceptence) {
        this.name = name;
        this.email = email;
        this.yob = yob;
        this.role = role;
        this.termsandconditions = termsandconditions;
        this.studyacceptence = studyacceptence;
    }

    public User(String name, String email, int yob, Role role, boolean termsandconditions, boolean studyacceptence, Set<Module> modules) {
        this.name = name;
        this.email = email;
        this.yob = yob;
        this.role = role;
        this.termsandconditions = termsandconditions;
        this.studyacceptence = studyacceptence;
        this.modules = modules;
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

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isTermsandconditions() {
        return termsandconditions;
    }

    public void setTermsandconditions(boolean termsandconditions) {
        this.termsandconditions = termsandconditions;
    }

    public boolean isStudyacceptence() {
        return studyacceptence;
    }

    public void setStudyacceptence(boolean studyacceptence) {
        this.studyacceptence = studyacceptence;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
}

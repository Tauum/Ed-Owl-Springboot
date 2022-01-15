package edowl.Model;

public enum Role {
    UNDEFINED ("Undefined"),
    STUDENT ("Student"),
    STAFF ("Staff"),
    ADMIN ("Admin");

    private final String name;

    Role(String name) {
        this.name = name;
    }
}
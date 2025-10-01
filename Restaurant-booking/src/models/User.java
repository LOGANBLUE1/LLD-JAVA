package models;

public final class User {
    public final long id;
    public final String name;
    public final String contact;

    public User(long id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
}

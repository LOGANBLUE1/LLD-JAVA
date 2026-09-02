package designProblemsAndGames.splitwise.user;

import java.util.Objects;

/**
 * A user is pure identity - who they are, nothing about what they owe.
 *
 * Balances used to live here as lendedTo/borrowedFrom maps, which meant every User held
 * references to every other User and either side of a debt could be written on its own.
 * ExpenseManager owns the balance graph now, so a User cannot be pushed out of sync with
 * its counterpart.
 */
public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String phone;

    public User(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Users are HashMap keys in the balance graph. Identity comparison happened to work while
    // every User was built once in main(), but two objects loaded for the same id from a repo
    // would have kept separate balances.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        return Objects.equals(id, ((User) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
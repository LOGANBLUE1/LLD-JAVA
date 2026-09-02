package designProblemsAndGames.splitwise.user;

/**
 * An unordered pair of users, used as the key of a group's balance map.
 *
 * The pair is canonical - of(alice, bob) and of(bob, alice) are the same key - so a debt
 * between two people has exactly one row, and the sign of the stored amount says which way
 * it runs. That is what lets the balance map be flat: with a Map<User, Map<User, Double>>
 * the two directions were separate entries that had to be written together and kept in
 * agreement by hand.
 */
record UserPair(User first, User second) {

    static UserPair of(User a, User b) {
        if (a.equals(b)) {
            throw new IllegalArgumentException("A user cannot owe themselves: " + a.getName());
        }
        // Order by id so the pair is independent of the order it was created in.
        return a.getId().compareTo(b.getId()) < 0 ? new UserPair(a, b) : new UserPair(b, a);
    }
}
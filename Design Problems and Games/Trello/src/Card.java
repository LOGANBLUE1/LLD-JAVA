public class Card {
    String id;
    String name;
    String description;
    User assignedTo;

    public Card(String name) {
        this.name = name;
    }

    public void assignUser(User user) {
        this.assignedTo = user;
    }
    public void unassignUser() {
        this.assignedTo = null;
    }
}

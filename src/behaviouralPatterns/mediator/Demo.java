package behaviouralPatterns.mediator;

public class Demo {
    public static void main(String[] args) {

        ChatRoom room = new ChatRoom();

        User alice = new ChatUser(room, "Alice");
        User bob = new ChatUser(room, "Bob");
        User charlie = new ChatUser(room, "Charlie");

        room.addUser(alice);
        room.addUser(bob);
        room.addUser(charlie);

        alice.send("Hello Everyone");
    }
}
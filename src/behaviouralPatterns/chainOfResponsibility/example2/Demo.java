package behaviouralPatterns.chainOfResponsibility.example2;

import java.io.IOException;
import java.util.Scanner;

public class Demo {
    private static Scanner sc = new Scanner(System.in);

    private static int readValidAmount() {
        while (true) {
            System.out.print("Enter amount: ");
            int amount = sc.nextInt();
            if (amount == 0) {
                System.out.println("Amount must be greater than zero.");
                continue;
            }

            return amount;
        }
    }

    void main() {
        Handler handler = Handler.link(
                new NoteDispenser(500, 10),
                new NoteDispenser(200, 10),
                new NoteDispenser(100, 10)
        );

        int amount = readValidAmount();
        System.out.println("Requested amount: " + amount);

        if (!handler.validate(amount)) {
            System.out.println("Cannot dispense " + amount + " with the available notes.");
            return;
        }

        handler.dispense(amount);
    }

}
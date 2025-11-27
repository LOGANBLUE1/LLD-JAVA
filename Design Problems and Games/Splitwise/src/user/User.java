package user;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String phone;
    private final Map<User, Double> borrowedFrom;
    private final Map<User, Double> lendedTo;
    //how much this user owes to others (+ve means others owe this user, -ve means this user owes others)

    public User(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.borrowedFrom = new HashMap<>();
        this.lendedTo = new HashMap<>();
    }

    public void addTransaction(User other, double amount) {
        if(amount > 0) {
            double originalAmount = this.lendedTo.getOrDefault(other, 0.0);
            this.lendedTo.put(other, originalAmount + amount);
        } else {
            double originalAmount = this.borrowedFrom.getOrDefault(other, 0.0);
            this.borrowedFrom.put(other, originalAmount - amount);
        }
    }

    public void showBalances() {
        for (Map.Entry<User, Double> entry : this.getLendedTo().entrySet()) {
                System.out.println(this.getName() + " gets ₹" + entry.getValue() + " from " + entry.getKey().getName());
        }
        for (Map.Entry<User, Double> entry : this.getBorrowedFrom().entrySet()) {
            System.out.println(this.getName() + " owes ₹" + (entry.getValue()) + " to " + entry.getKey().getName());
        }
    }
}

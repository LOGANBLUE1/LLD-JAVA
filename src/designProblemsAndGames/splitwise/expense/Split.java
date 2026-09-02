package designProblemsAndGames.splitwise.expense;

//import lombok.AllArgsConstructor;
//import lombok.Data;
import designProblemsAndGames.splitwise.user.User;

//@Data
//@AllArgsConstructor
public class Split {
    private User user;

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public Split(double amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    private double amount;
}

package designProblemsAndGames.Splitwise.expense;

//import lombok.AllArgsConstructor;
//import lombok.Data;
import designProblemsAndGames.Splitwise.user.User;

//@Data
//@AllArgsConstructor
public class Split {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Split(double amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    private double amount;
}

package expense;

import lombok.Data;
import user.User;
import java.util.List;

@Data
public class Expense {
    private String id;
    private String description;
    private User paidBy;
    private double amount;
    private List<User> participants;
    private SplitType splitType;
    private List<Double> percentages;
    private List<Double> exactAmounts;

    public Expense(String id, SplitType splitType, User paidBy, double amount, List<User> participants) {
        this.id = id;
        this.splitType = splitType;
        this.paidBy = paidBy;
        this.amount = amount;
        this.participants = participants;
    }
}

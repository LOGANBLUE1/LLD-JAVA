package designProblemsAndGames.splitwise.expense;

//import lombok.Data;
import designProblemsAndGames.splitwise.user.User;
import java.util.List;

//@Data
public class Expense {
    private String id;
    private String description;
    private User paidBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public List<Double> getPercentages() {
        return percentages;
    }

    public void setPercentages(List<Double> percentages) {
        this.percentages = percentages;
    }

    public List<Double> getExactAmounts() {
        return exactAmounts;
    }

    public void setExactAmounts(List<Double> exactAmounts) {
        this.exactAmounts = exactAmounts;
    }

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

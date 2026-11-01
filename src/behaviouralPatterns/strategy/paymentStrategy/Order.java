package behaviouralPatterns.strategy.paymentStrategy;

public class Order {
    public String orderId;
    public String userId;
    public double totalAmount;
    public OrderStatus status;
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

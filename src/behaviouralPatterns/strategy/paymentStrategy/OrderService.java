package behaviouralPatterns.strategy.paymentStrategy;

import behaviouralPatterns.strategy.paymentStrategy.paymentDetails.PaymentDetails;
import behaviouralPatterns.strategy.paymentStrategy.paymentStrategy.PaymentStrategy;

public class OrderService {
    public void placeOrder(Order order, PaymentDetails paymentDetails) {
        // 1. Calculate total order amount
        double totalAmount = order.totalAmount;

        // 2. Use Factory to get the correct Strategy
        PaymentStrategy strategy = PaymentStrategyFactory.getPaymentStrategy(paymentDetails);

        // 3. Execute payment without knowing the underlying implementation details
        strategy.processPayment(totalAmount);

        // 4. Update order status
        order.setStatus(OrderStatus.PLACED);
    }
}

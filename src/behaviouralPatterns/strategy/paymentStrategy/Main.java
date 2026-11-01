package behaviouralPatterns.strategy.paymentStrategy;

import behaviouralPatterns.strategy.paymentStrategy.paymentDetails.CardDetails;
import behaviouralPatterns.strategy.paymentStrategy.paymentDetails.PaymentDetails;

public class Main {
    public static void main(String [] args) {
        Order order = new Order();
        OrderService orderService = new OrderService();
        PaymentDetails cardPaymentDetails = new CardDetails("123456789012", "123", "12/25");
        orderService.placeOrder(order, cardPaymentDetails);
    }
}

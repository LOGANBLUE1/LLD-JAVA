package behaviouralPatterns.strategy.paymentStrategy.paymentStrategy;

import behaviouralPatterns.strategy.paymentStrategy.paymentDetails.CodDetails;

public class CodPaymentStrategy implements PaymentStrategy {
    private final CodDetails codDetails;

    public CodPaymentStrategy(CodDetails codDetails) {
        this.codDetails = codDetails;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Order marked as COD. Collect ₹" + amount + " upon delivery.");
    }
}
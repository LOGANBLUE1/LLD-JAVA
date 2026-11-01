package behaviouralPatterns.strategy.paymentStrategy.paymentStrategy;

import behaviouralPatterns.strategy.paymentStrategy.paymentDetails.UpiDetails;

public class UpiPaymentStrategy implements PaymentStrategy {
    private String upiId;

    public UpiPaymentStrategy(UpiDetails details) {
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Generating UPI intent/QR for ₹" + amount + " to " + upiId);
    }
}

package behaviouralPatterns.strategy.paymentStrategy.paymentStrategy;

import behaviouralPatterns.strategy.paymentStrategy.paymentDetails.CardDetails;

public class CardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cvv;

    public CardPaymentStrategy(CardDetails details) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing card payment of ₹" + amount + " via Gateway.");
    }
}
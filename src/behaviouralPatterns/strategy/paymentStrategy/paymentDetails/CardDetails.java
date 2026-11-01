package behaviouralPatterns.strategy.paymentStrategy.paymentDetails;

public record CardDetails(String cardNumber, String cvv, String billingAddress) implements PaymentDetails {}



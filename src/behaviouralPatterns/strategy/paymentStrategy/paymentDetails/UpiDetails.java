package behaviouralPatterns.strategy.paymentStrategy.paymentDetails;

public record UpiDetails(String upiId, String billingAddress) implements PaymentDetails {}

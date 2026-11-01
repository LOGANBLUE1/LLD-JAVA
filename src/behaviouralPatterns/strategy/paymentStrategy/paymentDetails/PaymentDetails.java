package behaviouralPatterns.strategy.paymentStrategy.paymentDetails;

// A sealed interface only permits specific data records
public sealed interface PaymentDetails permits CardDetails, UpiDetails, CodDetails {}

package behaviouralPatterns.strategy.paymentStrategy;

import behaviouralPatterns.strategy.paymentStrategy.paymentDetails.CardDetails;
import behaviouralPatterns.strategy.paymentStrategy.paymentDetails.CodDetails;
import behaviouralPatterns.strategy.paymentStrategy.paymentDetails.PaymentDetails;
import behaviouralPatterns.strategy.paymentStrategy.paymentDetails.UpiDetails;
import behaviouralPatterns.strategy.paymentStrategy.paymentStrategy.CardPaymentStrategy;
import behaviouralPatterns.strategy.paymentStrategy.paymentStrategy.CodPaymentStrategy;
import behaviouralPatterns.strategy.paymentStrategy.paymentStrategy.PaymentStrategy;
import behaviouralPatterns.strategy.paymentStrategy.paymentStrategy.UpiPaymentStrategy;

public class PaymentStrategyFactory {
    public static PaymentStrategy getPaymentStrategy(PaymentDetails details) {
        return switch (details) {
            case CardDetails card -> new CardPaymentStrategy(card);
            case UpiDetails upi   -> new UpiPaymentStrategy(upi);
            case CodDetails cod   -> new CodPaymentStrategy(cod);
        };
    }
}

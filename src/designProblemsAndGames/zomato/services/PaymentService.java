package designProblemsAndGames.zomato.services;

import designProblemsAndGames.zomato.strategies.PaymentStrategy;

public class PaymentService {

    public boolean process(double amount, PaymentStrategy strategy) {
        if (strategy == null) {
            return false;
        }
        try {
            strategy.pay(amount);
            return true; // Execution completed successfully without errors
        } catch (Exception e) {
            System.out.println("Payment failed: " + e.getMessage());
            return false;
        }
    }
}

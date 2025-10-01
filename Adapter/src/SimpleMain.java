interface PaymentProcessor {
    void pay(int amount);
}

class DefaultPayment implements PaymentProcessor {
    private Paypalpay mediaAdapter;

    @Override
    public void pay(int amount) {
        System.out.println("Processing normal payment of amount: " + amount);
    }
}

class Paypalpay{

    public void makePayment(int amount) {
        System.out.println("Processing PayPal payment of amount: " + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private Paypalpay payPal;

    public PayPalAdapter(Paypalpay payPal) {
        this.payPal = payPal;
    }

    @Override
    public void pay(int amount) {
        payPal.makePayment(amount);
    }
}

class ShoppingCart {
    private PaymentProcessor paymentProcessor;

    public ShoppingCart(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(int amount) {
        paymentProcessor.pay(amount);
    }
}


public class SimpleMain {
    public static void main(String[] args) {
        ShoppingCart cart1 = new ShoppingCart(new DefaultPayment());
        cart1.checkout(200); // ✅ Works as before


        PaymentProcessor processor = new PayPalAdapter(new Paypalpay());
        ShoppingCart cart = new ShoppingCart(processor);
        cart.checkout(150); // ✅ Works without changing client code
    }
}
package designProblemsAndGames.zomato.managers;

import designProblemsAndGames.zomato.factories.OrderFactory;
import designProblemsAndGames.zomato.models.*;
import designProblemsAndGames.zomato.repository.OrderRepository;
import designProblemsAndGames.zomato.services.PaymentService;
import designProblemsAndGames.zomato.strategies.PaymentStrategy;

import java.util.List;

public class OrderManager {
    private static OrderManager instance = null;
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;

    private OrderManager(OrderRepository orderRepository, PaymentService paymentService) {
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
    }

    public static synchronized OrderManager getInstance(OrderRepository orderRepository, PaymentService paymentService) {
        if (instance == null) {
            instance = new OrderManager(orderRepository, paymentService);
        }
        return instance;
    }

    public Order createAndCheckoutOrder(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory, String time) {
        if (user.getCart().isEmpty()) return null;

        Cart userCart = user.getCart();
        Restaurant orderedRestaurant = userCart.getRestaurant();
        List<MenuItem> itemsOrdered = userCart.getItems();
        double totalCost = userCart.getTotalCost();

        // Delegate order creation to the factory
        Order order = orderFactory.createOrder(user, orderedRestaurant, itemsOrdered, totalCost, orderType, time);

        // Process the order
        processOrder(order, paymentStrategy);

        return order;
    }

    // Core business workflow executed during checkout
    public void processOrder(Order order, PaymentStrategy paymentMethod) {
        if (order == null) {
            throw new IllegalArgumentException("Order not found");
        }

        // Delegate payment entirely
        boolean isSuccess = paymentService.process(order.getTotal(), paymentMethod);

        if (isSuccess) {
            order.setStatus(OrderStatus.PLACED);
            System.out.println("Order is now PLACED.");
        } else {
            order.setStatus(OrderStatus.PAYMENT_FAILED);
            System.out.println("Payment failed for Order " + order);
        }

        // Save the updated state back to our in-memory store
        orderRepository.addOrder(order);
    }

}

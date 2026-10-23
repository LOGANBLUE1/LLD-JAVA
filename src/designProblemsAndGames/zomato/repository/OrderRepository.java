package designProblemsAndGames.zomato.repository;

import designProblemsAndGames.zomato.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    private static OrderRepository instance = null;

    private OrderRepository() {
        // Private Constructor
    }

    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void listOrders() {
        System.out.println("\n--- All Orders ---");
        for (Order order : orders) {
            System.out.println(order.getType() + " order for " + order.getUser().getName()
                    + " | Total: ₹" + order.getTotal()
                    + " | At: " + order.getScheduled());
        }
    }
}


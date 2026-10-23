package designProblemsAndGames.zomato.models;

import java.util.List;

public abstract class Order {
    private static int nextOrderId = 0;

    protected int orderId;
    protected User user;
    protected Restaurant restaurant;
    protected List<MenuItem> items;
    protected double total;
    protected String scheduledTime;
    protected OrderStatus status;


    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public Order() {
        this.user = null;
        this.restaurant = null;
//        this.paymentStrategy = null;
        this.total = 0.0;
        this.scheduledTime = "";
        this.orderId = ++nextOrderId;
    }

    public abstract String getType();

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setUser(User u) {
        user = u;
    }

    public User getUser() {
        return user;
    }

    public void setRestaurant(Restaurant r) {
        restaurant = r;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setItems(List<MenuItem> its) {
        items = its;
        total = 0;
        for (MenuItem i : items) {
            total += i.getPrice();
        }
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setScheduledTime(String s) {
        scheduledTime = s;
    }

    public String getScheduled() {
        return scheduledTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}


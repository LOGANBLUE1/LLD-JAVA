package designProblemsAndGames.zomato.factories;

import designProblemsAndGames.zomato.models.*;

import java.util.List;


public class OrderFactory {

    public OrderFactory() {
    }

    public Order createOrder(User user, Restaurant restaurant, List<MenuItem> menuItems,
                             double totalCost, String orderType, String scheduleTime) {
        Order order = null;

        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setScheduledTime(scheduleTime);
        order.setTotal(totalCost);
        return order;
    }
}

package designProblemsAndGames.zomato;

import designProblemsAndGames.zomato.factories.OrderFactory;
import designProblemsAndGames.zomato.managers.OrderManager;
import designProblemsAndGames.zomato.models.Order;
import designProblemsAndGames.zomato.models.Restaurant;
import designProblemsAndGames.zomato.models.User;
import designProblemsAndGames.zomato.repository.OrderRepository;
import designProblemsAndGames.zomato.services.PaymentService;
import designProblemsAndGames.zomato.strategies.UpiPaymentStrategy;
import designProblemsAndGames.zomato.utils.TimeUtils;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Simulating a happy flow
        // Create TomatoApp Object
        ZomatoApp tomato = new ZomatoApp();
        PaymentService ps = new PaymentService();
        OrderManager orderManager = OrderManager.getInstance(OrderRepository.getInstance(), ps);

        // Simulate a user coming in (Happy Flow)
        User user = new User(101, "Aditya", "Delhi");
        System.out.println("User: " + user.getName() + " is active.");

        // User searches for restaurants by location
        List<Restaurant> restaurantList = tomato.searchRestaurants("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        restaurantList.forEach(r -> System.out.println(" - " + r.getName()));

        // User selects a restaurant
        Restaurant selectedRestaurant = restaurantList.getFirst(); // Safely get the first restaurant
        tomato.selectRestaurant(user, selectedRestaurant);
        System.out.println("Selected restaurant: " + selectedRestaurant.getName());

        // User adds items to the cart
        tomato.addToCart(user, "P1");
        tomato.addToCart(user, "P2");
        tomato.printUserCart(user);

        // User checkout the cart
        String time = TimeUtils.getCurrentTime();
        Order order = orderManager.createAndCheckoutOrder(user, "Delivery", new UpiPaymentStrategy("1234567890"), new OrderFactory(), time);
        if (order != null) {
            System.out.println("Order placed successfully: " + order);
        } else {
            System.out.println("Failed to place the order.");
        }

    }
}

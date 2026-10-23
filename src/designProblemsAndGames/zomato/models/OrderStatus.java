package designProblemsAndGames.zomato.models;

public enum OrderStatus {
    PENDING_PAYMENT,   // Order created but payment not yet processed
    PAYMENT_FAILED,    // Payment transaction was rejected/failed
    PLACED,            // Payment successful, order sent to restaurant
    ACCEPTED,          // Restaurant accepted and acknowledged the order
    PREPARING,         // Food is being cooked in the kitchen
    OUT_FOR_DELIVERY,  // Picked up by the delivery partner and en route
    DELIVERED,         // Successfully handed over to the customer
    CANCELLED          // Cancelled either by user, restaurant, or system
}
import java.util.ArrayList;


public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();

    // Constructor
    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    // Process a new order
    public void processNewOrder(Order order) {
        // Add the order to the list
        orders.add(order);


        new Thread(() -> {
            try {

                order.setOrderStatus(OrderStatus.PENDING);
                System.out.println(order.toString());

                Thread.sleep(3000);
                order.setOrderStatus(OrderStatus.SHIPPED);
                System.out.println("\nOrder update: SHIPPED\n" + order.toString());

                Thread.sleep(3000);
                order.setOrderStatus(OrderStatus.DELIVERED);
                System.out.println("\nOrder update: DELIVERED:\n" + order.toString());

            } catch (InterruptedException e) {
                System.out.println("Order update interrupted.");
            }
        }).start(); //Starts the thread
    }
}

public class OrderApp {
    private OrderService orderService;

    public OrderApp() {
        orderService = new OrderService();
    }

    public void processOrder() {
        FoodItem food = new FoodItem("kornet", 12000);
        double total = orderService.calculateTotal(food, 2);
        System.out.println("Order: " + food.getName());
        System.out.println("Total Price: Rp " + total);
    }

    public static void main(String[] args) {
        OrderApp app = new OrderApp();
        app.processOrder();
    }
}
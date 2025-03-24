public class OrderService {
    public double calculateTotal(FoodItem item, int quantity) {
        return item.getPrice() * quantity;
    }
}
// Element interface
interface ItemElement {
    void accept(ShoppingCartVisitor visitor);
}

// Concrete Elements
class Book implements ItemElement {
    private double price;
    private String isbn;
    
    public Book(double price, String isbn) {
        this.price = price;
        this.isbn = isbn;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}

class Fruit implements ItemElement {
    private double weight;
    private double pricePerKg;
    private String name;
    
    public Fruit(double weight, double pricePerKg, String name) {
        this.weight = weight;
        this.pricePerKg = pricePerKg;
        this.name = name;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public double getPricePerKg() {
        return pricePerKg;
    }
    
    public String getName() {
        return name;
    }
    
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}

// Visitor interface
interface ShoppingCartVisitor {
    void visit(Book book);
    void visit(Fruit fruit);
    double getTotal();
}

// Concrete Visitor
class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    private double total = 0;
    
    public void visit(Book book) {
        double cost = book.getPrice();
        if (book.getPrice() > 50) {
            cost -= 5; // $5 discount
        }
        System.out.println("Book ISBN: " + book.getIsbn() + ", cost: " + cost);
        total += cost;
    }
    
    public void visit(Fruit fruit) {
        double cost = fruit.getWeight() * fruit.getPricePerKg();
        System.out.println(fruit.getName() + ", cost: " + cost);
        total += cost;
    }
    
    public double getTotal() {
        return total;
    }
}

// Client
public class VisitorDemo {
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{
            new Book(20, "1234"),
            new Book(100, "5678"),
            new Fruit(10, 2, "Banana"),
            new Fruit(5, 5, "Apple")
        };
        
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        
        for (ItemElement item : items) {
            item.accept(visitor);
        }
        
        System.out.println("Total cost: " + visitor.getTotal());
    }
}
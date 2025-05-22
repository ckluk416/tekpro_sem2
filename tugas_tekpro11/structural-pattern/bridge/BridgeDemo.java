// Implementor interface
interface Color {
    void fill();
}

// Concrete Implementors
class Red implements Color {
    public void fill() {
        System.out.println("Filling with red color");
    }
}

class Blue implements Color {
    public void fill() {
        System.out.println("Filling with blue color");
    }
}

// Abstraction
abstract class Shape {
    protected Color color;
    
    public Shape(Color color) {
        this.color = color;
    }
    
    abstract void draw();
}

// Refined Abstractions
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    public void draw() {
        System.out.print("Drawing circle - ");
        color.fill();
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    public void draw() {
        System.out.print("Drawing square - ");
        color.fill();
    }
}

// Client
public class BridgeDemo {
    public static void main(String[] args) {
        Color red = new Red();
        Color blue = new Blue();
        
        Shape redCircle = new Circle(red);
        Shape blueSquare = new Square(blue);
        
        redCircle.draw();
        blueSquare.draw();
    }
}
// Image interface
interface Image {
    void display();
}

// RealImage class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// ProxyImage class
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client
public class ProxyDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("lxqtdesktop.jpg");
        Image image2 = new ProxyImage("gnomedesktop.png");
        
        // Image will be loaded from disk only when displayed
        image1.display(); 
        image1.display(); // Image will not be loaded again
        image2.display();
    }
}
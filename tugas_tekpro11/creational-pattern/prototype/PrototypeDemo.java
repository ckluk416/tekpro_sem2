import java.util.HashMap;
import java.util.Map;

// Prototype interface
interface Prototype {
    Prototype clone();
    void showRecord();
}

// Concrete Prototype
class Employee implements Prototype {
    private String id;
    private String name;
    private String address;
    private double salary;
    
    public Employee() {
        System.out.println("Employee records loaded from database");
    }
    
    public Employee(String id, String name, String address, double salary) {
        this();
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }
    
    public void showRecord() {
        System.out.println("ID: " + id + ", Name: " + name + 
                         ", Address: " + address + ", Salary: " + salary);
    }
    
    public Prototype clone() {
        return new Employee(id, name, address, salary);
    }
}

// Prototype registry
class EmployeeRegistry {
    private static Map<String, Prototype> employees = new HashMap<>();
    
    static {
        employees.put("manager", new Employee("1", "John", "123 Main St", 5000));
        employees.put("developer", new Employee("2", "Alice", "456 Oak Ave", 4000));
    }
    
    public static Prototype getEmployee(String type) {
        try {
            return employees.get(type).clone();
        } catch (NullPointerException e) {
            System.out.println("Prototype not found");
            return null;
        }
    }
}

// Client
public class PrototypeDemo {
    public static void main(String[] args) {
        Prototype manager1 = EmployeeRegistry.getEmployee("manager");
        Prototype manager2 = EmployeeRegistry.getEmployee("manager");
        Prototype developer1 = EmployeeRegistry.getEmployee("developer");
        
        manager1.showRecord();
        manager2.showRecord();
        developer1.showRecord();
        
        // Verify they are different objects
        System.out.println("manager1 == manager2: " + (manager1 == manager2));
    }
}
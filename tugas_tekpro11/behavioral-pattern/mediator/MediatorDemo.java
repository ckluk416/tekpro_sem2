import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}

// Concrete Mediator
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;
    
    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }
    
    public void addUser(User user) {
        this.users.add(user);
    }
    
    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            // Message shouldn't be received by the sender
            if (u != user) {
                u.receive(msg);
            }
        }
    }
}

// Colleague abstract class
abstract class User {
    protected ChatMediator mediator;
    protected String name;
    
    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }
    
    public abstract void send(String msg);
    public abstract void receive(String msg);
}

// Concrete Colleague
class UserImpl extends User {
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }
    
    public void send(String msg) {
        System.out.println(this.name + " sends: " + msg);
        mediator.sendMessage(msg, this);
    }
    
    public void receive(String msg) {
        System.out.println(this.name + " receives: " + msg);
    }
}

// Client
public class MediatorDemo {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        
        User user1 = new UserImpl(mediator, "Alice");
        User user2 = new UserImpl(mediator, "Bob");
        User user3 = new UserImpl(mediator, "Charlie");
        User user4 = new UserImpl(mediator, "Diana");
        
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);
        
        user1.send("Hi everyone!");
        user3.send("Hello Alice!");
    }
}
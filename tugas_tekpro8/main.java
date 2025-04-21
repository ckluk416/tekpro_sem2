// Generic Interface
interface Processor<T, U> { 
    void process(T number, U text);
}

// Parent Class
class BaseReceipt<T, U> {
    private T number; 
    private U text;   
    public BaseReceipt(T number, U text){
        this.number = number;
        this.text = text;
    }
    public T getNumber(){
        return number;
    }
    public U getText(){
        return text;
    }
}

// Child Class that Extends Parent and Implements Interface
class DetailedReceipt<T extends Integer, U extends String> extends BaseReceipt<T, U> implements Processor<T, U> {
    public DetailedReceipt(T number, U text){
        super(number, text);
    }
    @Override
    public void process(T number, U text){
        System.out.println("Amount: " + number);
        System.out.println("In Words: " + text);
        System.out.println("Number of Digits: " + number.toString().length());
    }
}

// Main Class
public class main{
    public static void main(String[] args){
        DetailedReceipt<Integer, String> receipt = new DetailedReceipt<>(1500, "Seribu Lima Ratus Rupiah");
        receipt.process(receipt.getNumber(), receipt.getText());
    }
}
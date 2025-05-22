// Product
class Computer {
    private String RAM;
    private String HDD;
    private String CPU;
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;
    
    private Computer(ComputerBuilder builder) {
        this.RAM = builder.RAM;
        this.HDD = builder.HDD;
        this.CPU = builder.CPU;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }
    
    // Getters
    public String getRAM() { return RAM; }
    public String getHDD() { return HDD; }
    public String getCPU() { return CPU; }
    public boolean isGraphicsCardEnabled() { return isGraphicsCardEnabled; }
    public boolean isBluetoothEnabled() { return isBluetoothEnabled; }
    
    @Override
    public String toString() {
        return "Computer [RAM=" + RAM + ", HDD=" + HDD + ", CPU=" + CPU + 
               ", GraphicsCard=" + isGraphicsCardEnabled + 
               ", Bluetooth=" + isBluetoothEnabled + "]";
    }
    
    // Builder
    public static class ComputerBuilder {
        private String RAM;
        private String HDD;
        private String CPU;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;
        
        public ComputerBuilder(String RAM, String HDD, String CPU) {
            this.RAM = RAM;
            this.HDD = HDD;
            this.CPU = CPU;
        }
        
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }
        
        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }
        
        public Computer build() {
            return new Computer(this);
        }
    }
}

// Director (optional)
class ComputerDirector {
    public Computer constructGamingComputer() {
        return new Computer.ComputerBuilder("16GB", "1TB", "Intel i7")
            .setGraphicsCardEnabled(true)
            .setBluetoothEnabled(true)
            .build();
    }
    
    public Computer constructOfficeComputer() {
        return new Computer.ComputerBuilder("8GB", "500GB", "Intel i5")
            .setGraphicsCardEnabled(false)
            .setBluetoothEnabled(false)
            .build();
    }
}

// Client
public class BuilderDemo {
    public static void main(String[] args) {
        // Using builder directly
        Computer gamingComputer = new Computer.ComputerBuilder("16GB", "1TB", "Intel i7")
            .setGraphicsCardEnabled(true)
            .setBluetoothEnabled(true)
            .build();
        
        System.out.println("Gaming Computer: " + gamingComputer);
        
        // Using director
        ComputerDirector director = new ComputerDirector();
        Computer officeComputer = director.constructOfficeComputer();
        System.out.println("Office Computer: " + officeComputer);
    }
}
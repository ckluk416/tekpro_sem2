public class Employee {
    private String name;
    private double basicSalary;
    private double allowance;

    public Employee(String name, double basicSalary, double allowance) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.allowance = allowance;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getAllowance() {
        return allowance;
    }

    public String getName() {
        return name;
    }
}
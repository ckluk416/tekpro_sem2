public class EmployeeApp {
    private SalaryCalculator salaryCalculator;

    public EmployeeApp() {
        salaryCalculator = new SalaryCalculator();
    }

    public void processSalary() {
        Employee emp = new Employee("yun zhao", 500000, 10000);
        System.out.println("Employee: " + emp.getName());
        System.out.println("Basic Salary: Rp " + salaryCalculator.calculateBasicSalary(emp));
        System.out.println("Allowance: Rp " + salaryCalculator.calculateAllowance(emp));
        System.out.println("Total Salary: Rp " + salaryCalculator.calculateTotalSalary(emp));
    }

    public static void main(String[] args) {
        EmployeeApp app = new EmployeeApp();
        app.processSalary();
    }
}
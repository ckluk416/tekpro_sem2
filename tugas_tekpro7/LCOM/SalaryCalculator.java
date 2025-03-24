public class SalaryCalculator {
    public double calculateBasicSalary(Employee employee) {
        return employee.getBasicSalary();
    }

    public double calculateAllowance(Employee employee) {
        return employee.getAllowance();
    }

    public double calculateTotalSalary(Employee employee) {
        return employee.getBasicSalary() + employee.getAllowance();
    }
}
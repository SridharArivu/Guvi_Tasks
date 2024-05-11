
public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee("Sridhar", 24, 327468, 80000);
        System.out.println("Employee ID: "+employee.getEmployeeID());
        System.out.println("Employee Name: "+employee.getName());
        System.out.println("Employee Age: "+employee.getAge());
        System.out.println("Employee Salary: "+employee.getSalary());
    }
}

public class Employee extends Person {

     private int employeeID;
     private double salary;
 
    
     public Employee(String name, int age, int employeeID, double salary) {
         
         super(name, age);
         this.employeeID = employeeID;
         this.salary = salary;
     }

     public int getEmployeeID() {
        return employeeID;
    }
    public double getSalary() {
        return salary;
    }

    public void setEmployeeID(int EmployeeId) {
        this.employeeID = EmployeeId;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
 
}

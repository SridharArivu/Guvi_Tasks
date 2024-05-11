import java.text.DecimalFormat;

public class Employee implements Taxable{

     private int employeeID;
     private String name;
     private double salary;
 
    
     public Employee(String name , int employeeID, double salary) {
         this.name = name;
         this.employeeID = employeeID;
         this.salary = salary;
     }

     @Override
     public double calcTax(){
        double yearlyIncome = salary*12;
        double incomeTax = yearlyIncome * Taxable.INCOME_TAX;

        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(incomeTax));
     }

    public int getEmployeeID() {
        return employeeID;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }

    public void setEmployeeID(int EmployeeId) {
        this.employeeID = EmployeeId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
 
}

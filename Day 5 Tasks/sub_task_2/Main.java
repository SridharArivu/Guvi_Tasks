import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter actions like to perform \n 1. Calculate Income Tax\n 2. Calculate Sale Tax");
            int actions = sc.nextInt();
            switch (actions) {
                case 1:{
                    System.out.print("Enter Employee ID: ");
                    int employeeID = sc.nextInt();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.next();

                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();

                    Employee employee = new Employee(name, employeeID, salary);

                    System.out.println("\n Income Tax for the Employee "+employee.getName()+" is "+employee.calcTax()+"\n");
                    break;
                }
                case 2:{
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();

                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Product Quantity: ");
                    int quantity = sc.nextInt();

                    Product product = new Product(pid, price,quantity);
                    System.out.println("\n Sales Tax for the Product ID: "+product.getPid()+" is "+product.calcTax()+"\n");
                    break;
                }
                case 3:{
                    sc.close();
                    break;
                }
                default:{
                    System.out.println("Invalid Actions");
                    break;
                }
                    
            }
            if(actions == 3) break;
        }
    }
}
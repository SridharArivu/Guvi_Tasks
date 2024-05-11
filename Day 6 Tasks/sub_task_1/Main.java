import java.util.*;

public class Main {

    public static void main(String[] args) throws AgeNotWithinRangeException, NameNotValidException {
        System.out.println("Enter Details of Student");
        Scanner scanner = new Scanner(System.in);

        Integer roll_no = null;
        String name = null;
        Integer age = null;
        String course = null;
        Student student = null;

        try {
            // gets Roll number
            System.out.println("Enter roll number:");
            roll_no = scanner.nextInt();
            scanner.nextLine();

            // gets Name
            System.out.println("Enter name:");
            name = scanner.nextLine();

            // gets Age
            System.out.println("Enter age:");
            age = scanner.nextInt();
            scanner.nextLine();

            // gets Course Name
            System.out.println("Enter course:");
            course = scanner.nextLine();

            // Creating Student Object
            student = new Student(roll_no, name, age, course);

        } catch (NameNotValidException | AgeNotWithinRangeException exception) {
            Exception e = exception;
            // running loop, until the object creation is successfull
            while (true) {
                // getting input from user in a loop, until the condition gets satisfied
                if (e instanceof NameNotValidException) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Enter Name again:");
                    name = scanner.nextLine();
                  
                // getting input from user in a loop, until the condition gets satisfied
                } else if (e instanceof AgeNotWithinRangeException) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Enter Age again:");
                    age = scanner.nextInt();
                    scanner.nextLine();
                }
                try {
                    student = new Student(roll_no, name, age, course);
                    break;
                } catch (NameNotValidException | AgeNotWithinRangeException ne) {
                    // changing the exception refrence
                    // depending upon the exception, the loop will execute the logic
                    e = ne;
                }
            }
        }finally{
            System.out.print("Name: "+student.getName()+ " ");
            System.out.print("Age: "+student.getAge()+ " ");
            System.out.print("Roll No: "+student.getRoll_no()+ " ");
            System.out.print("Course: "+student.getCourse());
            scanner.close();
        } 
    }
}

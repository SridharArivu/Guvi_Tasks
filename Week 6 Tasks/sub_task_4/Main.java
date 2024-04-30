import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main{
    // Single Function which Performs ADD, REMOVE, READ operations Based on "Operation Parameter"
    public static void addStudent(HashMap<String, Integer> map, String Name, Integer grade, Integer operation){
            switch (operation) {
                // Case 1 Adds Student to the HashMap
                case 1:
                    map.put(Name, grade);
                    System.out.println("Student Details Added Successfully ! \n");
                    break;
                // Case 2 Removes Student to the HashMap
                case 2:
                    map.remove(Name);
                    System.out.println("Student Details Removed Successfully ! \n");
                    break;
                 // Case 3 Displays Student Details from the HashMap
                case 3:
                    {
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("Printing List of Students with thier Respective Names and Grades");
                        System.out.println("----------------------------------------------------------------");
                        for(Entry<String, Integer> m : map.entrySet()){
                            System.out.println("Name: "+m.getKey()+ "   " + "Grade: " +m.getValue());
                        }
                        System.out.println("================================================================ \n");
                        break;
                    }
                default:
                    System.out.println("Invalid Operation Performed \n");
                    break;
            }
    }

    public static void main(String[] args) {
        
        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        String Name = null;
        Integer Grade = null;

        while (true) {
            System.out.println("Enter Operation need to Perform");
            System.out.println("Press 1 to add a Student and Grade");
            System.out.println("Press 2 to Remove a Student and Grade");
            System.out.println("Press 3 to Display all the Student's Names and Grades");
            System.out.println("Press 4 to Exit");

            int op = sc.nextInt();
            switch (op) {
                // ADD Operation
                case 1:
                    System.out.println("Enter Name of the Student");
                    sc.nextLine(); 
                    Name = sc.nextLine();

                    System.out.println("Enter "+Name+"'s Grade");
                    Grade = sc.nextInt();
                    // Function Calling
                    addStudent(map,Name,Grade,op);
                    break;
                // REMOVE Operation
                case 2:
                    System.out.println("Enter Name of the Student");
                    sc.nextLine(); 
                    Name = sc.nextLine();
                    // Function Calling, Grade is not  Important for Removing, So passing Grade Argument as Null
                    addStudent(map,Name,null,op);
                    break;
                // READ Operation
                case 3:
                    // Function Calling, Name and Grade both not Important for READ, So passing these Arguments as Null
                    addStudent(map,null,null,op);
                    break;
                // Exit
                case 4: 
                    sc.close();
                    break;
                default:
                    addStudent(map,null,null,op);
                    break;
            }
            if ( op == 4) break;
        }
    }
}
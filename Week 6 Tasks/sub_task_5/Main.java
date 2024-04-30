import java.util.Scanner;
import java.util.Stack;

public class Main{
    // Function to visualize the Stack
    public static void printStack(int n, int value){
        int m = (n % 2 == 0) ? n-1 : n;
        System.out.print("**_ _**\n");
        System.out.print("|");
        for(int i=0; i<(5-n)/2; i++)  System.out.print(" ");
        System.out.print(value);
        for(int i=0; i<(5-m)/2; i++)  System.out.print(" ");
        System.out.print("|\n");
        System.out.println("**-_-**");
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        Integer value = null;
       while(true){
        System.out.println("Enter the Operations needs to be Performed");
        System.out.println("Press 1 to Push values into the Stack");
        System.out.println("Press 2 to Pop values from the Stack");
        System.out.println("Press 3 to Check if Stack is Empty");
        System.out.println("Press 4 to Exit");

        int op = sc.nextInt();

        switch (op) {
            // Performs Push 
            case 1:
                System.out.println("Enter the Value you want to push");
                value = sc.nextInt();
                if (value < 0 || value > 99999) {
                    while (value < 0 || value > 99999) {
                        System.out.println("Please enter a value between 0 and 99999:");
                        value = sc.nextInt();
                    }
                }
                    stack.push(value);
                    System.out.println("--------------------------------------------");
                    System.out.println("Value "+value+" Pushed Successfully");
                
                break;
            // Perform Pop
            case 2: 
                if(!stack.isEmpty()){
                    int popped = stack.pop();
                    System.out.println("--------------------------------------------");
                    System.out.println("Value "+popped+" was Popped Successfully");
                }else{
                    System.out.println("--------------------------------------------");
                    System.out.println("Operation cannot perform, Because Stack is Empty");
                } 
                break;
            // Checks Stack is Empty
            case 3:
                if(!stack.isEmpty()){
                    System.out.println("--------------------------------------------");
                    System.out.println("Stack is Not Empty, Stack has Values inside");
                    
                    break;
                }else System.out.println("Stack is Empty");
                break;
            // Exits from the Loop
            case 4:
                sc.close();
                break;
            default:
                System.out.println("##########################");
                System.out.println("Invalid operation performed");
                break;
        }
        // Prints the Stack to Visualize on Every loop
        for(Integer i: stack){
            printStack(String.valueOf(i).length(),i);
        }
        // Breaks From Loop if user enters 4
        System.out.println("___________________________________________");
        if(op == 4) break;
       } 
    }
}
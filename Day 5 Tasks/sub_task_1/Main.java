import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("List of Actions You can perform:\n1. Add Book\n2. Remove Book\n3. Search Book\n4. Display Books\n5. Exit");

            int actions = sc.nextInt();
            switch (actions) {
                case 1:{
                    System.out.print("Enter BookID: ");
                    int bookID = sc.nextInt();

                    System.out.print("Enter Title: ");
                    String title = sc.next();

                    System.out.print("Enter Author: ");
                    String author = sc.next();

                    System.out.print("Enter Availablity (True or False): ");
                    boolean isAvailable = sc.nextBoolean();

                    Book book = new Book(bookID, title, author, isAvailable);
                    Library.addBook(book);
                    System.out.println("\nBook added Successfully");
                    break;
                }
                case 2:{
                    System.out.print("Enter BookID: ");
                    int bookID = sc.nextInt();
                    Library.removeBook(bookID);
                    System.out.println("Removed Book Successfuly");
                    break;
                }
                case 3:{
                    System.out.print("Enter BookID: ");
                    int bookID = sc.nextInt();
                    Library.searchBook(bookID);
                }
                case 4:{
                    Library.displayBooks();
                }case 5:{
                    break;
                }
                default:{
                    System.out.println("Invalid Action");
                    break;
                }  
            }
            if(actions == 5){
                sc.close();
                break; 
            } 
        }
        
    } 
}

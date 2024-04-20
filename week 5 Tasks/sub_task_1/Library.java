import java.util.*;

public class Library {

    static Set<Book> booksList = new HashSet<>();

    public static void addBook(Book book){
        booksList.add(book);
    }
    public static void removeBook(int bookID){
        for(Book book: booksList){
            if(book.getBookID() == bookID){
                booksList.remove(book);
            }
        } 
    }

    public static void searchBook(int bookID) {
        boolean found = false;
        for (Book book : booksList) {
            if (book.getBookID() == bookID) {
                System.out.println("Book ID: " + book.getBookID());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Is Available: " + book.getIsAvailable());
                System.out.println();
                found = true; 
                break;
            }
        }
        if (!found) {
            System.out.println("Book Not Found");
        }
    }
    

    public static void displayBooks(){
        if(booksList.isEmpty()){
            System.out.println("Library is Empty");
        }else{
            for (Book book : booksList) {
                System.out.println("Book ID: " + book.getBookID());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Is Available: " + book.getIsAvailable());
                System.out.println();
            }
        }
        
    }
}

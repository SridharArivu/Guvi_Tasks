public class Book {
    private Integer bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(Integer bookID, String title, String author, boolean isAvailable ){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public Integer getBookID(){
        return bookID;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    }


    public void setBookID(Integer bookID){
        this.bookID = bookID;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }  

}

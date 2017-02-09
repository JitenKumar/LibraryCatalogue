
package librarycatalogue;

public class Book {
    // Properties , Fields of the Book class 
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut; // whethe the book is checked out or not
    int dayCheckedOut = -1;
    
    public Book(String bookTitle , int bookPageCount , int bookISBN){
        this.title = bookTitle;
        this.pageCount = bookPageCount;
        this.ISBN = bookISBN;
        isCheckedOut = false;
    }
    // GETTEERS OR INSTANCE METHODS
    // METHOD USED FOR GETTING THE INSTANCE VARIABLES OF THE BOOK CLASS 
    public String getTitle(){
        return this.title;
        
    }
    public int getPageCount(){
        return this.pageCount;    
    }
    public int getISBN(){
        return this.ISBN;
    }
    public boolean getIsCheckedOut(){
        return this.isCheckedOut;
    }
    public int getDayCheckedOut(){
        return this.dayCheckedOut;
    }
    // SETTERS OR INSTANCE METHODS
    public void setIsCheckedOut(boolean newIsCheckedOut , int currentDayCheckedOut){
        this.isCheckedOut = newIsCheckedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }
    private void setDayCheckedOut(int day){
        this.dayCheckedOut = day;
    }
}

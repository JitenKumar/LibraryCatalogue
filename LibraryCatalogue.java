
package librarycatalogue;

import java.util.Map;
import java.util.HashMap;


public class LibraryCatalogue {
    // BOOK COLLECTION CAN BE MADE USING THE DICTIONARY OR USING THE ARRAY
    // BUT DICTIONARY WILL BE BEST
    Map<String,Book> bookCollection = new HashMap<String,Book>();
    int currentDay = 0;
    int lengthOfCheckOutPeriod = 7;
    double initialLateFine = 1;
    double feePerLateDay = 2.0;
    //Constructors
    
    public LibraryCatalogue(Map<String,Book> collection){
        this.bookCollection = collection;
        
    }
    public LibraryCatalogue(Map<String,Book> collection , int lenghtOfChekOutPeriod , 
            double initialLateFine , double feePerLateDay ){
        this.bookCollection = collection;
        this.lengthOfCheckOutPeriod = lengthOfCheckOutPeriod;
        this.initialLateFine=initialLateFine;
        this.feePerLateDay =feePerLateDay;
    }
    // GETTERS
    public int  getCurrentDay(){
        return this.currentDay;
    }
    public Map<String,Book> getBookCollection (){
        return this.bookCollection;
    }
    public Book getBook(String bookTitle){
        return getBookCollection().get(bookTitle);
    }

    public int  getlengthOfCheckOutPeriod (){
        return this.lengthOfCheckOutPeriod;
    }

    public double getInitialLateFine() {
        return this.initialLateFine;
    }
    public double getFeePerLateDay(){
        return this.feePerLateDay;
    }
    public void nextDay(){
        currentDay++;
    }
    public void setDay(int day){
        currentDay = day;
    }
    //INSTANCE METHODS
     public void checkOut(String title){
         Book book = getBook(title);
         if(book.isCheckedOut){
             bookAlreadyCheckedOut(book);
         }
         else{
             book.setIsCheckedOut(true, currentDay);
             System.out.println(" Book Has been Checked Out " + title+ " It is due on"
                     + " day "+ getCurrentDay() + getlengthOfCheckOutPeriod()+".");
         }
     }
     public void returnBook(String title){
         Book book = getBook(title);
         int lateDays = currentDay -(book.getDayCheckedOut() + getlengthOfCheckOutPeriod());
         if (lateDays > 0){
             System.out.println(" you are fined " + getInitialLateFine() + lateDays * feePerLateDay
             +" because your book is " + lateDays + " days overdue");
         }
         else{
             System.out.println("Book has been returned , thank you ");
         }
         book.setIsCheckedOut(true, -1);
     }
     public void  bookAlreadyCheckedOut(Book book){
         System.out.println("Sorry the book " + book.getTitle() + " is already "
                 + " checked out" + " it will be available on day "+ book.getDayCheckedOut()
         +getlengthOfCheckOutPeriod() + " .");
     }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //Adding a book int bookCollection
         Map<String,Book> bookCollection = new HashMap<String,Book>();
         Book LordOfRings = new Book("LORD_OF_RINGS",345,534);
         bookCollection.put("LORNGS" ,LordOfRings);
         LibraryCatalogue lbr  = new LibraryCatalogue(bookCollection);
         lbr.checkOut("LORNGS");
         lbr.nextDay();
         lbr.nextDay();
         lbr.checkOut("LORNGS");
         lbr.returnBook("LORNGS");
      
         
         
    }
    
}

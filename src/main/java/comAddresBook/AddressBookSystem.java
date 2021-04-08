package comAddresBook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookSystem {
    static HashMap<String, AddressBook> map = new HashMap();
    static Scanner sc;
    
    public static void main(String[] args) {
        
        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select the options: " + "\n" + "1.Add new Address Book" + "\n" + "2.Access the book" + "\n" + "3.Exit");
             sc = new Scanner(System.in);
            switch(sc.nextInt()) {
                case 1:
                    System.out.println("Enter the name for new book");
                     sc = new Scanner(System.in);
                    String bookName = sc.nextLine();
                    map.put(bookName, new AddressBook());
                    System.out.println(map.toString());
                    break;
                case 2:
                    System.out.println("Enter the book name in which you want to add contact");
                    sc = new Scanner(System.in);
                    String book = sc.nextLine();
                    if(map.containsKey(book)){
                        map.get(book).AddressBookMaker();
                        System.out.println(map.toString());
                    }
                    else{
                        System.out.println("Oops! The book is not there!");
                    }
                    break;
                default:
                    isExit = true;
            }
        }
    }
}

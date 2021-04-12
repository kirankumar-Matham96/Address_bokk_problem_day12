package comAddresBook;

import java.util.HashMap;
import java.util.Scanner;

/**
 * main class to maintain multiple contact books
 */
public class AddressBookSimulator14 {
    static HashMap<String, ContactManager> booksMap = new HashMap<>();
    
    /**
     * main method
     */
    public static void main(String[] args) {
        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Exit");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            
            switch(option) {
                case 1:
                    System.out.println("Enter the name of new book");
                    Scanner scanner1 = new Scanner(System.in);
                    String bookName = scanner1.nextLine();
                    booksMap.put(bookName, new ContactManager());
                    break;
                case 2:
                    System.out.println("Enter the name of new book to access it");
                    Scanner scanner2 = new Scanner(System.in);
                    Object bookName1 = scanner2.nextLine();
                    if(booksMap.containsKey(bookName1)) {
                        ContactManager contactManager = booksMap.get(bookName1);
                        contactManager.accessContact();
                        contactManager.getContactList();
                    }
                    break;
                default:
                    isExit = true;
                    System.out.println("Thanks for using Address Book Simulator!");
                    System.out.println(booksMap.toString());
                    scanner.close();
            }
        }
    }
}

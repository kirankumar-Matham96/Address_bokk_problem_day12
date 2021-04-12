package comAddresBook;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.search contact\n4.Exit");
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
                    System.out.println("Enter the name of the book to access it");
                    Scanner scanner2 = new Scanner(System.in);
                    Object bookName1 = scanner2.nextLine();
                    if(booksMap.containsKey(bookName1)) {
                        ContactManager contactManager = booksMap.get(bookName1);
                        contactManager.accessContact();
                        contactManager.getContactList();
                    }
                    break;
                case 3:
                    System.out.println("Enter the name to search");
                    Scanner scanner3 = new Scanner(System.in);
                    String name = scanner3.nextLine();
                    System.out.println(booksMap.values().stream().flatMap(book -> book.getContactList().stream().filter(contact -> contact.getSTATE().equals(name) || contact.getCITY().equals(name))).collect(Collectors.toList()));
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

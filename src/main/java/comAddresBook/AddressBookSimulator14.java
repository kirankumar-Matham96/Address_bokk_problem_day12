package comAddresBook;

import java.util.HashMap;

/**
 * main class to maintain multiple contact books
 */
public class AddressBookSimulator14 {
    HashMap<String, ContactManager> booksMap = new HashMap<>();
    
    /**
     * main method
     */
    public static void main(String[] args) {
        ScannerForUserInput scannerForUserInput = new ScannerForUserInput();
        AddressBookSimulator14 addressBookSimulator14 = new AddressBookSimulator14();
        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Search contact by first/last name\n" +
                                                 "4.Search contact by city/state\n5.Find number of contacts\n6.Exit");
            int option = scannerForUserInput.scannerInitializer().nextInt();
            switch(option) {
                case 1:
                    System.out.println("Enter the name of new book");
                    String bookName = scannerForUserInput.scannerInitializer().nextLine();
                    addressBookSimulator14.booksMap.put(bookName, new ContactManager());
                    break;
                case 2:
                    System.out.println("Enter the name of the book to access it");
                    Object bookName1 = scannerForUserInput.scannerInitializer().nextLine();
                    if(addressBookSimulator14.booksMap.containsKey(bookName1)) {
                        ContactManager contactManager = addressBookSimulator14.booksMap.get(bookName1);
                        contactManager.accessContact();
                    }
                    break;
                case 3:
                    System.out.println("Enter the first/last name to search");
                    String contactName = scannerForUserInput.scannerInitializer().nextLine();
                    addressBookSimulator14.booksMap.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey());
                        System.out.println(entry.getValue().getContactList().stream()
                                                .filter(contact -> contact.getFIRST_NAME().equals(contactName) ||
                                                        contact.getLAST_NAME().equals(contactName))
                                                .findFirst().orElse(null));
                    });
                    break;
                case 4:
                    System.out.println("Enter the city/state name to search");
                    String placeName = scannerForUserInput.scannerInitializer().nextLine();
                    addressBookSimulator14.booksMap.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey());
                        System.out.println(entry.getValue().getContactList().stream()
                                                .filter(contact -> contact.getCITY().equals(placeName) ||
                                                        contact.getSTATE().equals(placeName))
                                                .findFirst().orElse(null));
                    });
                    break;
                case 5:
                    System.out.println("Enter the city/state name to search number of contacts");
                    String placeName2 = scannerForUserInput.scannerInitializer().nextLine();
                    addressBookSimulator14.booksMap.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey());
                        System.out.println("same cities or states: " + entry.getValue().getContactList().stream()
                                                                            .filter(contact -> contact.getCITY().equals(placeName2) ||
                                                                                    contact.getSTATE().equals(placeName2))
                                                                            .count());
                    });
                    break;
                default:
                    isExit = true;
                    System.out.println("Thanks for using Address Book Simulator!");
                    scannerForUserInput.scannerInitializer().close();//closing scanner
            }
        }
    }
}

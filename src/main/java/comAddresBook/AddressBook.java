package comAddresBook;

import java.util.*;

public class AddressBook {
    //variables
    String first_name, last_name, address, city, state, email;
    int zip;
    long phone_number;
    Object object;
    List<Contact> contact;
    static AddressBook ab = new AddressBook();
    static Scanner sc;
    
    //method to edit details
    public void optionToUpdate(Object object) {
        Contact anObject = (Contact) object;
        sc = new Scanner(System.in);
        System.out.println("Which detail do you want to change?");
        System.out.println("1. first name" + "\n" + "2. last name" + "\n" + "3. address" + "\n" + "4. city" + "\n" + "5. state" + "\n" + "6. zip" + "\n" + "7. phone number" + "\n" + "8. email" + "\n" + "9. exit");
        int option = sc.nextInt();
        sc = new Scanner(System.in);
        switch(option) {
            case 1:
                System.out.println("Enter the first name:");
                anObject.setFIRST_NAME(sc.nextLine());
                break;
            case 2:
                System.out.println("Enter the last name: ");
                anObject.setLAST_NAME(sc.nextLine());
                break;
            case 3:
                System.out.println("Enter the Address: ");
                anObject.setADDRESS(sc.nextLine());
                break;
            case 4:
                System.out.println("Enter the city");
                anObject.setCITY(sc.nextLine());
                break;
            case 5:
                System.out.println("Enter the state");
                anObject.setSTATE(sc.nextLine());
                break;
            case 6:
                System.out.println("Enter the zip");
                anObject.setZIP(sc.nextInt());
                break;
            case 7:
                System.out.println("Enter the phone number");
                anObject.setPHONE_NUMBER(sc.nextLong());
                break;
            case 8:
                System.out.println("Enter the email");
                anObject.setEMAIL(sc.nextLine());
                break;
            default:
                System.out.println("Thank you");
        }
    }
    
    //method to delete contact
    public void toDelete(Contact contact) {
        ab.contact.remove(contact);
        System.out.println("Contact deleted successfully!");
        System.out.println(ab.contact);
    }
    
    //method to take user input
    public void takesInput() {
        sc = new Scanner(System.in);
        
        System.out.println("Enter first name");
        first_name = sc.nextLine();
        System.out.println("Enter last name");
        last_name = sc.nextLine();
        System.out.println("Enter address");
        address = sc.nextLine();
        System.out.println("Enter city");
        city = sc.nextLine();
        System.out.println("Enter state");
        state = sc.nextLine();
        System.out.println("Enter email");
        email = sc.nextLine();
        System.out.println("Enter zip");
        zip = sc.nextInt();
        System.out.println("Enter phone number");
        phone_number = sc.nextLong();
    }
    
    //method to search contact by name
    public static Contact streamSearch(String name) {
        Contact nameSearched = ab.contact.stream().filter(namePresent -> namePresent.getFIRST_NAME().equals(name) || namePresent.getLAST_NAME().equals(name)).findFirst().orElse(null);
        return nameSearched;
    }
    
    //main method
    public void AddressBookMaker() {
        AddressBook addressBook = new AddressBook();
        sc = new Scanner(System.in);
        
        
        
        sc = new Scanner(System.in);
        
        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select option: " + "\n" + "1.Add new contact" + "\n" + "2.Edit contact" + "\n" + "3.Delete contact" + "\n" + "4.exit");
            
            int option = sc.nextInt();
            switch(option) {
                case 1:
                    contact = new ArrayList<>();
                    ab.takesInput();
                    ab.object = new Contact(ab.first_name, ab.last_name, ab.address, ab.city, ab.state, ab.email, ab.zip, ab.phone_number);
                    contact.add((Contact) ab.object);//book
                    System.out.println("contact after adding: " + contact);
                    break;
                case 2:
                    System.out.println("Enter the name to edit contact");
                    Scanner sc = new Scanner(System.in);
                    Contact name = streamSearch(sc.next());
                    if(name == null) {
                        System.out.println("No contact found!");
                    } else {
                        addressBook.optionToUpdate(name);
                        System.out.println("After edited: " + contact);
                    }
                    break;
                case 3:
                    System.out.println("Enter the name to delete contact");
                    Scanner sc1 = new Scanner(System.in);
                    Contact name1 = streamSearch(sc1.next());
                    if(name1 == null) {
                        System.out.println("No contact found!");
                    } else {
                        addressBook.toDelete(name1);
                        System.out.println("after deleted: " + contact);
                    }
                    break;
                default:
                    isExit = true;
            }
        }
    }
    
    @Override
    public String toString() {
        return "AddressBook { " + "contact : " + contact + " " + '}';
    }
}

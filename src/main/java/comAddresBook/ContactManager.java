package comAddresBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Manages contact book details
 */
public class ContactManager {
    static List<Contact> contactList = new ArrayList<>();//contains all contacts
    
    /**
     * to get all the list of contacts in one book
     */
    public List<Contact> getContactList() {
        return contactList;
    }
    
    /**
     * to remove contact
     *
     * @param contact object of Contact class
     */
    public static void deleteContact(Contact contact) {
        contactList.remove(contact);
        System.out.println(contactList);
    }
    
    /**
     * edits the contact details of selected name
     */
    public static void editDetails() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Select option:" + "\n" + "1.first name" + "\n" + "2.last name" + "\n" + "3.address" + "\n" + "4.city" + "\n" + "5.state" + "\n" + "6.email" + "\n" + "7.zip" + "\n" + "8.phone number" + "\n" + "9.exit");
        
        switch(scanner.nextInt()) {
            case 1:
                System.out.println("Enter first name to change: ");
                Contact.setFIRST_NAME(scanner1.nextLine());
                break;
            case 2:
                System.out.println("Enter last name to change: ");
                Contact.setLAST_NAME(scanner1.nextLine());
                break;
            case 3:
                System.out.println("Enter new address to change: ");
                Contact.setADDRESS(scanner1.nextLine());
                break;
            case 4:
                System.out.println("Enter new city to change: ");
                Contact.setCITY(scanner1.nextLine());
                break;
            case 5:
                System.out.println("Enter new state to change: ");
                Contact.setSTATE(scanner1.nextLine());
                break;
            case 6:
                System.out.println("Enter new email to change: ");
                Contact.setEMAIL(scanner1.nextLine());
                break;
            case 7:
                System.out.println("Enter new zip to change: ");
                Contact.setZIP(scanner1.nextInt());
                break;
            case 8:
                System.out.println("Enter new phone number to change: ");
                Contact.setPHONE_NUMBER(scanner1.nextLong());
                break;
            default:
                System.out.println("Thank you!");
        }
        System.out.println(contactList);
    }
    
    /**
     * takes details from the user and adds them to the Contact.
     * Then adds the Contact to the list
     */
    public static void addContact() {
        Contact contact = new Contact();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name");
        contact.setFIRST_NAME(scanner.nextLine());
        
        System.out.println("Enter last name");
        contact.setLAST_NAME(scanner.nextLine());
        
        System.out.println("Enter address");
        contact.setADDRESS(scanner.nextLine());
        
        System.out.println("Enter city");
        contact.setCITY(scanner.nextLine());
        
        System.out.println("Enter state");
        contact.setSTATE(scanner.nextLine());
        
        System.out.println("Enter email");
        contact.setEMAIL(scanner.nextLine());
        
        System.out.println("Enter zip");
        contact.setZIP(scanner.nextInt());
        
        System.out.println("Enter phone number");
        contact.setPHONE_NUMBER(scanner.nextLong());
        
        contactList.add(contact);
        System.out.println(contactList);
    }
    
    /**
     * to access the book
     */
    public void accessContact() {
        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select option: \n1.Add Contact\n2.Edit Contact\n3.Delete Contact\n4.Find contact\n5.Exit");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch(option) {
                case 1:
                    if(!isContactExist(getName())) {
                        addContact();
                    } else {
                        System.out.println("Contact already exists!");
                    }
                    break;
                case 2:
                    if(isContactExist(getName())) {
                        editDetails();
                    } else {
                        System.out.println("Contact does not exists!");
                    }
                    break;
                case 3:
                    String name = getName();
                    if(isContactExist(name)) {
                        Contact contact = searchContact(name);
                        deleteContact(contact);
                    }
                case 4:
                    findContactOptions();
                    break;
                default:
                    System.out.println("Thanks!");
                    isExit = true;
            }
        }
    }
    
    /**
     * finds the contact by various means
     */
    private static void findContactOptions(){
        System.out.println("Select the option: \n1.find by contact name\n2.find by city/state\n3.exit");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        
        switch(option){
            case 1:
                String name1 = getName();
                if(isContactExist(name1)) {
                    Contact contact = searchContact(name1);
                    System.out.println("Contact " + name1 + ": " +contact);
                }else{
                    System.out.println("City/State does not exists!");
                }
                break;
            case 2:
                String name2 = getCityOrStateName();
                if(isCityOrStateExist(name2)) {
                    Contact contact = searchContactByCityOrState(name2);
                    System.out.println("Contact from city/state " + name2 + ": " +contact);
                }else{
                    System.out.println("City/State does not exists!");
                }
                break;
            default:
                System.out.println("Thank you!");
        }
    }
    
    /**
     * asks the user for name and returns it
     *
     * @return
     */
    private static String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter contact name");
        return scanner.nextLine();
    }
    
    /**
     * asks the user for name and returns it
     *
     * @return
     */
    private static String getCityOrStateName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city/state name");
        return scanner.nextLine();
    }
    
    /**
     * To find if contact exists or not
     *
     * @param name first or last name of the contact
     * @return true/false
     */
    private static boolean isContactExist(String name) {
        return contactList.stream().anyMatch(personElement -> personElement.getFIRST_NAME().equals(name) || personElement.getLAST_NAME().equals(name));
    }
    
    /**
     * checks the list for city/state
     * @param name city/state name given by user
     * @return true/false
     */
    private static boolean isCityOrStateExist(String name) {
        return contactList.stream().anyMatch(personElement -> personElement.getCITY().equals(name) || personElement.getSTATE().equals(name));
    }
    
    /**
     * To search the contact
     *
     * @param name first or last name of the contact
     * @return object of the Contact (Contact it self)
     */
    private static Contact searchContact(String name) {
        Contact foundContact = contactList.stream().filter(contact -> contact.getFIRST_NAME().equals(name) || contact.getLAST_NAME().equals(name)).findFirst().orElse(null);
        return foundContact;
    }
    
    private static Contact searchContactByCityOrState(String name){
        Contact foundContact = contactList.stream().filter(contact -> contact.getSTATE().equals(name) || contact.getCITY().equals(name)).findFirst().orElse(null);
    return foundContact;
    }
}

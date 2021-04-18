package comAddresBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages contact book details
 */
public class ContactManager {
    ScannerForUserInput scannerForUserInput = new ScannerForUserInput();
    List<Contact> contactList = new ArrayList<>();//contains all contacts
    
    /**
     * Initializes Contact class when new contact is added
     */
    public Contact initializer() {
        Contact contact = new Contact();
        return contact;
    }
    
    /**
     * to get all the list of contacts in one book
     */
    public List<Contact> getContactList() {
        return contactList;
    }
    
    @Override
    public String toString() {
        return "ContactManager{" + "contactList=" + contactList + '}';
    }
    
    /**
     * to remove contact
     *
     * @param contact object of Contact class
     */
    public void deleteContact(Contact contact) {
        contactList.remove(contact);
        System.out.println(contactList);
    }
    
    /**
     * edits the contact details of selected name
     */
    public void editDetails() {
        Contact contact = searchContact(getName());
        if(contact != null) {
            System.out.println("Select option:" + "\n" + "1.first name" + "\n" + "2.last name" + "\n" + "3.address" + "\n" + "4.city" + "\n" + "5.state" + "\n" + "6.email" + "\n" + "7.zip" + "\n" + "8.phone number" + "\n" + "9.exit");
            switch(scannerForUserInput.scannerInitializer().nextInt()) {
                case 1:
                    System.out.println("Enter new first name to change: ");
                    contact.setFirstName(scannerForUserInput.scannerInitializer().nextLine());
                    break;
                case 2:
                    System.out.println("Enter new last name to change: ");
                    contact.setLastName(scannerForUserInput.scannerInitializer().nextLine());
                    break;
                case 3:
                    System.out.println("Enter new address to change: ");
                    contact.setAddress(scannerForUserInput.scannerInitializer().nextLine());
                    break;
                case 4:
                    System.out.println("Enter new city to change: ");
                    contact.setCity(scannerForUserInput.scannerInitializer().nextLine());
                    break;
                case 5:
                    System.out.println("Enter new state to change: ");
                    contact.setState(scannerForUserInput.scannerInitializer().nextLine());
                    break;
                case 6:
                    System.out.println("Enter new email to change: ");
                    contact.setEmail(scannerForUserInput.scannerInitializer().nextLine());
                    break;
                case 7:
                    System.out.println("Enter new zip to change: ");
                    contact.setZip(scannerForUserInput.scannerInitializer().nextInt());
                    break;
                case 8:
                    System.out.println("Enter new phone number to change: ");
                    contact.setPhoneNumber(scannerForUserInput.scannerInitializer().nextLine());
                    break;
                default:
                    System.out.println("Thank you!");
            }
        }
        System.out.println(contactList);
    }
    
    /**
     * takes details from the user and adds them to the Contact.
     * Then adds the Contact to the list
     */
    public void addContact() {
        Contact contact = initializer();
        System.out.println("Enter first name");
        contact.setFirstName(scannerForUserInput.scannerInitializer().nextLine());
        
        System.out.println("Enter last name");
        contact.setLastName(scannerForUserInput.scannerInitializer().nextLine());
        
        System.out.println("Enter address");
        contact.setAddress(scannerForUserInput.scannerInitializer().nextLine());
        
        System.out.println("Enter city");
        contact.setCity(scannerForUserInput.scannerInitializer().nextLine());
        
        System.out.println("Enter state");
        contact.setState(scannerForUserInput.scannerInitializer().nextLine());
        
        System.out.println("Enter email");
        contact.setEmail(scannerForUserInput.scannerInitializer().nextLine());
        
        System.out.println("Enter zip");
        contact.setZip(scannerForUserInput.scannerInitializer().nextInt());
        
        System.out.println("Enter phone number");
        contact.setPhoneNumber(scannerForUserInput.scannerInitializer().nextLine());
        
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
            int option = scannerForUserInput.scannerInitializer().nextInt();
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
                    }else{
                        System.out.println("Contact does not exists!");
                    }
                    break;
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
    private void findContactOptions() {
        System.out.println("Select the option: \n1.find by contact name\n2.find by city/state\n3.exit");
        int option = scannerForUserInput.scannerInitializer().nextInt();
    
        switch(option) {
            case 1:
                String name1 = getName();
                if(isContactExist(name1)) {
                    Contact contact1 = searchContact(name1);
                    System.out.println("Contact " + name1 + ": " + contact1);
                } else {
                    System.out.println("Contact does not exists!");
                }
                break;
            case 2:
                String name2 = getCityOrStateName();
                if(isCityOrStateExist(name2)) {
                    Contact contact = searchContactByCityOrState(name2);
                    System.out.println("Contact from city/state " + name2 + ": " + contact);
                } else {
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
    private String getName() {
        System.out.println("Enter contact name");
        return scannerForUserInput.scannerInitializer().nextLine();
    }
    
    /**
     * asks the user for name and returns it
     *
     * @return
     */
    private String getCityOrStateName() {
        System.out.println("Enter city/state name");
        return scannerForUserInput.scannerInitializer().nextLine();
    }
    
    /**
     * To find if contact exists or not
     *
     * @param name first or last name of the contact
     * @return true/false
     */
        private boolean isContactExist(String name) {
        boolean existance;
            existance = contactList.stream()
                    .anyMatch(personElement ->
                            personElement.getFirstName().equals(name) ||
                                    personElement.getLastName().equals(name));
            return existance;
        }
    
    /**
     * checks the list for city/state
     *
     * @param name city/state name given by user
     * @return true/false
     */
    private boolean isCityOrStateExist(String name) {
        return contactList.stream()
                          .anyMatch(personElement ->
                                    personElement.getCity().equals(name) ||
                                            personElement.getState().equals(name));
    }
    
    /**
     * To search the contact
     *
     * @param name first or last name of the contact
     * @return object of the Contact (Contact it self)
     */
    private Contact searchContact(String name) {
        Contact foundContact = contactList.stream()
                .filter(contact -> contact.getFirstName().equals(name) ||
                        contact.getLastName().equals(name))
                .findFirst().orElse(null);
        return foundContact;
    }
    
    /**
     * to find contact by city/state
     *
     * @param name
     * @return
     */
    private Contact searchContactByCityOrState(String name) {
        Contact foundContact = contactList.stream()
                .filter(contact -> contact.getState().equals(name) ||
                        contact.getCity().equals(name))
                .findFirst().orElse(null);
        return foundContact;
    }
    
    
}

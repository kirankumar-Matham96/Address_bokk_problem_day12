package comAddresBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook
{
    //variables
    static String first_name, last_name, address, city, state, email;
    static int zip;
    static long phone_number;
    List<Contact> contact; //to store a contact
    AddressBookContactList abcl;
    Scanner sc;

    //method to edit details
    public void optionToUpdate(Object object)
    {
        Contact anObject = (Contact) object;
        sc = new Scanner(System.in);
        System.out.println("Which detail do you want to change?");
        System.out.println("1. first name" +"\n"+"2. last name"+"\n"+
                "3. address"+"\n"+"4. city"+"\n"+"5. state"+"\n"+
                "6. zip"+"\n"+"7. phone number"+"\n"+"8. email"+"\n"+
                "9. exit");
        int option =sc.nextInt();
        sc = new Scanner(System.in);
        switch(option)
        {
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
    public void toDelete(Contact contact)
    {
        abcl.removeList(contact);
        System.out.println("Contact deleted successfully!");
    }

    //main method
    public static void main(String[] args)
    {
        AddressBook ab = new AddressBook();

        /*
        Entering details to the Contact and adding it to address book
         */

        //Adding contact details manually
        Contact contact_1 = new Contact("Rahul","Mambrio",
                                    "Near police station","Hyderabad",
                                    "Kerala","rahul.mambrio@gmail.com",
                                        687847,8688332960L);
        ab.contact = new ArrayList<>();
        ab.contact.add(contact_1);


        ab.abcl = new AddressBookContactList(ab.contact);
        System.out.println(ab.abcl.getList());

        //Adding details from console
        ab.sc = new Scanner(System.in);

        System.out.println("Enter first name");
        first_name = ab.sc.nextLine();

        System.out.println("Enter your last name");
        last_name = ab.sc.nextLine();

        System.out.println("Enter your address");
        address = ab.sc.nextLine();

        System.out.println("Enter your city");
        city = ab.sc.nextLine();

        System.out.println("Enter your state");
        state = ab.sc.nextLine();

        System.out.println("Enter your email");
        email = ab.sc.nextLine();

        System.out.println("Enter your zip");
        zip = ab.sc.nextInt();

        System.out.println("Enter your phone number");
        phone_number = ab.sc.nextLong();

        Contact contact_2 = new Contact(first_name,last_name,address,city,state,email,zip,phone_number);

        ab.contact.add(contact_2);

        ab.abcl = new AddressBookContactList(ab.contact);

        //getting contact from the address book
        System.out.println(ab.abcl.getList());

        //to edit details
        System.out.println("Do you want to:"+"\n"+"1.edit details?"+"\n"+"2.delete contact?"+"\n"+"3.exit");
        ab.sc = new Scanner(System.in);
        int option = ab.sc.nextInt();

        if(option == 1)
        {
            System.out.println("Select contact to edit:"+"\n"+"1."+contact_1.getFIRST_NAME()+"\n"+"2."+contact_2.getFIRST_NAME()+"\n"+"3.none");
            int contactOption = ab.sc.nextInt();

            switch(contactOption )
            {
                case 1:
                    ab.optionToUpdate(contact_1);
                    break;
                case 2:
                    ab.optionToUpdate(contact_2);
                    break;
                default:
                    System.out.println("Thank you!");
            }
        }
        else if(option == 2)
        {
            System.out.println("Select contact to delete:"+"\n"+"1."+contact_1.getFIRST_NAME()+"\n"+"2."+contact_2.getFIRST_NAME()+"3.none");
            int contactOption = ab.sc.nextInt();

            switch(contactOption)
            {
                case 1:
                    ab.toDelete(contact_1);
                    break;
                case 2:
                    ab.toDelete(contact_2);
                    break;
                default:
                    System.out.println("Thank you!");
            }
        }
        else
        {
            System.out.println("Thank you!");
        }
        System.out.println(ab.abcl.getList());
    }
}

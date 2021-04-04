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
    List<Contact> details;
    Scanner sc;

    //method to add contact to a list
    public void addToList(Contact contact)
    {
        details = new ArrayList<>();
        details.add(contact);
    }

    //method to get contact details
    public List<Contact> getContact()
    {
        return details;
    }

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
    public void toDelete()
    {
        details.removeAll(details);
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
//        Contact contact_1 = new Contact("Rahul","Mambrio",
//                                    "Near police station","Hyderabad",
//                                    "Kerala","rahul.mambrio@gmail.com",zip,phone_number);
//        ab.addToList(contact_1);

        System.out.println(ab.getContact());

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

        ab.addToList(contact_2);

        //getting contact from the address book
        System.out.println(ab.getContact());

        //to edit details
        System.out.println("Do you want to:"+"\n"+"1.edit details?"+"\n"+"2.delete contact?"+"\n"+"3.exit");
        ab.sc = new Scanner(System.in);
        int option = ab.sc.nextInt();

        if(option == 1)
        {
            System.out.println("Select contact to edit:"+"\n"+"1."+first_name+"\n"+"2.none");
            int contactOption = ab.sc.nextInt();

            if(contactOption == 1)
            {
                ab.optionToUpdate(contact_2);
            }
        }
        else if(option == 2)
        {
            System.out.println("Select contact to delete:"+"\n"+"1."+first_name+"\n"+"2.none");
            int contactOption = ab.sc.nextInt();

            if(contactOption == 1)
            {
                ab.toDelete();
            }
        }
        System.out.println(ab.getContact());
    }
}

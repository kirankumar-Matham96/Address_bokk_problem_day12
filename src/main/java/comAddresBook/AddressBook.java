package comAddresBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook
{
    //variables
    static String first_name, last_name, address, city, state, email;
    static int zip;
    static long phone_number;
    ArrayList<Contact> al;

    //method to add contact to a list
    public void addToList(Contact contact)
    {
        al = new ArrayList<>();
        al.add(contact);
    }

    //method to get contact details
    public void getContact()
    {
        System.out.println(al.get(0));
    }

    //method to take user input
    public ArrayList userInput()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first name");
        first_name = sc.nextLine();

        System.out.println("Enter your last name");
        last_name = sc.nextLine();

        System.out.println("Enter your address");
        address = sc.nextLine();

        System.out.println("Enter your city");
        city = sc.nextLine();

        System.out.println("Enter your state");
        state = sc.nextLine();

        System.out.println("Enter your email");
        email = sc.nextLine();

        System.out.println("Enter your zip");
        zip = sc.nextInt();

        System.out.println("Enter your phone number");
        phone_number = sc.nextLong();

        ArrayList details = new ArrayList();
        details.add(first_name);
        details.add(last_name);
        details.add(address);
        details.add(city);
        details.add(state);
        details.add(email);
        details.add(zip);
        details.add(phone_number);

        return details;
    }

    //main method
    public static void main(String[] args)
    {
        AddressBook ab = new AddressBook();

        //entering details to the Contact
        ArrayList al = new ArrayList();
        al = ab.userInput();
        Contact member = new Contact((String)al.get(0),(String)al.get(1),(String)al.get(2),(String)al.get(3),
                                    (String)al.get(4),(String)al.get(5),(int)al.get(6),(long)al.get(7));

        //adding contact to the address book
        ab.addToList(member);

        //getting contact from the address book
        ab.getContact();
    }
}

package comAddresBook;

import java.util.ArrayList;

public class AddressBook
{
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

    //main method
    public static void main(String[] args)
    {
        Contact member = new Contact("Hello","There","Here it is","famous city","new state",543549,9848307659L,"hello@gmail.com");
        AddressBook ab = new AddressBook();
        ab.addToList(member);
        ab.getContact();
    }
}

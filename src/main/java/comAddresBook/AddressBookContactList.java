package comAddresBook;

import java.util.List;

public class AddressBookContactList
{
    List<Contact> list;

    public AddressBookContactList(List<Contact> contact)
    {
        list = contact;
    }

    public List<Contact> getList()
    {
        return list;
    }

    public void removeList(Contact contact)
    {
        list.remove(contact);
    }
}

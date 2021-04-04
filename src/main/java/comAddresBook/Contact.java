package comAddresBook;

public class Contact
{
    public final String FIRST_NAME;
    public final String LAST_NAME;
    public final String ADDRESS;
    public final String CITY;
    public final String STATE;
    public final int ZIP;
    public final long PHONE_NUMBER;
    public final String EMAIL;

    public Contact(String first_name, String last_name, String address, String city, String state, String email, int zip, long phone_number)
    {
        FIRST_NAME = first_name;
        LAST_NAME = last_name;
        ADDRESS = address;
        CITY = city;
        STATE = state;
        ZIP = zip;
        PHONE_NUMBER = phone_number;
        EMAIL = email;
    }

    @Override//to get details
    public String toString() {
        return "Contact{" +"\n"+
                "FIRST_NAME ='" + FIRST_NAME + '\'' +
                ","+"\n" +"LAST_NAME ='" + LAST_NAME + '\'' +
                ","+"\n"+"ADDRESS ='" + ADDRESS + '\'' +
                ","+"\n"+"CITY ='" + CITY + '\'' +
                ","+"\n"+"STATE ='" + STATE + '\'' +
                ","+"\n"+"ZIP =" + ZIP +
                ","+"\n"+"PHONE_NUMBER =" + PHONE_NUMBER +
                ","+"\n"+"EMAIL ='" + EMAIL + '\'' +"\n"+
                '}';
    }

}

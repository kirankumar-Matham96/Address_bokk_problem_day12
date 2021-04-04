package comAddresBook;

public class Contact
{
    public String FIRST_NAME;
    public String LAST_NAME;
    public String ADDRESS;
    public String CITY;
    public String STATE;
    public int ZIP;
    public long PHONE_NUMBER;
    public String EMAIL;

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

    /*
     * setters used to modify individual detail of a contact
     */
    public void setFIRST_NAME(String FIRST_NAME)
    {
        this.FIRST_NAME = FIRST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public void setZIP(int ZIP) {
        this.ZIP = ZIP;
    }

    public void setPHONE_NUMBER(long PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    /*
    * getters used to get individual details if needed
    */
    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getCITY() {
        return CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public int getZIP() {
        return ZIP;

    }
    public long getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public String getEMAIL() {
        return EMAIL;
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

package comAddresBook;

/**
 * POJO for contacts
 */
public class Contact {
    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String ADDRESS;
    private static String CITY;
    private static String STATE;
    private static String EMAIL;
    private static int ZIP;
    private static long PHONE_NUMBER;
    
    public String getFIRST_NAME()
    {
        return FIRST_NAME;
    }
    
    public static void setFIRST_NAME(String FIRST_NAME)
    {
        Contact.FIRST_NAME = FIRST_NAME;
    }
    
    public String getLAST_NAME()
    {
        return LAST_NAME;
    }
    
    public static void setLAST_NAME(String LAST_NAME)
    {
        Contact.LAST_NAME = LAST_NAME;
    }
    
    public String getADDRESS()
    {
        return ADDRESS;
    }
    
    public static void setADDRESS(String ADDRESS)
    {
        Contact.ADDRESS = ADDRESS;
    }
    
    public String getCITY()
    {
        return CITY;
    }
    
    public static void setCITY(String CITY)
    {
        Contact.CITY = CITY;
    }
    
    public String getSTATE()
    {
        return STATE;
    }
    
    public static void setSTATE(String STATE)
    {
        Contact.STATE = STATE;
    }
    
    public String getEMAIL()
    {
        return EMAIL;
    }
    
    public static void setEMAIL(String EMAIL)
    {
        Contact.EMAIL = EMAIL;
    }
    
    public int getZIP()
    {
        return ZIP;
    }
    
    public static void setZIP(int ZIP)
    {
        Contact.ZIP = ZIP;
    }
    
    public long getPHONE_NUMBER()
    {
        return PHONE_NUMBER;
    }
    
    public static void setPHONE_NUMBER(long PHONE_NUMBER)
    {
        Contact.PHONE_NUMBER = PHONE_NUMBER;
    }
    
    @Override
    public String toString()
    {
        return "Contact{" + "\n" + "FIRST_NAME = " + FIRST_NAME + "\n"+ "LAST_NAME = " +
                LAST_NAME  + "\n" + "ADDRESS = " + ADDRESS + "\n"+ "CITY = " + CITY + "\n"+
                "STATE = " + STATE + "\n" + "EMAIL = " + EMAIL + "\n" +
                "ZIP = " + ZIP + "\n" + "PHONE_NUMBER = " + PHONE_NUMBER + "\n" + '}';
    }
}

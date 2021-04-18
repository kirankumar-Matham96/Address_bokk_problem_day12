package comAddresBook;

import java.util.Objects;

/**
 * POJO for contacts
 */
public class Contact {
    private String FIRST_NAME;
    private String LAST_NAME;
    private String ADDRESS;
    private String CITY;
    private String STATE;
    private String EMAIL;
    private int ZIP;
    private String PHONE_NUMBER;
    
    public String getFIRST_NAME() {
        return FIRST_NAME;
    }
    
    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }
    
    public String getLAST_NAME() {
        return LAST_NAME;
    }
    
    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }
    
    public String getADDRESS() {
        return ADDRESS;
    }
    
    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }
    
    public String getCITY() {
        return CITY;
    }
    
    public void setCITY(String CITY) {
        this.CITY = CITY;
    }
    
    public String getSTATE() {
        return STATE;
    }
    
    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }
    
    public String getEMAIL() {
        return EMAIL;
    }
    
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
    
    public int getZIP() {
        return ZIP;
    }
    
    public void setZIP(int ZIP) {
        this.ZIP = ZIP;
    }
    
    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }
    
    public void setPHONE_NUMBER(String PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }
    
    @Override
    public String toString()
    {
        return "Contact{" + "\n" + "FIRST_NAME = " + FIRST_NAME + "\n"+ "LAST_NAME = " +
                LAST_NAME  + "\n" + "ADDRESS = " + ADDRESS + "\n"+ "CITY = " + CITY + "\n"+
                "STATE = " + STATE + "\n" + "EMAIL = " + EMAIL + "\n" +
                "ZIP = " + ZIP + "\n" + "PHONE_NUMBER = " + PHONE_NUMBER + "\n" + '}';
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(FIRST_NAME,LAST_NAME);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Contact contact = (Contact) obj;
        return Objects.equals(FIRST_NAME, contact.FIRST_NAME) && Objects.equals(LAST_NAME,contact.LAST_NAME);
    }
}

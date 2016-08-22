package webmail.entities;

/**
 * Created by JOKER on 12/2/14.
 */
public class Contacts {
    public int contactID;
    public String cAccount;
    public String cName;
    public String cEmail;
    public String cPhone;
    public Contacts(int contactID,String cAccount, String cName, String cEmail, String cPhone){
        this.contactID = contactID;
        this.cAccount = cAccount;
        this.cName = cName;
        this.cEmail = cEmail;
        this.cPhone = cPhone;
    }

    public int getContactID() {
        return contactID;
    }

    public String getcAccount() {
        return cAccount;
    }

    public String getcName() {
        return cName;
    }

    public String getcEmail() {
        return cEmail;
    }

    public String getcPhone() {
        return cPhone;
    }
}

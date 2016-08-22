package webmail.entities;

/**
 * Created by JOKER on 11/25/14.
 */
public class EmailAccount {
    public String ea_username;
    public String ea_address;
    public String ea_password;
    public EmailAccount(String ea_username, String ea_address, String ea_password){
        this.ea_username = ea_username;
        this.ea_address = ea_address;
        this.ea_password = ea_password;
    }
    public String getEA_username(){return ea_username;}
    public String getEA_address(){return ea_address;}
    public String getEA_password(){return ea_password;}

}

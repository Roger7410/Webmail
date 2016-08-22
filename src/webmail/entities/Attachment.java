package webmail.entities;

/**
 * Created by JOKER on 5/6/15.
 */
public class Attachment {
    private int attID;
    private String account;
    public String uID;    // wired
    private String attName;

    public Attachment(int attID, String account, String uID, String attName) {
        this.attID = attID;
        this.account = account;
        this.uID = uID;
        this.attName = attName;
    }

    public String getAccount() {
        return account;
    }

    public int getAttID() {
        return attID;
    }

    public String getuID() {
        return uID;
    }

    public String getAttName() {
        return attName;
    }




}

package webmail.entities;

/**
 * Created by JOKER on 4/30/15.
 */
public class Folder {

    private int folderID;
    private String emailAccount;
    private String folderName;
    public boolean in = false;


    public Folder(int folderID,String emailAccount, String folderName){
        this.folderID = folderID;
        this.emailAccount = emailAccount;
        this.folderName = folderName;
    }

    public int getFolderID() {
        return folderID;
    }

    public String getFolderName() {
        return folderName;
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public boolean getFolderIn(){ return in; }

    public void setFolderIn() { in = true; }
}

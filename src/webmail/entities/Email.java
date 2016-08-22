package webmail.entities;

/**
 * Created by JOKER on 11/28/14.
 */
public class Email {

    private int emailID;
    private String account;
    private String from;
    private String to;
    private String subject;
    private String contentTEXT;
    private String contentHTML;
    private boolean alreadyRead;
    private String uniqueID;
    private String folder;
    private String date;

    public Email(int emailID, String account, String from, String to, String subject, String contentTEXT, String contentHTML, boolean alreadyRead, String uniqueID, String folder, String date) {
        this.emailID = emailID;
        this.account = account;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.contentTEXT = contentTEXT;
        this.contentHTML = contentHTML;
        this.alreadyRead = alreadyRead;
        this.uniqueID = uniqueID;
        this.folder = folder;
        this.date = date;
    }

    public int getEmailID() {
        return emailID;
    }
    public String getAccount() {
        return account;
    }
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public String getContentTEXT() {
        return contentTEXT;
    }
    public String getSubject() {
        return subject;
    }
    public String getContentHTML() {
        return contentHTML;
    }
    public boolean isAlreadyRead() {
        return alreadyRead;
    }
    public String getUniqueID() {
        return uniqueID;
    }
    public String getFolder() {
        return folder;
    }
    public String getDate() {
        return date;
    }
}

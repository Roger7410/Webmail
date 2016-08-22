package webmail.entities;

public class SendAttachment {
    String contentType;
    String name;
    String encoding;
    String contentID;
    //        int emailID;
    byte[] content;
    int contentLength;

    String disposition;

    public SendAttachment(){}

    public SendAttachment(String contentType, String name, String encoding, String contentID, byte[] content, int contentLength,String disposition) {
        this.contentType = contentType;
        this.name = name;
        this.encoding = encoding;
        this.contentID = contentID;
        this.content = content;
        this.contentLength = contentLength;
        this.disposition = disposition;
    }

    public String getContentType() {
        return contentType;
    }

    public String getName() {
        return name;
    }

    public String getEncoding() {
        return encoding;
    }

    public String getContentID() {
        return contentID;
    }

//        public int getEmailID() {
//            return emailID;
//        }

    public byte[] getContent() {
        return content;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

//        public void setEmailID(int emailID) {
//            this.emailID = emailID;
//        }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getDisposition() {

        return disposition;
    }


}
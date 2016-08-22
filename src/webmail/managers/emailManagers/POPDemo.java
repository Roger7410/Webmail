package webmail.managers.emailManagers;

import javafx.scene.control.Cell;
import webmail.entities.Email;
import webmail.managers.otherManagers.ErrorManager;
import webmail.managers.otherManagers.SQLManager;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.*;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.io.File;
import java.io.IOException;

/**
 * Created by JOKER on 11/21/14.
 */
public class POPDemo {

    //static is not safe, need change later, add Set and Get func()   fix?
    //already remove all the statics
    private  String POPServer = "pop.gmail.com";
    private  int PORT = 995;

    private  String account;
    private  String account_pwd;
    private  String from;
    private  String to;
    private  String subject;
    private  String contentTEXT;
    private  String contentHTML;
    private  boolean alreadyRead;
    private  String uniqueID;
    private  String folder;
    private  String date;

    private  DataOutputStream dos = null;
    private  DataInputStream dis = null;
    private  SSLSocket s = null;
    private  int emailCount = 0;
    private  int i = 0;
    private  StringBuffer oneEmail;

    //attachment new, learn from internet
    private String saveAttachPath = ""; //the attachment saving path

    public String getAttachPath() {
        return saveAttachPath;
    }

    public void setAttachPath(String attachPath){
        this.saveAttachPath = attachPath;
    }

    //there is attachment or not
    public boolean isContainAttach(Part part) throws Exception {
        boolean attachflag = false;
        String contentType = part.getContentType();  //mark
        if (part.isMimeType("multipart/*")){
            Multipart mp = (Multipart) part.getContent();
            for(int i = 0; i<mp.getCount(); i++){
                BodyPart mpart = mp.getBodyPart(i);
                String disposition = mpart.getDisposition();
                if((disposition!=null)
                    && ((disposition.equals(Part.ATTACHMENT)) || (disposition.equals(Part.INLINE))))
                    attachflag = true;
                else if(mpart.isMimeType("mutipart/*")){
                    attachflag = isContainAttach((Part) mpart);  // mark
                }
                else {
                    String contype = mpart.getContentType();
                    if (contype.toLowerCase().contains("application")) // mark
                        attachflag = true;
                    if (contype.toLowerCase().contains("name"))
                        attachflag = true;
                }
            }
        }else if (part.isMimeType("message/rfc822")){
            attachflag = isContainAttach((Part) part.getContent());
        }
        return attachflag;
    }

    //save attachment
    public void saveAttachment(Part part) throws Exception {
        String fileName = "";
        if (part.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) part.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                BodyPart mpart = mp.getBodyPart(i);
                String disposition = mpart.getDisposition();
                if ((disposition != null)
                        && ((disposition.equals(Part.ATTACHMENT)) || (disposition
                        .equals(Part.INLINE)))) {  // dont need to think about inline now
                    fileName = mpart.getFileName();
                    if (fileName.toLowerCase().contains("gb2312")) {
                        fileName = MimeUtility.decodeText(fileName);
                    }
                    saveFile(fileName, mpart.getInputStream());
                } else if (mpart.isMimeType("multipart/*")) {
                    saveAttachment(mpart);
                } else {
                    fileName = mpart.getFileName();
                    if ((fileName != null)
                            && ((fileName.toLowerCase().contains("GB2312"))||(fileName.toLowerCase().contains("gb18030")))) {
                        fileName = MimeUtility.decodeText(fileName);
                        saveFile(fileName, mpart.getInputStream());
                    }
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            saveAttachment((Part) part.getContent());
        }
    }

    //save File
    private void saveFile(String fileName, InputStream in) throws Exception {
        SQLManager.addAttInfoSQL(account, uniqueID, fileName);   //add att info in to table attachment
        String osName = System.getProperty("os.name");//win or unix
        setAttachPath("staticFiles/attachments");
        String storedir = getAttachPath();
        String separator = "";
        if (osName == null)
            osName = "";
        if (osName.toLowerCase().contains("win")) {
            separator = "\\";
            if (storedir == null || storedir.equals(""))
                storedir = "c:\\tmp";
        } else {
            separator = "/";
            //storedir = "/tmp";
        }
        //create the path
        File path = new File(storedir + separator + account + separator + uniqueID);
        //     /tmp/attachment/account/uniqueID
        if (!path.exists()){
            if(!path.mkdirs()){
                System.err.println("fail to create path");
            }
        }
        //File storefile = new File(storedir + separator + fileName);
        File storefile = new File(path + separator + fileName);
        //System.out.println("storefile's path: " + storefile.toString());

        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(storefile));
            bis = new BufferedInputStream(in);
            int c;
            while ((c = bis.read()) != -1) {
                bos.write(c);
                bos.flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception("Saving file fail!");
        } finally {
            if (bos!=null){
                bos.close();
            }
            if ( bis!= null){
                bis.close();
            }
        }
    }

    public POPDemo(String account, String account_pwd){
        this.account = account;
        this.account_pwd = account_pwd;
    }

    public MimeMessage newMimeMessage(StringBuffer oneEmail) throws MessagingException {
        Properties properties=new Properties();
        Session session=Session.getDefaultInstance(properties);
        MimeMessage mimeMessage=new MimeMessage(session,new ByteArrayInputStream(oneEmail.toString().getBytes()));
        return mimeMessage;
    }
    public void getEmailInfo(MimeMessage mimeMessage) throws MessagingException, IOException, Exception {
//        InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();
//        String from2 = address[0].getAddress();
        //only handle < xxx >, not sure are there any other situations
        from= MimeUtility.decodeText(mimeMessage.getFrom()[0].toString());
        if(from.contains("<")){
            from = from.substring(from.indexOf('<') + 1, from.indexOf('>'));
        }

        to = mimeMessage.getRecipients(Message.RecipientType.TO)[0].toString();
        if(to.contains("<")){
            to = to.substring(to.indexOf('<')+1, to.indexOf('>'));
        }

        subject=mimeMessage.getSubject();

        Date d_date=mimeMessage.getSentDate();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = dateFormat.format(d_date);

        getContentTEXT_HTML(mimeMessage);
        getContent();
        //attachment
        if( isContainAttach(mimeMessage) ){
            saveAttachment(mimeMessage);
        }

        getAlreadyRead(mimeMessage);

    }

    //may need fix alreadyRead
    public void getAlreadyRead(MimeMessage mimeMessage) throws MessagingException {
        alreadyRead = false;
//        Flags flags = mimeMessage.getFlags();
//        Flags.Flag[] flag = flags.getSystemFlags();
//        System.out.println("flags's length: " + flag.length);
//        for (int i = 0; i < flag.length; i++) {
//            if (flag[i] == Flags.Flag.SEEN) {
//                alreadyRead = true;
//                System.out.println("seen Message.......");
//                break;
//            }
//        }
    }
    public void getUniqueID() throws IOException {
        dos.writeBytes("UIDL " + i +"\r\n");
        String tmp_uidl[] = dis.readLine().split(" ");
        uniqueID = tmp_uidl[2];
    }

    private StringBuilder content_text = new StringBuilder();//use text only for text and html
    private StringBuilder content_html = new StringBuilder();
    public void getContentTEXT_HTML(Part mimeMessage) throws MessagingException, IOException {

        if(mimeMessage.isMimeType("text/plain") && !mimeMessage.getContentType().contains("name")){
            content_text.append(mimeMessage.getContent().toString());
        }
        else if(mimeMessage.isMimeType("text/html") && !mimeMessage.getContentType().contains("name")){
            content_html.append(mimeMessage.getContent().toString());
        }
        else if(mimeMessage.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart)mimeMessage.getContent();
            for (int i = 0;i < multipart.getCount();i++){
//                if(multipart.getBodyPart(i).isMimeType("text/plain")){
//                    content_text.append(mimeMessage.getContent().toString());
//                }else if(multipart.getBodyPart(i).isMimeType("text/html")){
//                    content_html.append(mimeMessage.getContent().toString());
//                }else if(multipart.getBodyPart(i).isMimeType("multipart/*")){
//                    getContentTEXT_HTML(multipart.getBodyPart(i));
//                }
                getContentTEXT_HTML(multipart.getBodyPart(i));
            }
//            multipart.getBodyPart(0).getContent().toString();
//            content_text.append(multipart.getBodyPart(0).getContent().toString());
//            multipart.getBodyPart(1).getContent().toString();
//            content_html.append(multipart.getBodyPart(1).getContent().toString());
        }
//        if(content_text!=null){
//            contentTEXT = content_text.toString();
//        }
//        if(content_html!=null){
//            contentHTML = content_html.toString();
//        }
//        content_text = new StringBuilder();
//        content_html = new StringBuilder();
        //------------------ONLY THREE IF NOW, IF MULTIPART IN MULTIPART(HAVN'T FIND FOR NOW), USE recurrence, CHECK IT LATER!!!----------------
        //fix now
    }

    public void getContent(){
        if(content_text!=null){
            contentTEXT = content_text.toString();
        }
        if(content_html!=null){
            contentHTML = content_html.toString();
        }
    }

    public void newSSLSocketAndIOStream() throws IOException {
        SSLSocketFactory sf = (SSLSocketFactory)SSLSocketFactory.getDefault();
        s = (SSLSocket)sf.createSocket(POPServer,PORT);
        dos = new DataOutputStream(s.getOutputStream());
        dis = new DataInputStream(s.getInputStream());
    }
    public void connectToPOP() throws IOException {
        dis.readLine();
        dos.writeBytes("USER " + account + "\r\n");
        dis.readLine();
        dos.writeBytes("PASS " + account_pwd + "\r\n");
        dis.readLine();
    }
    public void getEmailCount() throws IOException {
        dos.writeBytes("STAT" + "\r\n");
        String ec_tmp[] = dis.readLine().split(" ");
        emailCount = Integer.parseInt(ec_tmp[1]);// Get how many emails in the box
    }
    public void retrEmail() throws IOException {

        dos.writeBytes("RETR " + i + "\r\n");
        dis.readLine();
    }
    public void storeEmailBodyInStringBuffer() throws IOException {
        oneEmail = new StringBuffer();
        while (true) {
            String body = dis.readLine();
            oneEmail.append(body + "\r\n");
            if (body.toLowerCase().equals(".")) {
                break;
            }
        }
    }
    public void getFolder(){
        folder = "INBOX";
        if(from.equals(account)){
            folder = "SENT";
            if( from.equals(to)){//account send to itself
                Email email = new Email(0, account, from, to, subject, contentTEXT, contentHTML, alreadyRead, uniqueID, "INBOX", date);
                SQLManager.addPOPInfoSQL(email);
            }
        }
    }
    public void handleEveryEmail() throws Exception {
        for ( i = 1; i < emailCount + 1; i++){
            retrEmail();
            //System.out.println("This is the " + i + "th email content");
            storeEmailBodyInStringBuffer();
            getUniqueID();
            MimeMessage mimeMessage = newMimeMessage(oneEmail);
            getEmailInfo(mimeMessage);
            getFolder();
            Email email = new Email(0, account, from, to, subject, contentTEXT, contentHTML, alreadyRead, uniqueID, folder, date);
            SQLManager.addPOPInfoSQL(email);
        }
    }
    public void quitConnection() throws IOException {
        dos.writeBytes("QUIT"+"\r\n");          //QUIT will update, means delete emails in pop server.
        dis.readLine();
    }
    public void close() throws IOException {
        dos.close();
        dis.close();
        s.close();
    }
    public void run() throws Exception {
        newSSLSocketAndIOStream();
        if(s!=null && dos!=null && dis!=null){
            connectToPOP();
            getEmailCount();
            handleEveryEmail();
            quitConnection();
        }
        //System.out.println("Success!");
    }
}

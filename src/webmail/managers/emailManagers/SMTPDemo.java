package webmail.managers.emailManagers;

import sun.misc.BASE64Encoder;
import webmail.entities.SendAttachment;

import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by JOKER on 11/13/14.
 */
public class SMTPDemo {

    private static String SMTPServer = "smtp.gmail.com";
    private static int PORT = 465;
    private static String from;
    private static String to;
    private static String subject;
    private static String content;
    private static String pwd;
    private static boolean containAtt = false;
    public static final String CRLF = "\r\n";
    public static List<SendAttachment> attachments = new ArrayList<SendAttachment>();
    public SMTPDemo(String from, String to, String subject,String content, String pwd){
        this.from=from;
        this.to=to;
        this.subject=subject;
        this.content=content;
        this.pwd=pwd;
    }
    public SMTPDemo(String from, String to, String subject,String content, String pwd, boolean containAtt, List<SendAttachment> attachments){
        this.from=from;
        this.to=to;
        this.subject=subject;
        this.content=content;
        this.pwd=pwd;
        this.containAtt=containAtt;
        this.attachments=attachments;
    }

    public void run() {
        DataOutputStream dos = null;
        DataInputStream dis = null;
        SSLSocket s = null;
        String username = new BASE64Encoder().encode(from.getBytes());
        String password = pwd;
        try{
            SSLSocketFactory sf = (SSLSocketFactory)SSLSocketFactory.getDefault();
            s = (SSLSocket)sf.createSocket(SMTPServer,PORT);
            dos = new DataOutputStream(s.getOutputStream());
            dis = new DataInputStream(s.getInputStream());
        }
        catch(UnknownHostException e){
            System.err.println("Dont know host!");
        }
        catch(IOException e){
            System.err.println("I/O wrong!");
        }

        if(s!=null && dos!=null && dis!=null){
            try{
                dis.readLine();
                dos.writeBytes("HELO\r\n");
                dis.readLine();
                dos.writeBytes("AUTH LOGIN\r\n");
                dis.readLine();
                dos.writeBytes(username+"\r\n");
                dis.readLine();
                dos.writeBytes(password+"\r\n");
                dis.readLine();
                dos.writeBytes("MAIL From: "+"<"+from+">"+"\r\n");
                dis.readLine();
                dos.writeBytes("RCPT To: "+"<"+to+">"+"\r\n");
                dis.readLine();
                dos.writeBytes("DATA"+"\r\n");
                dis.readLine();
                if (containAtt){
                    String message = null;
                    //create message for send
                    message = createMessage();
                    dos.write(message.getBytes());
                    //System.out.println(message);
                }
                else{
                    dos.writeBytes("Subject: "+subject+"\r\n");
                    dos.writeBytes("From: "+from+"\r\n");
                    dos.writeBytes("To: "+to+"\r\n");
                    dos.writeBytes("\r\n");
                    dos.writeBytes(content+"\r\n"); // message body
                }
                dos.writeBytes("\r\n.\r\n");
                dis.readLine();
                dos.writeBytes("QUIT\r\n");
                dis.readLine();

                dos.close();
                dis.close();
                s.close();
            }
            catch(UnknownHostException e){
                System.err.println("Trying to connect to unknown host: "+e);
            }
            catch(IOException e){
                System.err.println("IOException: "+e);
            }
        }
    }

    private String createMessage() {
        StringBuffer sb = new StringBuffer();
        sb.append("From: " + from  + CRLF);
        sb.append("To: " + to + CRLF);

        sb.append("Subject: " + subject + CRLF);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        sb.append("Date: ").append(sdf.format(Calendar.getInstance().getTime()));
        //SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        sb.append(CRLF);
        String boundary = "--_boundary_1234_" + System.currentTimeMillis();
        String boundaryNextPart = "--" + boundary;
        if (containAtt) {
            sb.append("Content-Type: ");
            //sb.append("multipart/alternative; boundary=\"");
            //try mixed
            sb.append("multipart/mixed; boundary=\"");
            sb.append(boundary).append("\"").append(CRLF).append(CRLF);
            sb.append(boundaryNextPart).append(CRLF);
        }
        //add content
        //addContent(sb);
        addHtmlContent(sb);
        //add attachment
        if (containAtt) {
            addAttachment(sb, attachments, boundaryNextPart);
        }


        return sb.toString();

    }

    private void addContent(StringBuffer sb) {
        if (content != null) {
            String charset = Charset.defaultCharset().name();
            sb.append("Content-Type: text/plain;charset=\"" + charset + "\"" + CRLF);
            sb.append("Content-Transfer-Encoding: base64" + CRLF + CRLF);
            sb.append(new BASE64Encoder().encode(content.getBytes()) + CRLF);
        }
    }

    private void addHtmlContent(StringBuffer sb) {
        if (content != null) {
            String charset = Charset.defaultCharset().name();
            sb.append("Content-Type: text/html;charset=\"" + charset + "\"" + CRLF);
            sb.append("Content-Transfer-Encoding: base64" + CRLF + CRLF);
            sb.append(new BASE64Encoder().encode(content.getBytes()) + CRLF);
        }
    }

    private void addAttachment(StringBuffer sb, List<SendAttachment> attachments, String boundaryNextPart) {

        for (int i = 0; i < attachments.size(); i++) {
            SendAttachment attachment = attachments.get(i);
            sb.append(CRLF);
            sb.append(boundaryNextPart).append(CRLF);
            sb.append("Content-Type: ");
            sb.append(getAttachmentContentType(attachment) + "; ");
            String filename = attachment.getName();
            sb.append("name=\"" + filename + "\"" + CRLF);
            sb.append("Content-Disposition: attachment; filename=\"" + filename + "\"" + CRLF);
            sb.append("Content-Transfer-Encoding: " + attachment.getEncoding() + CRLF + CRLF);
            String encoded = null;
            encoded = new BASE64Encoder().encode(attachment.getContent());
            sb.append(encoded + CRLF);

        }
        //end of this part
        sb.append(CRLF + boundaryNextPart + "--"+CRLF);

    }

    private String getAttachmentContentType(SendAttachment attachment) {
        String contentType = null;
        if (attachment.getContentType() == null) {
//            String filename = attachment.getName();
//            if(filename.lastIndexOf(".")!= -1){
//
//            }
            contentType = "application/octet-stream";
            attachment.setContentType(contentType);
        }
        return attachment.getContentType();
    }
}

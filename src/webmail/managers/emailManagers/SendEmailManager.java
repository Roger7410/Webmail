package webmail.managers.emailManagers;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sun.misc.Request;
import webmail.entities.Email;
import webmail.entities.FileUtil;
import webmail.entities.SendAttachment;
import webmail.entities.User;
import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.mail.Part;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;


/**
 * Created by JOKER on 11/26/14.
 */
public class SendEmailManager extends Manager {

    public SendEmailManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run() {
        HttpSession session = request.getSession();
        User su = (User)session.getAttribute("user");
        String username = su.getUsername();
//        String from = request.getParameter("from");
//        String to = request.getParameter("to");
//        String subject = request.getParameter("subject");
//        String content = request.getParameter("content");
        String to="";
        String from="";
        String subject="";
        String content="";

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File("/tmp"));//just for run
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // Parse the request
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        // Process the uploaded items
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();
            String name = item.getFieldName();
            if (item.isFormField()) {
                if (name.equals("to")) {
                    to = item.getString();
                } else if (name.equals("from")) {
                    from = item.getString();
                } else if (name.equals("subject")) {
                    subject = item.getString();
                } else if (name.equals("content")) {
                    content = item.getString();
                }
            }
        }

        //System.out.println(from+to+subject+content);

        String pwd= SQLManager.getEmailAccountPwdSQL(username, from);


        List<SendAttachment> attachments = new ArrayList<SendAttachment>();
        boolean containAtt = false;
        File uploadDir = new File("staticFiles/uploadTmp");
        File []tmpatts = uploadDir.listFiles();
        if (tmpatts != null) {
            for (File att : tmpatts) {
                if(!att.isFile())
                    continue;
                if(att.getName().substring(0,1).equals("."))
                    continue;
                //pass from smtp
                byte[] data = FileUtil.getBytesFromFile(att);
                int len = (int) att.length();
                String name = att.getName();
                SendAttachment satt = new SendAttachment();
                satt.setName(name);
                satt.setContent(data);
                satt.setContentLength(len);
                satt.setEncoding("base64");
                satt.setContentType("application/octet-stream");
                satt.setDisposition(Part.ATTACHMENT);
                attachments.add(satt);
                containAtt = true;
                //delete the file after reading it
                att.delete();
            }
        }
        if (containAtt){
            SMTPDemo smtp = new SMTPDemo(from,to,subject,content,pwd,containAtt,attachments);
            smtp.run();
        }else{
            SMTPDemo smtp = new SMTPDemo(from,to,subject,content,pwd);
            smtp.run();
        }
        //save email information into email Table.
        SQLManager.addSentEmailInfoSQL(from, from, to, subject, content);

        try {
            response.sendRedirect("/emailSendSuccess");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

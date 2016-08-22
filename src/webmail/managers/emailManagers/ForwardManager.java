package webmail.managers.emailManagers;

import webmail.entities.Email;
import webmail.entities.User;
import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JOKER on 11/29/14.
 */
public class ForwardManager extends Manager {

    public ForwardManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public String getUsername(){
        HttpSession session = request.getSession();
        User su = (User)session.getAttribute("user");
        String username = su.getUsername();
        return username;
    }
    public int getEmailID(){
        String tmp_emailID = request.getParameter("emailID");
        int int_emailID = Integer.parseInt(tmp_emailID);
        return int_emailID;
    }
    @Override
    public void run() {
        String username = getUsername();
        int int_emailID = getEmailID();
        Email email = SQLManager.getEmailInfoSQL(int_emailID);

        String from = email.getTo();//make from = user
        String to = request.getParameter("forward-to");
        String subject = email.getSubject();
        String contentTEXT = request.getParameter("ftextarea");
        String pwd= SQLManager.getEmailAccountPwdSQL(username,from);
        //run send email
        SMTPDemo smtp = new SMTPDemo(from,to,subject,contentTEXT,pwd);
        smtp.run();
        SQLManager.addSentEmailInfoSQL(from, from, to, subject, contentTEXT);

        try {
            response.sendRedirect("/emailSendSuccess");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

package webmail.managers.userManagers;


import sun.misc.BASE64Encoder;
import webmail.entities.EmailAccount;
import webmail.entities.User;
import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 11/9/14.
 */
public class UserAddEmailManager extends Manager {

    public UserAddEmailManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public EmailAccount getEmailAccount(){
        String ea_address = request.getParameter("email-address");
        String ea_password = request.getParameter("email-password");
        ea_password = new BASE64Encoder().encode(ea_password.getBytes());
        User user = (User)request.getSession().getAttribute("user");
        String ea_username = user.getUsername();
        EmailAccount ea = new EmailAccount(ea_username, ea_address, ea_password);
        return ea;
    }

    @Override
    public void run(){
        try {
            EmailAccount ea = getEmailAccount();
            if (ea.getEA_address().equals("") || ea.getEA_password().equals("")) {
                response.sendRedirect("files/error.html");
            }
            SQLManager.addEmailAccountSQL(ea);
            response.sendRedirect("/welcome");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //add into db





    }
}

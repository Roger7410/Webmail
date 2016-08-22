package webmail.managers.emailManagers;

import sun.misc.BASE64Decoder;
import webmail.entities.User;
import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JOKER on 11/28/14.
 */
public class CheckEmailManager extends Manager {

    public CheckEmailManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run() {
        try{
            HttpSession session = request.getSession();
            User su = (User)session.getAttribute("user");
            String username = su.getUsername();
            String account = (String)session.getAttribute("account");
            String pwd = SQLManager.getEmailAccountPwdSQL(username,account);
            pwd = new String(new BASE64Decoder().decodeBuffer(pwd));
            POPDemo pop = new POPDemo(account,pwd);
            pop.run();
            response.sendRedirect("/inbox");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

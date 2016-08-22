package webmail.managers.emailManagers;

import webmail.managers.userManagers.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JOKER on 11/27/14.
 */
public class AfterWelcomeBeforeInboxManager extends UserManager {

    public AfterWelcomeBeforeInboxManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public void addAccountSession(){
        HttpSession session = request.getSession();  //verify   change!!!
        session.setAttribute("account", request.getParameter("form-ea-address"));
//        String s = (String)session.getAttribute("account");
//        if ( s==null ) {
//            session.setAttribute("account", request.getParameter("form-ea-address"));  //use u here    su is fine
//        }
    }

    @Override
    public void run(){
        addAccountSession();
        try {
            response.sendRedirect("/inbox");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

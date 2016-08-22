package webmail.managers.userManagers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JOKER on 11/16/14.
 */
public class UserLogoutManager extends UserManager{

    public UserLogoutManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public static void logout(HttpSession session) {
        session.removeAttribute(SESSION_LOGGEDIN);
        session.removeAttribute(SESSION_MEMBER);
        session.removeAttribute(SESSION_ACCOUNT);
        session.invalidate();
    }

    @Override
    public void run(){
        //logout
        //User u = getUserInformation();
        HttpSession session = request.getSession();
        logout(session);
        try{
            response.sendRedirect("/login");
        }
        catch(IOException e){
            System.err.println(e);
        }
    }
}

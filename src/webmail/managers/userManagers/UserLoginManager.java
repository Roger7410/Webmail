package webmail.managers.userManagers;

import webmail.entities.User;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JOKER on 11/9/14.
 */
public class UserLoginManager extends UserManager {

    public UserLoginManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    //wired highlight
    public static void login(HttpSession session, User user) {
        session.setAttribute(SESSION_LOGGEDIN, "true");
        session.setAttribute(SESSION_MEMBER, user);
    }

    @Override
    public void run(){
        //user login
        User u = getUserInformation();
        boolean right = false;
        right = SQLManager.loginSQL(u);
        try {
            if (right) {
                //session   ??
                HttpSession session = sessionCreation();
                login(session, u);
                response.sendRedirect("/welcome");//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
            else {
                response.sendRedirect("files/error.html");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

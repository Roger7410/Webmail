package webmail.managers.ajaxManagers.registrationPageManagers;

import webmail.entities.User;
import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;
import webmail.managers.userManagers.UserLoginManager;
import webmail.managers.userManagers.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JOKER on 11/24/14.
 */
public class SubmitButtonManager extends UserManager {

    public SubmitButtonManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run(){
        //create user
        User u = getUserInformation();
        if(u.getUsername().equals("")){
            try {
                response.getWriter().write("plz input xxx");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SQLManager.registrationSQL(u);
        HttpSession session = sessionCreation();
        UserLoginManager.login(session, u);
        try{
            response.sendRedirect("/welcome");
        }
        catch(IOException e){
            System.err.println(e);
        }
    }

}

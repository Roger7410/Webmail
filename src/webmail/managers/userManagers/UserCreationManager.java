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
public class UserCreationManager extends UserManager {

    public UserCreationManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run(){
        //create user
        try {
            User u = getUserInformation();
            if (u.getUsername().equals("") || u.getPassword().equals("")) {
                response.sendRedirect("files/error.html");
            }
            SQLManager.registrationSQL(u);
            HttpSession session = sessionCreation();
            UserLoginManager.login(session, u);
            response.sendRedirect("/welcome");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}

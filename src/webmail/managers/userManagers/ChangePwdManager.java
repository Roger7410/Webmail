package webmail.managers.userManagers;

import webmail.entities.User;
import webmail.managers.otherManagers.MD5Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JOKER on 11/9/14.
 */
public class ChangePwdManager extends UserManager {

    public ChangePwdManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run(){
        String new_pwd = request.getParameter("new-pwd");
        User u = getUserInformation();
        boolean right;
        right = SQLManager.loginSQL(u);
        try {
            if (right) {
                if(new_pwd.length()<6){
                    response.sendRedirect("files/error.html");
                }
                new_pwd = MD5Manager.MD5(new_pwd);
                SQLManager.changePwdSQL(u.getUsername(),new_pwd);
                response.sendRedirect("/inbox");//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
